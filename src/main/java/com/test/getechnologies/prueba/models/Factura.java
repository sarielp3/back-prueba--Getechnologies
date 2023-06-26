package com.test.getechnologies.prueba.models;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Entity
@Table(name = "Factura")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Factura implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date fecha;

	private Double monto;
	
	private String idPersona;
	
	
}
