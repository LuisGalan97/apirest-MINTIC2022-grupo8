package com.apirest.main.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.main.dtos.UsuarioDTO;
import com.apirest.main.entity.Usuario;
import com.apirest.main.services.UsuarioService;
import com.apirest.main.validators.UsuarioValidator;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService; 
	
	@GetMapping(value="/usuarios")
	public ResponseEntity<List<UsuarioDTO>> findAll(){
		List<Usuario> usuarios = usuarioService.findAll();
		
		List<UsuarioDTO> usuariosDTO = usuarios.stream().map(usuario->{
			return UsuarioDTO.builder()
					.id(usuario.getId())
					.username(usuario.getUsername())
					.nombre(usuario.getNombre())
					.apellido(usuario.getApellido())
					.direccion(usuario.getDireccion())
					.email(usuario.getEmail())
					.password(usuario.getPassword())
					.build();
		}).collect(Collectors.toList());
		
		return new ResponseEntity<List<UsuarioDTO>>(usuariosDTO, HttpStatus.OK);
	}
	
	@GetMapping(value="/usuarios/{id}")
	public ResponseEntity<UsuarioDTO> findById(@PathVariable("id") Long id) {
		Usuario usuario = usuarioService.findById(id);
		
		UsuarioDTO usuarioDTO = UsuarioDTO.builder()
				.id(usuario.getId())
				.username(usuario.getUsername())
				.nombre(usuario.getNombre())
				.apellido(usuario.getApellido())
				.direccion(usuario.getDireccion())
				.email(usuario.getEmail())
				.password(usuario.getPassword())
				.build();
		
		return new ResponseEntity<UsuarioDTO>(usuarioDTO, HttpStatus.OK);
	}
	
	@PostMapping(value="/usuarios")
	public ResponseEntity<UsuarioDTO> create(@RequestBody Usuario usuario) {
		UsuarioValidator.save(usuario);
	
		Usuario newUsuario = usuarioService.create(usuario);
		
		UsuarioDTO newUsuarioDTO = UsuarioDTO.builder()
				.id(newUsuario.getId())
				.username(newUsuario.getUsername())
				.nombre(newUsuario.getNombre())
				.apellido(newUsuario.getApellido())
				.direccion(newUsuario.getDireccion())
				.email(newUsuario.getEmail())
				.password(newUsuario.getPassword())
				.build();
				
		return new ResponseEntity<UsuarioDTO>(newUsuarioDTO, HttpStatus.CREATED);
	}
	
	@PutMapping(value="/usuarios/{id}")
	public ResponseEntity<UsuarioDTO> update(@RequestBody Usuario usuario, @PathVariable("id") Long id) {
		UsuarioValidator.save(usuario);
		
		Usuario usuarioUpdated = usuarioService.update(usuario, id);
		
		UsuarioDTO usuarioUpdatedDTO = UsuarioDTO.builder()
				.id(usuarioUpdated.getId())
				.username(usuarioUpdated.getUsername())
				.nombre(usuarioUpdated.getNombre())
				.apellido(usuarioUpdated.getApellido())
				.direccion(usuarioUpdated.getDireccion())
				.email(usuarioUpdated.getEmail())
				.password(usuarioUpdated.getPassword())
				.build();
		
		return new ResponseEntity<UsuarioDTO>(usuarioUpdatedDTO, HttpStatus.OK);		
	}
	
	@DeleteMapping(value="/usuarios/{id}")
	public ResponseEntity<UsuarioDTO> delete(@PathVariable("id") Long id) {
		Usuario usuarioDeleted = usuarioService.delete(id);
		
		UsuarioDTO usuarioDeletedDTO = UsuarioDTO.builder()
				.id(usuarioDeleted.getId())
				.username(usuarioDeleted.getUsername())
				.nombre(usuarioDeleted.getNombre())
				.apellido(usuarioDeleted.getApellido())
				.direccion(usuarioDeleted.getDireccion())
				.email(usuarioDeleted.getEmail())
				.password(usuarioDeleted.getPassword())
				.build();
		
		return new ResponseEntity<UsuarioDTO>(usuarioDeletedDTO, HttpStatus.OK);
	}
}
