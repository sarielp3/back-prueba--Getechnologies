package com.test.getechnologies.prueba.services;

import java.io.IOError;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.test.getechnologies.prueba.excepciones.ExcepcionAlReadyID;
import com.test.getechnologies.prueba.models.Factura;
import com.test.getechnologies.prueba.models.Persona;
import com.test.getechnologies.prueba.models.RespuestaEliminar;
import com.test.getechnologies.prueba.repositories.FacturaRepository;
import com.test.getechnologies.prueba.repositories.PersonaRepository;

import jakarta.transaction.Transactional;

/**
 * @author VictorHugoAcostaHernandez
 */
@Service
public class DirectorioRestService implements Serializable {
	 private static Logger LOGGER = LoggerFactory.getLogger(DirectorioRestService.class);
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private FacturaRepository facturaRepository;
	
	
	public ArrayList<Persona> findPersonaByIdentificacion(String identificacion) {
		LOGGER.info("identificacion: " + identificacion);
		return (ArrayList<Persona>) personaRepository.findByIdentificacion(identificacion);
	}
	
	public ArrayList<Persona> findPersonas(){
		return (ArrayList<Persona>) personaRepository.findAll();
	}
	
	@Transactional
	public RespuestaEliminar eliminarPersonaPorID(String id) {
		LOGGER.info("identificacion por eliminar: " + id);
		RespuestaEliminar mensaje = new RespuestaEliminar();
		ArrayList<Persona> existePersona = personaRepository.findByIdentificacion(id);
		if(existePersona.isEmpty()) {
			mensaje.setMensajeRespuesta("No existe persona con el parametro ingresado");
			return mensaje;
		}else {
			ArrayList<Factura> existenFacturas = facturaRepository.findByIdPersona(id);
			if(!existenFacturas.isEmpty()) {
				facturaRepository.deleteByIdPersona(id);
			}
			
			personaRepository.eliminarPersona(id);
			mensaje.setMensajeRespuesta("Persona eliminada correctamente");
			return mensaje;
		}
		
		
	}
	
	@Transactional
	public Persona storePersona(Persona newPersona) throws ExcepcionAlReadyID {
		LOGGER.info("nombre: " + newPersona.getNombre());
		LOGGER.info("apellido paterno: " + newPersona.getApellidoPaterno());
		LOGGER.info("apellido materno: " + newPersona.getApellidoMaterno());
		LOGGER.info("indentificacion: " + newPersona.getIdentificacion());
		ArrayList<Persona> existePersona = personaRepository.findByIdentificacion(newPersona.getIdentificacion());
		
		if(!existePersona.isEmpty()) {
			throw new ExcepcionAlReadyID("Ya existe una persona con el identificador ingresado");
		}
		
		return personaRepository.save(newPersona);
	}
	

}
