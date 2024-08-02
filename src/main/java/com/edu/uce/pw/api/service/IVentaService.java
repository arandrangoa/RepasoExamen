package com.edu.uce.pw.api.service;

import java.util.List;

import com.edu.uce.pw.api.repository.modelo.ProductoDTO;
import com.edu.uce.pw.api.repository.modelo.Venta;
import com.edu.uce.pw.api.service.to.ProductoTO;

public interface IVentaService {
	
	public void guardar(Venta venta);
	
	public void realizarVenta(List<ProductoDTO> productos, String cedula, Integer numeroVenta);
	

}
