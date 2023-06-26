package com.test.getechnologies.prueba.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.getechnologies.prueba.excepciones.ExcepcionAlReadyID;
import com.test.getechnologies.prueba.models.Persona;
import com.test.getechnologies.prueba.models.RespuestaEliminar;
import com.test.getechnologies.prueba.services.DirectorioRestService;

@RestController
@RequestMapping("/directorio")
@CrossOrigin(origins = {"http://localhost:4200"} )
public class Directorio {
	@Autowired
	DirectorioRestService directorioRestService;
	
	@GetMapping(value="/find-by-identificacion/{identificacion}", produces = "application/json")
	public ArrayList<Persona> findPersonaByIdentificacion(@PathVariable String identificacion) throws IOException{
		if(identificacion == null) {
			throw new IOException("Parametros incompletos");   
    	}
		return directorioRestService.findPersonaByIdentificacion(identificacion);
	}
	
	@GetMapping(value="/all-personas", produces = "application/json")
	public ArrayList<Persona> findPersonas(){
		return directorioRestService.findPersonas();
	}
	
	@DeleteMapping(value="/delete-persona/{id}")
	public RespuestaEliminar deletePersonaByIdentificacion(@PathVariable("id") String id) {
		return directorioRestService.eliminarPersonaPorID(id);
	}
	
	@PostMapping(value="/insertar-persona")
	public Persona storePersona(@jakarta.validation.Valid @RequestBody Persona persona) throws ExcepcionAlReadyID {
		return this.directorioRestService.storePersona(persona);
	}

}
