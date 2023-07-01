package com.unifil.vetprospect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifil.vetprospect.models.request.AuthenticationRequest;
import com.unifil.vetprospect.models.request.ClienteRequestDTO;
import com.unifil.vetprospect.models.response.AuthenticationResponse;
import com.unifil.vetprospect.service.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController extends BaseController {
	
	@Autowired
	private final AuthenticationService authService;

	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(@RequestBody ClienteRequestDTO clienteRequest) throws Exception {
		return ResponseEntity.ok(authService.register(clienteRequest));
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest authRequest) {
		return ResponseEntity.ok(authService.login(authRequest));
	}
	
	@GetMapping("/logout")
	public ResponseEntity<String> logout() {
		session.invalidate();
		return ResponseEntity.ok("logout realizado com sucesso");
	}
}
