package com.MariaMaciasPadilla.CentroDeBelleza.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Categoria;
import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Tratamiento;

public interface TratamientoRepository extends JpaRepository <Tratamiento, Long>{
	
	public List<Tratamiento> findByCategoria(Categoria categoria);
	
	@Query("select t from Tratamiento t where t.categoria.id = ?1")
	public List<Tratamiento> findByCategoriaId(Long categoriaId);
	
	@Query("select t.id from Tratamiento t")
	public List<Long> obtenerIds();
	
	@Query("select count(t) from Tratamiento t where t.categoria = ?1")
	public int findNumTratamientosByCategoria(Categoria categoria);
	
	
	

}
