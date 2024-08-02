package com.edu.uce.pw.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uce.pw.api.repository.modelo.Producto;
import com.edu.uce.pw.api.service.IProductoService;

@RestController
@CrossOrigin
@RequestMapping(path = "/productos")
public class ProductoController {
	
	@Autowired
	private IProductoService iProductoService;
	
	//http://localhost:8081/API/v1.0/Facturacion/productos
	@PostMapping(produces = "application/json", consumes = "application/json")
	private ResponseEntity<Producto> guardar(@RequestBody Producto producto){
		HttpHeaders cabeceraPost = new HttpHeaders();
		cabeceraPost.add("mensaje_201", "Corresponde a la inserción de un recurso");
		this.iProductoService.guardar(producto);
		return ResponseEntity.status(201).body(producto);
	}
	
    // http://localhost:8081/API/v1.0/Facturacion/productos/{codigoBarras}
    @GetMapping(path = "/{codigoBarras}", produces = "application/json")
    public ResponseEntity<Producto> buscarPorCodigo(@PathVariable String codigoBarras) {
        Producto producto = this.iProductoService.consultarPorCodigo(codigoBarras);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
	
	

}
