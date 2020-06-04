package com.MariaMaciasPadilla.CentroDeBelleza.Carrito;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Tratamiento;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.TratamientoServicio;

import lombok.RequiredArgsConstructor;

@Service
@SessionScope
@RequiredArgsConstructor
public class CarritoImpl implements Carrito{
	
	private Map<Tratamiento, Integer> tratamientosEnCarrito = new LinkedHashMap<>();
	private final TratamientoServicio tratamientoServicio;
	
		
	/**
	 * Añade un producto al carrito. 
	 * Si el producto ya estaba, incrementa en una unidad el nº de elementos
	 * Si no existe previamente, lo inserta con una unidad
	 * @param p
	 */
	@Override
	public void addToCarrito(Tratamiento t) {
		if (tratamientosEnCarrito.containsKey(t)) {
			tratamientosEnCarrito.put(t, tratamientosEnCarrito.get(t)+1);
		} else {
			tratamientosEnCarrito.put(t, 1);
		}
	}
	
	@Override
	public void addToCarrito(long id) {
		Tratamiento tratamiento = tratamientoServicio.findById(id);
		if (tratamiento != null) {
			addToCarrito(tratamiento);
		}
	}
	
	/**
	 *  Eliminar el producto del carrito
	 *  @param id
	 */
	@Override
	public void removeFromCarrito(Long id) {
		Tratamiento tratamiento = tratamientoServicio.findById(id);
		if (tratamiento != null) {
			removeFromCarrito(tratamiento);
		}
	}
	
	@Override
	public void removeFromCarrito(Tratamiento t) {
		tratamientosEnCarrito.remove(t);
	}
	
	/**
	 * Devuelve los productos del carrito en un Map que
	 * no se puede modificar
	 * NO QUEREMOS QUE NADIE CAMBIE ESTA COLECCIÓN
	 * DESDE FUERA DE LA CLASE; QUEREMOS QUE LO HAGA
	 * A TRAVÉS DE LOS MÉTODOS addToCarrito o removeFromCarrito
	 * @return
	 */
	@Override
	public Map<Tratamiento, Integer> getCarrito() {
		return Collections.unmodifiableMap(tratamientosEnCarrito);
	}
	
	/**
	 * Número de productos diferentes en el carrito
	 * @return
	 */
	@Override
	public int numeroTotalTratamientosDiferentes() {
		return tratamientosEnCarrito.size();
	}
	
	/**
	 * Número de unidades de productos en el carrito
	 * Si del producto P1 solicito una unidad, y de P2 solicito dos unidades
	 * este método debe devolver 3
	 * @return
	 */
	@Override
	public int numeroTotalDeUnidades() {
		int acumulador = 0;
		for(Tratamiento t : tratamientosEnCarrito.keySet()) {
			acumulador += tratamientosEnCarrito.get(t);
		}
		return acumulador;
	}
	
	@Override
	public int cantidadDeUnTratamiento(Tratamiento t) {
		int cant = 0;
		
		cant += tratamientosEnCarrito.get(t);
		
		return cant;
	}
	
	/**
	 * Importe total de lo que se incluye en el carrito.
	 * 
	 * @return
	 */
	@Override
	public float importeTotal() {
		float acumulador = 0.0f;
		for(Tratamiento t : tratamientosEnCarrito.keySet()) {
			acumulador += tratamientosEnCarrito.get(t) * t.getPrecio();
		}
		return acumulador;
		
	}

	@Override
	public void clear() {
		tratamientosEnCarrito.clear();
		
	}
	

}
