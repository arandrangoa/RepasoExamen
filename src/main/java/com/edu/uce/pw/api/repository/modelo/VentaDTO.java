package com.edu.uce.pw.api.repository.modelo;

import java.util.List;

public class VentaDTO {

    private Integer numeroVenta;
    private String cedula;
    private List<ProductoDTO> productos;

    // GETTERS AND SETTERS



    public String getCedula() {
        return cedula;
    }

    public Integer getNumeroVenta() {
		return numeroVenta;
	}

	public void setNumeroVenta(Integer numeroVenta) {
		this.numeroVenta = numeroVenta;
	}

	public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public List<ProductoDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoDTO> productos) {
        this.productos = productos;
    }
}
