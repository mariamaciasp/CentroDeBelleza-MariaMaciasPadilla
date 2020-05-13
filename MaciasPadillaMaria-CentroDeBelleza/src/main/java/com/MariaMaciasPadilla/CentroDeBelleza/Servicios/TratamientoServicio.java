package com.MariaMaciasPadilla.CentroDeBelleza.Servicios;

import org.springframework.stereotype.Service;

import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Tratamiento;
import com.MariaMaciasPadilla.CentroDeBelleza.Repositorios.TratamientoRepository;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.Base.BaseService;

@Service
public class TratamientoServicio extends BaseService<Tratamiento, Long, TratamientoRepository>{

	public TratamientoServicio(TratamientoRepository repo) {
		super(repo);
	}

}
