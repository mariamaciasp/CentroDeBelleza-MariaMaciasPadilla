package com.MariaMaciasPadilla.CentroDeBelleza.Modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

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
	

	private static final long serialVersionUID = 1L;
	
	private String dni;
	private boolean esAdmin;
	
	
	public Empleado(String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String email,
			String password, String dni, boolean esAdmin) {
		super(nombre, apellidos, fechaNacimiento, telefono, email, password);
		this.dni = dni;
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
	
	// implementación de la seguridad por usuario
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	

}
