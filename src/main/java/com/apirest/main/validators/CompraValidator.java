package com.apirest.main.validators;

import com.apirest.main.entity.Compra;

public class CompraValidator {
	public static void save(Compra compra) {
		if(compra.getComprador()==null || compra.getComprador().trim().isEmpty()) {
			throw new RuntimeException("No se ingreso un comprador");
		}
		
		if(compra.getFecha()==null || compra.getFecha().trim().isEmpty()) {
			throw new RuntimeException("No se ingreso una fecha");
		}
		
		if(compra.getTotalCompra()==null) {
			throw new RuntimeException("No se ingreso un totalCompra ");
		}
	}
}
