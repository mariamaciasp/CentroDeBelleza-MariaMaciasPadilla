package com.MariaMaciasPadilla.CentroDeBelleza.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Empleado;

public interface EmpleadoRepository extends JpaRepository <Empleado, Long> {
	
	// esta consulta no tiene sentido en sí, se pone para que haya alguna, cuando me ponga con consultas
	// modificar esto y poner algo que me sirva y con más sentido. Sería un ejemplo, no válido en mi caso 
	// de las consultas
	//List <Cliente> findByFechaClienteBetween(LocalDate fechaClienteStart, LocalDate fechaClienteEnd);

}
