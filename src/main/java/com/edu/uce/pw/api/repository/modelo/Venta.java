package com.edu.uce.pw.api.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="venta")
public class Venta {
	
	@Id
	@GeneratedValue(generator ="seq_venta",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq_venta", sequenceName ="seq_venta",allocationSize = 1)
	@Column(name="vent_id")
	private Integer id;
	
	@Column(name="vent_numero_venta")
	private Integer numeroVenta;
	
	@Column(name="vent_cedula_liente")
	private String cedulaCliente;
	
	@Column(name="vent_total_venta")
	private BigDecimal totalVenta;
	
	@OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
	private List<DetalleVenta> detalles;

	
	//SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroVenta() {
		return numeroVenta;
	}

	public void setNumeroVenta(Integer numeroVenta) {
		this.numeroVenta = numeroVenta;
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCliente) {
		this.cedulaCliente = cedulaCliente;
	}

	public BigDecimal getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(BigDecimal totalVenta) {
		this.totalVenta = totalVenta;
	}

	public List<DetalleVenta> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleVenta> detalles) {
		this.detalles = detalles;
	}
	
	
	
	

}
