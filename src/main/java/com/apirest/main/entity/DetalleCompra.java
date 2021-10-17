package com.apirest.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name="detalle_compras")
public class DetalleCompra {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="id_compra")
	private Long idCompra;
	
	@Column(name="producto", nullable = false, length = 100)
	private String producto;
	
	@Column(name="precio")
	private Long precio;
	
	@Column(name="cantidad")
	private Long cantidad;
	
	@Column(name="total")
	private Long total;
	
}
