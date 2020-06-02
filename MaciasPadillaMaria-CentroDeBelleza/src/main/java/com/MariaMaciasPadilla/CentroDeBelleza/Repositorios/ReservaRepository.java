package com.MariaMaciasPadilla.CentroDeBelleza.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Cliente;
import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{
	
	List<Reserva> findByCliente(Cliente cliente);


	
}
