package com.MariaMaciasPadilla.CentroDeBelleza.Modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario implements UserDetails{
	
	// esto para que es?????????
	private static final long serialVersionUID = 1409538586158223652L; 

	@Id @GeneratedValue
	private long id;
	
	private String nombre;
	private String apellidos;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	
	private String telefono;
	
	// indico el username
	@Column(unique=true)
	private String email;
	
	private String password;
	
	
	public Usuario(String nombre, String apellidos, LocalDate fechaNacimiento, String telefono, String email,
			String password) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.email = email;
		this.password = password;
	}
	
	
	@Override
	public String getUsername() {	
		return email;
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}


	@Override
	public boolean isAccountNonLocked() {
		return true;
	}


	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}


	@Override
	public boolean isEnabled() {
		return true;
	}
	
	



	

}
