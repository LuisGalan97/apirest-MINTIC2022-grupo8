package com.apirest.main.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CompraDTO {

	private Long id;
	private String comprador;
	private String fecha;
	private Long totalCompra;
	
}
