 package com.unifil.vetprospect.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.unifil.vetprospect.entity.Cliente;
import com.unifil.vetprospect.service.impl.ClienteServiceImpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
	
	@Autowired
	private final JwtService jwtService;
	
	@Autowired
	private final ClienteServiceImpl clienteService;
	
	@Autowired
	private final HttpSession session;

	@Override
	protected void doFilterInternal(
			@NonNull HttpServletRequest request, 
			@NonNull HttpServletResponse response, 
			@NonNull FilterChain filterChain)
			throws ServletException, IOException {
		final String authHeader = request.getHeader("Authorization");
		final String jwt;
		final String userEmail; 
		if (authHeader == null || !authHeader.startsWith("Bearer")) {
			filterChain.doFilter(request, response);
			return;
		}
		jwt = authHeader.substring("Bearer ".length());
		userEmail = jwtService.extractUsername(jwt);
		if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			Cliente userDetails = clienteService.loadUserByUsername(userEmail);
			if (jwtService.isTokenValid(jwt, userDetails)) {
				manageClienteSession(userDetails);
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
						userDetails,
						null,
						userDetails.getAuthorities());
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		
		filterChain.doFilter(request, response);
	}
	
	private void manageClienteSession(Cliente cliente) {
		final Object sessionCliente = session.getAttribute("cliente");
		if (null == sessionCliente) {
			session.setAttribute("cliente", cliente);
		}
	}
}
