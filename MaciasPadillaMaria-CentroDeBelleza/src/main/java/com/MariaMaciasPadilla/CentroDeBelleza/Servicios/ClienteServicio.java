package com.MariaMaciasPadilla.CentroDeBelleza.Servicios;

import org.springframework.stereotype.Service;

import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Cliente;
import com.MariaMaciasPadilla.CentroDeBelleza.Repositorios.ClienteRepository;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.Base.BaseService;

@Service
public class ClienteServicio extends BaseService <Cliente, Long, ClienteRepository>{

	public ClienteServicio(ClienteRepository repo) {
		super(repo);
		
	}
	
	public Cliente buscarPorEmail(String email) {
		return repositorio.findFirstByEmail(email);
	}

}
