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

import com.apirest.main.dtos.CompraDTO;
import com.apirest.main.entity.Compra;
import com.apirest.main.services.CompraService;
import com.apirest.main.validators.CompraValidator;

@RestController
public class CompraController {
	
	@Autowired
	private CompraService compraService; 
	
	@GetMapping(value="/compras")
	public ResponseEntity<List<CompraDTO>> findAll(){
		List<Compra> compras = compraService.findAll();
		
		List<CompraDTO> comprasDTO = compras.stream().map(compra->{
			return CompraDTO.builder()
					.id(compra.getId())
					.comprador(compra.getComprador())
					.fecha(compra.getFecha())
					.totalCompra(compra.getTotalCompra())
					.build();
		}).collect(Collectors.toList());
		
		return new ResponseEntity<List<CompraDTO>>(comprasDTO, HttpStatus.OK);
	}
	
	@GetMapping(value="/compras/{id}")
	public ResponseEntity<CompraDTO> findById(@PathVariable("id") Long id) {
		Compra compra = compraService.findById(id);
		
		CompraDTO compraDTO = CompraDTO.builder()
				.id(compra.getId())
				.comprador(compra.getComprador())
				.fecha(compra.getFecha())
				.totalCompra(compra.getTotalCompra())
				.build();
		
		return new ResponseEntity<CompraDTO>(compraDTO, HttpStatus.OK);
	}
	
	@PostMapping(value="/compras")
	public ResponseEntity<CompraDTO> create(@RequestBody Compra compra) {
		CompraValidator.save(compra);
	
		Compra newCompra = compraService.create(compra);
		
		CompraDTO newCompraDTO = CompraDTO.builder()
				.id(newCompra.getId())
				.comprador(newCompra.getComprador())
				.fecha(newCompra.getFecha())
				.totalCompra(newCompra.getTotalCompra())
				.build();
				
		return new ResponseEntity<CompraDTO>(newCompraDTO, HttpStatus.CREATED);
	}
	
	@PutMapping(value="/compras/{id}")
	public ResponseEntity<CompraDTO> update(@RequestBody Compra compra, @PathVariable("id") Long id) {
		CompraValidator.save(compra);
		
		Compra compraUpdated = compraService.update(compra, id);
		
		CompraDTO compraUpdatedDTO = CompraDTO.builder()
				.id(compraUpdated.getId())
				.comprador(compraUpdated.getComprador())
				.fecha(compraUpdated.getFecha())
				.totalCompra(compraUpdated.getTotalCompra())
				.build();
		
		return new ResponseEntity<CompraDTO>(compraUpdatedDTO, HttpStatus.OK);		
	}
	
	@DeleteMapping(value="/compras/{id}")
	public ResponseEntity<CompraDTO> delete(@PathVariable("id") Long id) {
		Compra compraDeleted = compraService.delete(id);
		
		CompraDTO compraDeletedDTO = CompraDTO.builder()
				.id(compraDeleted.getId())
				.comprador(compraDeleted.getComprador())
				.fecha(compraDeleted.getFecha())
				.totalCompra(compraDeleted.getTotalCompra())
				.build();
		
		return new ResponseEntity<CompraDTO>(compraDeletedDTO, HttpStatus.OK);
	}
}
