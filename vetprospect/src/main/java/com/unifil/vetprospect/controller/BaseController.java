package com.unifil.vetprospect.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.unifil.vetprospect.entity.Cliente;

import jakarta.servlet.http.HttpSession;

public class BaseController {
	
	@Autowired
	protected HttpSession session;
	
	public Cliente getCliente() {
		Object cliente = this.session.getAttribute("cliente");
		return cliente != null ? (Cliente) cliente : null;
	}
}
