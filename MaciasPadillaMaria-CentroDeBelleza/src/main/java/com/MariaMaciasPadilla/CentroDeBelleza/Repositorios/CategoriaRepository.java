package com.MariaMaciasPadilla.CentroDeBelleza.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Categoria;

public interface CategoriaRepository extends JpaRepository <Categoria, Long>{
	
	@Query("select distinct c from Categoria c left join fetch c.tratamientos")
	List <Categoria> findAllJoin();

}
