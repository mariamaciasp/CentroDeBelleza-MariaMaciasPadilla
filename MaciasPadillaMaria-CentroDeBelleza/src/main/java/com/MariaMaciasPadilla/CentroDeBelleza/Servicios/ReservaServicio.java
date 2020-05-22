package com.MariaMaciasPadilla.CentroDeBelleza.Servicios;

import org.springframework.stereotype.Service;

import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Reserva;
import com.MariaMaciasPadilla.CentroDeBelleza.Repositorios.ReservaRepository;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.Base.BaseService;

@Service
public class ReservaServicio extends BaseService<Reserva, Long, ReservaRepository>{

	//private List <Reserva> listaReservas = new ArrayList <Reserva>(); 

	public ReservaServicio(ReservaRepository repo) {
		super(repo);
		
		//listaReservas.add(new Reserva(LocalDate.of(2020, 8, 8), 20));	
		
	}



}
