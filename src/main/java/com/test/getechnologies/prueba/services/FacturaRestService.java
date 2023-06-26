package com.test.getechnologies.prueba.services;

import java.io.Serializable;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.getechnologies.prueba.models.Factura;
import com.test.getechnologies.prueba.repositories.FacturaRepository;

import jakarta.transaction.Transactional;

/**
 * @author VictorHugoAcostaHernandez
 */
@Service
public class FacturaRestService implements Serializable {
	private static Logger LOGGER = LoggerFactory.getLogger(FacturaRestService.class);
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private FacturaRepository facturaRepository;
	
	public ArrayList<Factura> findFacturasByPersona(String idPersona){
		LOGGER.info("identificacion persona: " + idPersona);
		return (ArrayList<Factura>) facturaRepository.findByIdPersona(idPersona);
	}
	
	@Transactional
	public Factura storeFactura(Factura newFactura) {
		LOGGER.info("fecha: " + newFactura.getFecha());
		LOGGER.info("monto: $" + newFactura.getMonto());
		LOGGER.info("identificacion persona: " + newFactura.getIdPersona());
		return facturaRepository.save(newFactura);
	}

}
