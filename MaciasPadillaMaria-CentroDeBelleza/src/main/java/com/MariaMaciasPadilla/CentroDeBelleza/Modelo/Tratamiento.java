package com.MariaMaciasPadilla.CentroDeBelleza.Modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Tratamiento {
	
	@Id @GeneratedValue
	private long id;
	
	private String imagen;
	private String nombre;
	
	@Lob
	private String descripcion;
	private double precio;

	@ManyToOne(fetch = FetchType.EAGER)
	private Categoria categoria;
	
	public Tratamiento(String imagen, String nombre, String descripcion, double precio) {
		super();
		this.imagen = imagen;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	
	
	/*@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(mappedBy="tratamientos", fetch = FetchType.EAGER)
	private List <Reserva> reservas = new ArrayList <> ();
	*/
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="tratamiento", fetch = FetchType.EAGER)
	private List<Reserva> reservas = new ArrayList <> ();
	
	// Resto del código	
	
	public void addReserva(Reserva r) {
		this.reservas.add(r);
		r.setTratamiento(this);
	}
	
	public void removeReserva(Reserva r) {
		this.reservas.remove(r);
		r.setTratamiento(null);
	}
	

}
