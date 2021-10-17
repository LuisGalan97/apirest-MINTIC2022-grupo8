package com.apirest.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apirest.main.entity.Compra;
import com.apirest.main.repository.CompraRepository;

@Service
public class CompraService {

	@Autowired
	CompraRepository compraRepo;
	
	public List<Compra> findAll(){
		List<Compra> compras = compraRepo.findAll();
		
		return compras;
	}
	
	public Compra findById(Long id) {
		Compra compra = compraRepo.findById(id)
				.orElseThrow(()-> new RuntimeException("Compra no encontrada"));
	
		return compra;
	}
	
	@Transactional
	public Compra create(Compra compra) {
		Compra newCompra = compraRepo.save(compra);
		
		return newCompra;
	}
	
	@Transactional
	public Compra update(Compra compra, Long id) {
		Compra compraExiste = compraRepo.findById(id)
				.orElseThrow(()-> new RuntimeException("Compra no encontrada"));
		
		compraExiste.setComprador(compra.getComprador());
		compraExiste.setFecha(compra.getFecha());
		compraExiste.setTotalCompra(compra.getTotalCompra());
		
		compraRepo.save(compraExiste);
		
		return compraExiste;
	}
	
	@Transactional
	public Compra delete(Long id) {
		Compra compraExiste = compraRepo.findById(id)
				.orElseThrow(()-> new RuntimeException("Compra no encontrada"));
		
		compraRepo.delete(compraExiste);
		
		return compraExiste;
	}
}
