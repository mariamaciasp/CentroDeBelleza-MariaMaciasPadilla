package com.MariaMaciasPadilla.CentroDeBelleza.Servicios;

import org.springframework.stereotype.Service;

import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Empleado;
import com.MariaMaciasPadilla.CentroDeBelleza.Repositorios.EmpleadoRepository;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.Base.BaseService;

@Service
public class EmpleadoServicio extends BaseService <Empleado, Long, EmpleadoRepository>{
	

	public EmpleadoServicio(EmpleadoRepository repo) {
		super(repo);
		
	}
	
	

}
