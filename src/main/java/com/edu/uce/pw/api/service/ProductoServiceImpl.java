package com.edu.uce.pw.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.uce.pw.api.repository.IProductoRepository;
import com.edu.uce.pw.api.repository.modelo.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoRepository iProductoRepository;
	
	@Override
	public void guardar(Producto producto) {
		// TODO Auto-generated method stub
		Producto pEncontrado=this.iProductoRepository.seleccionarPorCodigo(producto.getCodigoBarras());
		if(pEncontrado==null) {
			this.iProductoRepository.insertar(producto);
		}else {
			int stockAnt=pEncontrado.getStock();
			int stockNuev=producto.getStock();
			int stockActualizado=stockAnt+stockNuev;
			pEncontrado.setStock(stockActualizado);
			this.iProductoRepository.actualizar(pEncontrado);
		}
	
	}

	@Override
	public Producto consultarPorCodigo(String codigoBarras) {
		// TODO Auto-generated method stub
		return this.iProductoRepository.seleccionarPorCodigo(codigoBarras);
	}

	@Override
	public void modificar(Producto producto) {
		// TODO Auto-generated method stub
		this.iProductoRepository.actualizar(producto);
	}

}
