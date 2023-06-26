package com.test.getechnologies.prueba.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespuestaEliminar implements Serializable{
	 private String mensajeRespuesta;
}
