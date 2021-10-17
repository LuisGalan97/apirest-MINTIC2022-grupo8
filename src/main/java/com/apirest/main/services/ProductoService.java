package com.apirest.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apirest.main.entity.Producto;
import com.apirest.main.repository.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository productoRepo;
	
	public List<Producto> findAll(){
		List<Producto> productos = productoRepo.findAll();
		
		return productos;
	}
	
	public Producto findById(Long id) {
		Producto producto = productoRepo.findById(id)
				.orElseThrow(()-> new RuntimeException("Producto no encontrado"));
	
		return producto;
	}
	
	@Transactional
	public Producto create(Producto producto) {
		Producto newProducto = productoRepo.save(producto);
		
		return newProducto;
	}
	
	@Transactional
	public Producto update(Producto producto, Long id) {
		Producto productoExiste = productoRepo.findById(id)
				.orElseThrow(()-> new RuntimeException("Producto no encontrado"));
		
		productoExiste.setNombre(producto.getNombre());
		productoExiste.setPrecio(producto.getPrecio());
		
		productoRepo.save(productoExiste);
		
		return productoExiste;
	}
	
	@Transactional
	public Producto delete(Long id) {
		Producto productoExiste = productoRepo.findById(id)
				.orElseThrow(()-> new RuntimeException("Producto no encontrado"));
		
		productoRepo.delete(productoExiste);
		
		return productoExiste;
	}
}
