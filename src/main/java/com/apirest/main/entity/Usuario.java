package com.apirest.main.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="username", nullable = false, length = 100)
	private String username;
	
	@Column(name="nombre", nullable = false, length = 100)
	private String nombre;
	
	@Column(name="apellido", nullable = false, length = 100)
	private String apellido;
	
	@Column(name="direccion", nullable = false, length = 100)
	private String direccion;
	
	@Column(name="email", nullable = false, length = 100)
	private String email;
	
	@Column(name="password", nullable = false, length = 100)
	private String password;
	
}
