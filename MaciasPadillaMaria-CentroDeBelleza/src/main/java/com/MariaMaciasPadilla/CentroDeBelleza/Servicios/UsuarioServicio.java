package com.MariaMaciasPadilla.CentroDeBelleza.Servicios;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Usuario;
import com.MariaMaciasPadilla.CentroDeBelleza.Repositorios.UsuarioRepository;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.Base.BaseService;

@Service
public class UsuarioServicio extends BaseService<Usuario, Long, UsuarioRepository>{

	public UsuarioServicio(UsuarioRepository repo) {
		super(repo);
	}
	
	// esto no se muy bien para que es
	public Optional<Usuario> buscarPorEmail (String email) {
		return repositorio.findFirstByEmail(email);
	}
	
	

}
