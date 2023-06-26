package com.test.getechnologies.prueba.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.getechnologies.prueba.models.Factura;
import com.test.getechnologies.prueba.services.FacturaRestService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ventas")
@CrossOrigin(origins = {"http://localhost:4200"} )
public class Ventas {
	@Autowired
	FacturaRestService facturaRestService;
	
	@GetMapping(value="/find-facturas-by-persona/{idPersona}", produces = "application/json")
	public ArrayList<Factura> findFacturasByPersona(@PathVariable String idPersona){
		
		return facturaRestService.findFacturasByPersona(idPersona);
	}
	
	@PostMapping(value="/insertar-factura")
	public Factura storeFactura(@Valid @RequestBody Factura factura) {
		return this.facturaRestService.storeFactura(factura);
	}
}
