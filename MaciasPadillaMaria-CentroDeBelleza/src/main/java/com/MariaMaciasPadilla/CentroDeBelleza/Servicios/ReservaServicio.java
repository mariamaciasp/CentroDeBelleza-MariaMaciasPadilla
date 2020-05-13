package com.MariaMaciasPadilla.CentroDeBelleza.Servicios;

import org.springframework.stereotype.Service;

import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Reserva;
import com.MariaMaciasPadilla.CentroDeBelleza.Repositorios.ReservaRepository;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.Base.BaseService;

@Service
public class ReservaServicio extends BaseService<Reserva, Long, ReservaRepository>{

	public ReservaServicio(ReservaRepository repo) {
		super(repo);
	}

}
