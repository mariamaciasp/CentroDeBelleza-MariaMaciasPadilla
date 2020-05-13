package com.MariaMaciasPadilla.CentroDeBelleza.Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Reserva {
	
	@Id @GeneratedValue
	private long numReserva;
	
	private LocalDate fechaYhora;
	private double precio;
	
	
	@ManyToOne
	private Empleado empleado;
	
	@ManyToOne
	private Cliente cliente;
	
	
	public Reserva(LocalDate fechaYhora, double precio) {
		super();
		this.fechaYhora = fechaYhora;
		this.precio = precio;
	}

	public Reserva(LocalDate fechaYhora, double precio, Empleado empleado, Cliente cliente) {
		super();
		this.fechaYhora = fechaYhora;
		this.precio = precio;
		this.empleado = empleado;
		this.cliente = cliente;
	}
	
		
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			joinColumns = @JoinColumn(name="reserva_id"),
			inverseJoinColumns = @JoinColumn(name="tratamiento_id")
			)
	private List <Tratamiento> tratamientos = new ArrayList <> ();
	
	
	/** MÉTODOS HELPERS - asociación muchos a muchos entre reserva y tratamiento**/
	
	public void addTratamiento(Tratamiento t) {
		tratamientos.add(t);
		t.getReservas().add(this);
	}
	
	public void removeTratamiento(Tratamiento t) {
		tratamientos.remove(t);
		t.getReservas().remove(this);
	}
	
	

}
