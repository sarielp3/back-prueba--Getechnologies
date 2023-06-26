package com.test.getechnologies.prueba.models;

import java.io.Serializable;
import java.util.List;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Persona")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPersona;
	
	private String nombre;
	
	private String apellidoPaterno;
	
	private String apellidoMaterno;
	
	private String identificacion;
	
}
