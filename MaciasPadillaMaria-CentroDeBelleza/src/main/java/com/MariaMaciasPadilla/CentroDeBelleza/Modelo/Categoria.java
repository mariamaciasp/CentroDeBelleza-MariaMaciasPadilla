package com.MariaMaciasPadilla.CentroDeBelleza.Modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Categoria {
	
	@Id @GeneratedValue
	private long id;
	
	private String nombre;
	
	public Categoria(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="categoria", cascade = CascadeType.ALL, orphanRemoval = true)
	private List <Tratamiento> tratamientos = new ArrayList <> ();
	
	
	public void addTratamiento(Tratamiento t) {
		t.setCategoria(this);
		this.tratamientos.add(t);
	}
	
	
	public void removeTratamiento(Tratamiento t) {
		this.tratamientos.remove(t);
		t.setCategoria(null);
	}
	
	
	
	
}
