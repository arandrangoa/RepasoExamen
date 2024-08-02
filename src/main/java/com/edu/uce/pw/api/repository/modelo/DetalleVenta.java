package com.edu.uce.pw.api.repository.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="detalleVenta")
public class DetalleVenta {
	
	@Id
	@GeneratedValue(generator ="seq_detalleVenta",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_detalleVenta", sequenceName ="seq_detalleVenta",allocationSize = 1)
	
	@Column(name="deta_id")
	private Integer id;
	
	@Column(name="deta_cantidad")
	private Integer cantidad;
	
	@Column(name="deta_precio_unitario")
	private BigDecimal precioUnitario;
	
	@Column(name="deta_subtotal")
	private BigDecimal subtotal;
	
	@ManyToOne
	@JoinColumn(name="deta_id_producto")
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name="deta_id_venta")
	private Venta venta;

	//GET Y SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}



	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	
	

}
