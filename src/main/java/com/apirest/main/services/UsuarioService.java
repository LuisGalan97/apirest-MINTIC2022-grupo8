package com.apirest.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apirest.main.entity.Usuario;
import com.apirest.main.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	public List<Usuario> findAll(){
		List<Usuario> usuarios = usuarioRepo.findAll();
		
		return usuarios;
	}
	
	public Usuario findById(Long id) {
		Usuario usuario = usuarioRepo.findById(id)
				.orElseThrow(()->new RuntimeException("Usuario no encontrado"));
	
		return usuario;
	}
	
	@Transactional
	public Usuario create(Usuario usuario) {
		Usuario newUsuario = usuarioRepo.save(usuario);
		
		return newUsuario;
	}
	
	@Transactional
	public Usuario update(Usuario usuario, Long id) {
		Usuario usuarioExiste = usuarioRepo.findById(id)
				.orElseThrow(()->new RuntimeException("Usuario no encontrado"));
		
		usuarioExiste.setUsername(usuario.getUsername());
		usuarioExiste.setNombre(usuario.getNombre());
		usuarioExiste.setApellido(usuario.getApellido());
		usuarioExiste.setDireccion(usuario.getDireccion());
		usuarioExiste.setEmail(usuario.getEmail());
		usuarioExiste.setPassword(usuario.getPassword());
		
		usuarioRepo.save(usuarioExiste);
		
		return usuarioExiste;
	}
	
	@Transactional
	public Usuario delete(Long id) {
		Usuario usuarioExiste = usuarioRepo.findById(id)
				.orElseThrow(()->new RuntimeException("Usuario no encontrado"));
		
		usuarioRepo.delete(usuarioExiste);
		
		return usuarioExiste;
	}
}
