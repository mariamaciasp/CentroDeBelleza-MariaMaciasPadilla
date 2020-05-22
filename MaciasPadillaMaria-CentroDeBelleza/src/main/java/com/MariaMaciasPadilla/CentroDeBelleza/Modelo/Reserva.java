package com.MariaMaciasPadilla.CentroDeBelleza.Modelo;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Reserva {
	
	@Id @GeneratedValue
	private long numReserva;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd'T'HH:mm")
	private LocalDateTime fechaYhora;
	private double precio;
	
	
	@ManyToOne
	private Empleado empleado;
	
	@ManyToOne
	private Cliente cliente;
	
	
	public Reserva(LocalDateTime fechaYhora, double precio) {
		super();
		this.fechaYhora = fechaYhora;
		this.precio = precio;
	}

	public Reserva(LocalDateTime fechaYhora, double precio, Empleado empleado, Cliente cliente) {
		super();
		this.fechaYhora = fechaYhora;
		this.precio = precio;
		this.empleado = empleado;
		this.cliente = cliente;
	}
	
		
	@ManyToOne/*(fetch = FetchType.EAGER)
	@JoinTable(
			joinColumns = @JoinColumn(name="reserva_id"),
			inverseJoinColumns = @JoinColumn(name="tratamiento_id")
			)*/
	private Tratamiento tratamiento;
	
	
	/** MÉTODOS HELPERS - asociación muchos a muchos entre reserva y tratamiento**/
	/* No me sirven al cambiar la asociación a ManyToOne
	public void addTratamiento(Tratamiento t) {
		tratamientos.add(t);
		t.getReservas().add(this);
	}
	
	public void removeTratamiento(Tratamiento t) {
		tratamientos.remove(t);
		t.getReservas().remove(this);
	}*/
	
	

}
