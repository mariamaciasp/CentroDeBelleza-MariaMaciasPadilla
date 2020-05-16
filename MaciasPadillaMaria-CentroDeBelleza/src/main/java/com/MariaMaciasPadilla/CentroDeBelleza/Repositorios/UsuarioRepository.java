package com.MariaMaciasPadilla.CentroDeBelleza.Repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Cliente;
import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Usuario;

public interface UsuarioRepository extends JpaRepository <Usuario, Long> {
	
	Optional <Usuario> findFirstByEmail(String email);
	
	@Query("select u from Usuario u where TYPE(u) = Usuario")
	public List <Usuario> UsuarioNormal();

}
