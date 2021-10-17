package com.apirest.main.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DetalleCompraDTO {

	private Long id;
	private Long idCompra;
	private String producto;
	private Long precio;
	private Long cantidad;
	private Long total;
	
}
