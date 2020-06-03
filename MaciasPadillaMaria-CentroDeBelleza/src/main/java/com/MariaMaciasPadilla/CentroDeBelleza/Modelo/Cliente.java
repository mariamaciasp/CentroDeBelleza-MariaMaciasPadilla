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
public class Cliente extends Usuario{
	
	
	private static final long serialVersionUID = 1L;
	
	
	public Cliente(String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String email,
			String password) {
		super(nombre, apellidos, fechaNacimiento, telefono, email, password);
	}
	
	
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="cliente")
	private List <Reserva> reservasC = new ArrayList <> ();
	
	public void addReservaC(Reserva r) {
		this.reservasC.add(r);
		r.setCliente(this);
	}
	
	public void removeReservaC(Reserva r) {
		this.reservasC.remove(r);
		r.setCliente(null);
	}
	
	// implementar método para la seguridad
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}


}
