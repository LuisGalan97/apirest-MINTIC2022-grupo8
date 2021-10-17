package com.apirest.main.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UsuarioDTO {
	
	private Long id;
	private String username;
	private String nombre;
	private String apellido;
	private String direccion;
	private String email;
	private String password;
	
}