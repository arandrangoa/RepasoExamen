package com.edu.uce.pw.api.service.to;

import org.hibernate.boot.jaxb.hbm.internal.RepresentationModeConverter;
import org.springframework.hateoas.RepresentationModel;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


public class ProductoTO extends RepresentationModel implements Serializable{

	private static final long serialVersionUID = 706137684488762221L;
	
	private String codigoBarras;
	
	private Integer cantidad;
	
	private Double precio;

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
	

}
