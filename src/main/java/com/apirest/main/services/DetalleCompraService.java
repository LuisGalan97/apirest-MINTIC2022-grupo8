package com.apirest.main.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apirest.main.entity.DetalleCompra;
import com.apirest.main.repository.DetalleCompraRepository;

@Service
public class DetalleCompraService {
	
	@Autowired
	DetalleCompraRepository detalleCompraRepo;
	
	public List<DetalleCompra> findAll(){
		List<DetalleCompra> detalleCompras = detalleCompraRepo.findAll();
		
		return detalleCompras;
	}
	
	public DetalleCompra findById(Long id) {
		DetalleCompra detalleCompra = detalleCompraRepo.findById(id)
				.orElseThrow(()-> new RuntimeException("DetalleCompra no encontrado"));
	
		return detalleCompra;
	}
	
	@Transactional
	public DetalleCompra create(DetalleCompra detalleCompra) {
		DetalleCompra newDetalleCompra = detalleCompraRepo.save(detalleCompra);
		
		return newDetalleCompra;
	}
	
	@Transactional
	public DetalleCompra update(DetalleCompra detalleCompra, Long id) {
		DetalleCompra detalleCompraExiste = detalleCompraRepo.findById(id)
				.orElseThrow(()-> new RuntimeException("DetalleCompra no encontrado"));
		
		detalleCompraExiste.setIdCompra(detalleCompra.getIdCompra());
		detalleCompraExiste.setProducto(detalleCompra.getProducto());
		detalleCompraExiste.setPrecio(detalleCompra.getPrecio());
		detalleCompraExiste.setCantidad(detalleCompra.getCantidad());
		detalleCompraExiste.setTotal(detalleCompra.getTotal());
		
		detalleCompraRepo.save(detalleCompraExiste);
		
		return detalleCompraExiste;
	}
	
	@Transactional
	public DetalleCompra delete(Long id) {
		DetalleCompra detalleCompraExiste = detalleCompraRepo.findById(id)
				.orElseThrow(()-> new RuntimeException("DetalleCompra no encontrado"));
		
		detalleCompraRepo.delete(detalleCompraExiste);
		
		return detalleCompraExiste;
	}
}
