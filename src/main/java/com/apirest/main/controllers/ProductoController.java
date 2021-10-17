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

import com.apirest.main.dtos.ProductoDTO;
import com.apirest.main.entity.Producto;
import com.apirest.main.services.ProductoService;
import com.apirest.main.validators.ProductoValidator;

@RestController
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@GetMapping(value="/productos")
	public ResponseEntity<List<ProductoDTO>> findAll(){
		List<Producto> productos = productoService.findAll();
		
		List<ProductoDTO> productosDTO = productos.stream().map(producto->{
			return ProductoDTO.builder()
					.id(producto.getId())
					.nombre(producto.getNombre())
					.precio(producto.getPrecio())
					.build();
		}).collect(Collectors.toList());
		
		return new ResponseEntity<List<ProductoDTO>>(productosDTO, HttpStatus.OK);
	}
	
	@GetMapping(value="/productos/{id}")
	public ResponseEntity<ProductoDTO> findById(@PathVariable("id") Long id) {
		Producto producto = productoService.findById(id);
		
		ProductoDTO productoDTO = ProductoDTO.builder()
				.id(producto.getId())
				.nombre(producto.getNombre())
				.precio(producto.getPrecio())
				.build();
				
		return new ResponseEntity<ProductoDTO>(productoDTO, HttpStatus.OK);
	}
	
	@PostMapping(value="/productos")
	public ResponseEntity<ProductoDTO> create(@RequestBody Producto producto){
		ProductoValidator.save(producto);
		
		Producto newProducto = productoService.create(producto);
		
		ProductoDTO newProductoDTO = ProductoDTO.builder()
				.id(newProducto.getId())
				.nombre(newProducto.getNombre())
				.precio(newProducto.getPrecio())
				.build();
			
		return new ResponseEntity<ProductoDTO>(newProductoDTO, HttpStatus.CREATED);
	}
	
	@PutMapping(value="/productos/{id}")
	public ResponseEntity<ProductoDTO> update(@RequestBody Producto producto, @PathVariable("id") Long id) {
		ProductoValidator.save(producto);
		
		Producto productoUpdated = productoService.update(producto, id);
		
		ProductoDTO productoUpdatedDTO = ProductoDTO.builder()
				.id(productoUpdated.getId())
				.nombre(productoUpdated.getNombre())
				.precio(productoUpdated.getPrecio())
				.build();
			
		return new ResponseEntity<ProductoDTO>(productoUpdatedDTO, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/productos/{id}")
	public ResponseEntity<ProductoDTO> delete(@PathVariable("id") Long id) {
		Producto productoDeleted = productoService.delete(id);
		
		ProductoDTO productoDeletedDTO = ProductoDTO.builder()
				.id(productoDeleted.getId())
				.nombre(productoDeleted.getNombre())
				.precio(productoDeleted.getPrecio())
				.build();
		
		return new ResponseEntity<ProductoDTO>(productoDeletedDTO, HttpStatus.OK);
	}
}