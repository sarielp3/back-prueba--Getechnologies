package com.test.getechnologies.prueba.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FOUND, reason = "Ya existe una persona con el identificador ingresado")
public class ExcepcionAlReadyID extends Exception{
	public ExcepcionAlReadyID(String mensaje) {
		super(mensaje);
	}
}
