package com.apirest.main.validators;

import com.apirest.main.entity.Producto;

public class ProductoValidator {
	public static void save(Producto producto) {
		if(producto.getNombre()==null || producto.getNombre().trim().isEmpty()) {
			throw new RuntimeException("No se ingreso un nombre");
		}
		
		if(producto.getPrecio()==null) {
			throw new RuntimeException("No se ingreso un precio");
		}
	}
}
