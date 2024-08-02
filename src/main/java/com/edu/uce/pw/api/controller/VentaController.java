package com.edu.uce.pw.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.uce.pw.api.repository.modelo.VentaDTO;
import com.edu.uce.pw.api.service.IVentaService;

@RestController
@CrossOrigin
@RequestMapping(path = "/ventas")
public class VentaController {
	
	 @Autowired
	    private IVentaService ventaService;

	    // Endpoint para realizar una venta
	    // http://localhost:8080/API/v1.0/Supermaxi/ventas/realizar
	    @PostMapping(path = "/realizar", produces = "application/json", consumes = "application/json")
	    public ResponseEntity<VentaDTO> realizarVenta(@RequestBody VentaDTO ventaDTO) {
	        this.ventaService.realizarVenta(ventaDTO.getProductos(), ventaDTO.getCedula(),ventaDTO.getNumeroVenta());
	        HttpHeaders cabeceraPost = new HttpHeaders();
	        cabeceraPost.add("mensaje_201", "Venta realizada con éxito");
	        return ResponseEntity.status(201).body(ventaDTO);
	    }

}
