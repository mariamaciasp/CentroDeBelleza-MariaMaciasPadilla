package com.MariaMaciasPadilla.CentroDeBelleza.Repositorios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, Long>{
	
	// esta consulta no tiene sentido en sí, se pone para que haya alguna, cuando me ponga con consultas
	// modificar esto y poner algo que me sirva y con más sentido. Sería un ejemplo, no válido en mi caso 
	// de las consultas
	// List <Cliente> findByFechaClienteBetween(LocalDate fechaClienteStart, LocalDate fechaClienteEnd);
	Cliente findFirstByEmail(String email);

}
