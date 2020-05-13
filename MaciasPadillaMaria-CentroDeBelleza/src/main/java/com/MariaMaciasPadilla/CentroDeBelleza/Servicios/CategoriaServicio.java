package com.MariaMaciasPadilla.CentroDeBelleza.Servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Categoria;
import com.MariaMaciasPadilla.CentroDeBelleza.Repositorios.CategoriaRepository;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.Base.BaseService;

@Service
public class CategoriaServicio extends BaseService <Categoria, Long, CategoriaRepository> {

	public CategoriaServicio(CategoriaRepository repo) {
		super(repo);
		
	}

	@Override
	public List<Categoria> findAll() {
		return this.repositorio.findAllJoin();
	}
	
	

}
