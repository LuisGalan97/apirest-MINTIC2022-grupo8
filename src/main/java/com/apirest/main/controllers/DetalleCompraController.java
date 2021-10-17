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

import com.apirest.main.dtos.DetalleCompraDTO;
import com.apirest.main.entity.DetalleCompra;
import com.apirest.main.services.DetalleCompraService;
import com.apirest.main.validators.DetalleCompraValidator;

@RestController
public class DetalleCompraController {
	@Autowired
	private DetalleCompraService detalleCompraService; 
	
	@GetMapping(value="/detallecompras")
	public ResponseEntity<List<DetalleCompraDTO>> findAll(){
		List<DetalleCompra> detalleCompras = detalleCompraService.findAll();
		
		List<DetalleCompraDTO> detalleComprasDTO = detalleCompras.stream().map(detalleCompra->{
			return DetalleCompraDTO.builder()
					.id(detalleCompra.getId())
					.idCompra(detalleCompra.getIdCompra())
					.producto(detalleCompra.getProducto())
					.precio(detalleCompra.getPrecio())
					.cantidad(detalleCompra.getCantidad())
					.total(detalleCompra.getTotal())
					.build();
		}).collect(Collectors.toList());
		
		return new ResponseEntity<List<DetalleCompraDTO>>(detalleComprasDTO, HttpStatus.OK);
	}
	
	@GetMapping(value="/detallecompras/{id}")
	public ResponseEntity<DetalleCompraDTO> findById(@PathVariable("id") Long id) {
		DetalleCompra detalleCompra = detalleCompraService.findById(id);
		
		DetalleCompraDTO detalleCompraDTO = DetalleCompraDTO.builder()
				.id(detalleCompra.getId())
				.idCompra(detalleCompra.getIdCompra())
				.producto(detalleCompra.getProducto())
				.precio(detalleCompra.getPrecio())
				.cantidad(detalleCompra.getCantidad())
				.total(detalleCompra.getTotal())
				.build();
		
		return new ResponseEntity<DetalleCompraDTO>(detalleCompraDTO, HttpStatus.OK);
	}
	
	@PostMapping(value="/detallecompras")
	public ResponseEntity<DetalleCompraDTO> create(@RequestBody DetalleCompra detalleCompra) {
		DetalleCompraValidator.save(detalleCompra);
	
		DetalleCompra newDetalleCompra = detalleCompraService.create(detalleCompra);
		
		DetalleCompraDTO newDetalleCompraDTO = DetalleCompraDTO.builder()
				.id(newDetalleCompra.getId())
				.idCompra(newDetalleCompra.getIdCompra())
				.producto(newDetalleCompra.getProducto())
				.precio(newDetalleCompra.getPrecio())
				.cantidad(newDetalleCompra.getCantidad())
				.total(newDetalleCompra.getTotal())
				.build();
				
		return new ResponseEntity<DetalleCompraDTO>(newDetalleCompraDTO, HttpStatus.CREATED);
	}
	
	@PutMapping(value="/detallecompras/{id}")
	public ResponseEntity<DetalleCompraDTO> update(@RequestBody DetalleCompra detalleCompra, @PathVariable("id") Long id) {
		DetalleCompraValidator.save(detalleCompra);
		
		DetalleCompra detalleCompraUpdated = detalleCompraService.update(detalleCompra, id);
		
		DetalleCompraDTO detalleCompraUpdatedDTO = DetalleCompraDTO.builder()
				.id(detalleCompraUpdated.getId())
				.idCompra(detalleCompraUpdated.getIdCompra())
				.producto(detalleCompraUpdated.getProducto())
				.precio(detalleCompraUpdated.getPrecio())
				.cantidad(detalleCompraUpdated.getCantidad())
				.total(detalleCompraUpdated.getTotal())
				.build();
		
		return new ResponseEntity<DetalleCompraDTO>(detalleCompraUpdatedDTO, HttpStatus.OK);		
	}
	
	@DeleteMapping(value="/detallecompras/{id}")
	public ResponseEntity<DetalleCompraDTO> delete(@PathVariable("id") Long id) {
		DetalleCompra detalleCompraDeleted = detalleCompraService.delete(id);
		
		DetalleCompraDTO detalleCompraDeletedDTO = DetalleCompraDTO.builder()
				.id(detalleCompraDeleted.getId())
				.idCompra(detalleCompraDeleted.getIdCompra())
				.producto(detalleCompraDeleted.getProducto())
				.precio(detalleCompraDeleted.getPrecio())
				.cantidad(detalleCompraDeleted.getCantidad())
				.total(detalleCompraDeleted.getTotal())
				.build();
		
		return new ResponseEntity<DetalleCompraDTO>(detalleCompraDeletedDTO, HttpStatus.OK);
	}
}
