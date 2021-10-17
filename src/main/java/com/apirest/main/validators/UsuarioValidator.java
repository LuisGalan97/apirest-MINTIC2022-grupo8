package com.apirest.main.validators;

import com.apirest.main.entity.Usuario;

public class UsuarioValidator {
	public static void save(Usuario usuario) {
		if(usuario.getUsername()==null || usuario.getUsername().trim().isEmpty()) {
			throw new RuntimeException("No se ingreso un username");
		}
		
		if(usuario.getNombre()==null || usuario.getNombre().trim().isEmpty()) {
			throw new RuntimeException("No se ingreso un nombre");
		}
		
		if(usuario.getApellido()==null || usuario.getApellido().trim().isEmpty()) {
			throw new RuntimeException("No se ingreso un apellido");
		}
		
		if(usuario.getDireccion()==null || usuario.getDireccion().trim().isEmpty()) {
			throw new RuntimeException("No se ingreso una direccion");
		}
		
		if(usuario.getEmail()==null || usuario.getEmail().trim().isEmpty()) {
			throw new RuntimeException("No se ingreso un email");
		}
		
		if(usuario.getPassword()==null || usuario.getPassword().trim().isEmpty()) {
			throw new RuntimeException("No se ingreso un password");
		}	
	}
}
