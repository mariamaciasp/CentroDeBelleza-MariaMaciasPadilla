package com.MariaMaciasPadilla.CentroDeBelleza.Modelo;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@MappedSuperclass
public abstract class Usuario {
	
	@Id @GeneratedValue
	private long id;
	
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	private String telefono;
	private String email;
	
	
	public Usuario(String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String email) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.email = email;
	}


	

}
