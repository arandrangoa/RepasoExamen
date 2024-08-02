package com.edu.uce.pw.api.repository;

import com.edu.uce.pw.api.repository.modelo.Producto;

public interface IProductoRepository {
	
	public void insertar(Producto producto);
	
	public void actualizar(Producto producto);
	
	public Producto seleccionarPorCodigo(String codigoBarras);
	

}
