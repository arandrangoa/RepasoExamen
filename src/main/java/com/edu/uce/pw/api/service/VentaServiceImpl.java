package com.edu.uce.pw.api.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.uce.pw.api.repository.IProductoRepository;
import com.edu.uce.pw.api.repository.IVentaRepository;
import com.edu.uce.pw.api.repository.modelo.DetalleVenta;
import com.edu.uce.pw.api.repository.modelo.Producto;
import com.edu.uce.pw.api.repository.modelo.ProductoDTO;
import com.edu.uce.pw.api.repository.modelo.Venta;
import com.edu.uce.pw.api.service.to.ProductoTO;

@Service
public class VentaServiceImpl implements IVentaService{

	@Autowired
	private IVentaRepository iVentaRepository;
	
	@Autowired
	private IProductoService iProductoService;;
	
	@Override
	public void guardar(Venta venta) {
		// TODO Auto-generated method stub
		this.iVentaRepository.insertar(venta);


}

	@Override
	public void realizarVenta(List<ProductoDTO> productos, String cedula, Integer numeroVenta) {
		// TODO Auto-generated method stub
		
		Venta v=new Venta();
		v.setNumeroVenta(numeroVenta);
		v.setCedulaCliente(cedula);
		
		List<DetalleVenta> detalles=new ArrayList<>();
		BigDecimal valorTotal = new BigDecimal(0);
		
		for(ProductoDTO pro: productos) {
			Producto p=this.iProductoService.consultarPorCodigo(pro.getCodigoBarras());
			
			DetalleVenta deta=new DetalleVenta();
			deta.setCantidad(pro.getCantidad());
			deta.setVenta(v);
			deta.setPrecioUnitario(p.getPrecio());
			deta.setProducto(p);
			
			if (p.getStock() >= pro.getCantidad()) {
				deta.setSubtotal(p.getPrecio().multiply(new BigDecimal(pro.getCantidad())));
				valorTotal = valorTotal.add(deta.getSubtotal());

				p.setStock(p.getStock() - pro.getCantidad());
				this.iProductoService.modificar(p);
			} else {
				throw new RuntimeException("Stock no disponible");
			}
			detalles.add(deta);
		}

		v.setDetalles(detalles);
		v.setTotalVenta(valorTotal);
		this.iVentaRepository.insertar(v);
		
	}
}
