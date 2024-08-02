package com.edu.uce.pw.api.service;

import com.edu.uce.pw.api.repository.modelo.Producto;

public interface IProductoService {

	public void guardar(Producto producto);
	
	public void modificar(Producto producto);
	
	public Producto consultarPorCodigo(String codigoBarras);
	
}
