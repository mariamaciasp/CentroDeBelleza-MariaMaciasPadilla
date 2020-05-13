package com.MariaMaciasPadilla.CentroDeBelleza.Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
public class Empleado extends Usuario{
	
	
	private String dni;
	private double sueldo;
	private boolean esAdmin;
	
	
	public Empleado(String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String email,
			String dni, double sueldo, boolean esAdmin) {
		super(nombre, apellidos, fechaNacimiento, telefono, email);
		this.dni = dni;
		this.sueldo = sueldo;
		this.esAdmin = esAdmin;
	}
	

	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="empleado")
	private List <Reserva> reservasE = new ArrayList <> ();
	
	public void addReservaE(Reserva r) {
		this.reservasE.add(r);
		r.setEmpleado(this);
	}
	
	public void removeReservaE(Reserva r) {
		this.reservasE.remove(r);
		r.setEmpleado(null);
	}
	
	

}
