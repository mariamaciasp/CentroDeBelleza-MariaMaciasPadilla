package com.MariaMaciasPadilla.CentroDeBelleza.Servicios;

import org.springframework.stereotype.Service;

import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.LineaDeReserva;
import com.MariaMaciasPadilla.CentroDeBelleza.Repositorios.LineaDeReservaRepository;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.Base.BaseService;

@Service
public class LineaDeReservaServicio extends BaseService <LineaDeReserva, Long, LineaDeReservaRepository>{
	
	public LineaDeReservaServicio(LineaDeReservaRepository repo) {
		super(repo);
	}

}
