package com.test.getechnologies.prueba.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.getechnologies.prueba.models.Factura;
import com.test.getechnologies.prueba.models.Persona;
import java.util.List;


@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
	ArrayList<Factura> findByIdPersona(String idPersona);
	
	void deleteByIdPersona(String idPersona);
}
