package com.test.getechnologies.prueba.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.test.getechnologies.prueba.models.Persona;
import com.test.getechnologies.prueba.models.RespuestaEliminar;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
	ArrayList<Persona> findByIdentificacion(String identificacion);
	
	@Modifying
	@Query("DELETE FROM Persona v WHERE v.identificacion = :identificacion")
	void eliminarPersona(@Param("identificacion") String identificacion);
	
	@Modifying
	@Query("Delete FROM Factura v WHERE v.idPersona = :idPersona")
	void eliminarFacturas(@Param("idPersona") String idPersona);
	//void deleteByIdentificacion(String identificacion);

}
