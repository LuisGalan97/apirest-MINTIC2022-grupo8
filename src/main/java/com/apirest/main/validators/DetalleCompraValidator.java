package com.apirest.main.validators;

import com.apirest.main.entity.DetalleCompra;

public class DetalleCompraValidator {
	public static void save(DetalleCompra detalleCompra) {
		if(detalleCompra.getIdCompra()==null) {
			throw new RuntimeException("No se ingreso un idCompra");
		}
		
		if(detalleCompra.getProducto()==null || detalleCompra.getProducto().trim().isEmpty()) {
			throw new RuntimeException("No se ingreso un producto");
		}
		
		if(detalleCompra.getPrecio()==null) {
			throw new RuntimeException("No se ingreso un precio");
		}
		
		if(detalleCompra.getCantidad()==null) {
			throw new RuntimeException("No se ingreso una cantidad");
		}
		
		if(detalleCompra.getTotal()==null) {
			throw new RuntimeException("No se ingreso un total");
		}
	}
}
