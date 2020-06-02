package com.MariaMaciasPadilla.CentroDeBelleza.Servicios;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Categoria;
import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Tratamiento;
import com.MariaMaciasPadilla.CentroDeBelleza.Repositorios.TratamientoRepository;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.Base.BaseService;
import com.MariaMaciasPadilla.CentroDeBelleza.upload.DBStorageService;

@Service
public class TratamientoServicio extends BaseService<Tratamiento, Long, TratamientoRepository>{

	
	@Autowired
	private TratamientoRepository repositorio;
	
	/*public TratamientoServicio(TratamientoRepository repo) {
		super(repo);
	}*/
	
	public List<Tratamiento> findAllByCategoria(Categoria categoria) {
		return repositorio.findByCategoria(categoria);
	}
	
	public List<Tratamiento> findAllByCategoria(Long categoriaId) {
		return repositorio.findByCategoriaId(categoriaId);
	}
	
	
	private final DBStorageService dbStorageService;

	public TratamientoServicio(TratamientoRepository repo, 
			DBStorageService dbStoreService
			) {
		super(repo);
		this.dbStorageService = dbStoreService;
	}
	
	/**
	 * Método que permite guardar una entidad que tiene una imagen.
	 * 
	 * @param c
	 * @param imagen
	 * @return
	 */
	public Tratamiento save(Tratamiento t, MultipartFile imagen) {
		// Pasos a seguir
		
		// 1) Transformar la imagen en un String
		String pathImagen = dbStorageService.store(imagen);
		// 2) Asignar esta cadena de caracteres con nuestra entidad
		t.setImagen(pathImagen);
		// 3) Almacenarla
		return this.save(t);
	}

	/**
	 * Antes de eliminar nuestra entidad, tenemos que eliminar la imagen asociada.
	 */
	/*@Override
	public void delete(Tratamiento t) {
		String idImagen = t.getImagen();
		dbStorageService.delete(Long.valueOf(idImagen));
		super.delete(t);
	}*/

	/**
	 * Antes de eliminar nuestra entidad, tenemos que eliminar la imagen asociada.
	 */
	@Override
	public void deleteById(Long id) {
		Tratamiento tratamiento = findById(id);
		if (tratamiento != null)
			delete(tratamiento);
	}
	
	public List<Tratamiento> obtenerTratamientosAleatorios(int numero) {
		// Obtenemos los ids de todos los productos
		List<Long> listaIds = repositorio.obtenerIds();
		// Los desordenamos 
		Collections.shuffle(listaIds);
		// Nos quedamos con los N primeros, con N = numero.
		listaIds = listaIds.stream().limit(numero).collect(Collectors.toList());
		// Buscamos los productos con esos IDs y devolvemos la lista
		return repositorio.findAllById(listaIds);

	}
	
	public int numeroTratamientosCategoria(Categoria categoria) {
		return repositorio.findNumTratamientosByCategoria(categoria);
	}
	
	public List<Tratamiento> variosPorId(List<Long> ids) {
		return repositorio.findAllById(ids);
	}

}
