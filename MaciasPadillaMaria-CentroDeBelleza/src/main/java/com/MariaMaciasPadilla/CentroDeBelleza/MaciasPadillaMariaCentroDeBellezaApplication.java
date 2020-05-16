package com.MariaMaciasPadilla.CentroDeBelleza;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Cliente;
import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Empleado;
import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Reserva;
import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Tratamiento;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.ReservaServicio;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.TratamientoServicio;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.UsuarioServicio;

@SpringBootApplication
public class MaciasPadillaMariaCentroDeBellezaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaciasPadillaMariaCentroDeBellezaApplication.class, args);
	}
	
	
	/*
	@Bean
	public CommandLineRunner init(UsuarioServicio servicio, PasswordEncoder passwordEncoder) {
		return args -> {
			
			Empleado emple = new Empleado();
			emple.setEmail("luismi.lopez@email.com");
			emple.setPassword(passwordEncoder.encode("1234"));
			emple.setFechaNacimiento(LocalDate.of(2010, 1, 1));
			
			servicio.save(emple);
			
			Cliente cliente = new Cliente();
			cliente.setEmail("angel.naranjo@email.com");
			cliente.setPassword(passwordEncoder.encode("1234"));
			cliente.setFechaNacimiento(LocalDate.of(1990, 1, 1));
			
			servicio.save(cliente);
			
			
		};
	}*/
	
	@Bean
	public CommandLineRunner init(UsuarioServicio servicio, PasswordEncoder passwordEncoder) {
		return args -> {
			
			Empleado emple = new Empleado();
			emple.setEmail("mariamaciaspadilla@gmail.com");
			emple.setPassword(passwordEncoder.encode("1234"));
			
			servicio.save(emple);
			
			Cliente cliente = new Cliente();
			cliente.setEmail("angel.naranjo@gmail.com");
			cliente.setPassword(passwordEncoder.encode("1234"));
			cliente.setFechaNacimiento(LocalDate.of(1990, 1, 1));
			
			servicio.save(cliente);
			
			
		};/*
	
	
	@Bean
	public CommandLineRunner init(TratamientoServicio tratamientoServicio, ReservaServicio reservaServicio) {
		return args -> {
			
			//agrego algunas reservas de ejemplo 
			reservaServicio.save(new Reserva(LocalDate.now(),20.0));
			reservaServicio.save(new Reserva(LocalDate.now(),10));
			
			List<Reserva> listaReservas = reservaServicio.findAll();
			
			for (Reserva r : listaReservas) {
				System.out.println(r);
			}
			System.out.println("\n");
			
			
			Tratamiento pelo = new Tratamiento("mechas","rubias",true);
			
			tratamientoServicio.save(pelo);
			
			/* ESTO YA NO ME SIRVE, Y LA MAYORÍA DEL EJEMPLO TAMPOCO, CAMBIO DE LA ASOCIACIÓN
			 * MANYTOONE A MANYTOMANY, POR LO QUE AHORA TENGO UNA LISTA DE TRATAMIENTOS ETC, MIRAR MEJOR, PERO ESTO DA ERROR
			 * 
			 * sería algo así
			 * Reserva(numReserva=2, fechaYhora=2020-05-13, precio=10.0, empleado=null, cliente=null, tratamientos=[])
			 * 
			 * for (Reserva r : listaReservas) {
				r.setTratamientos(tratamientos);;
				reservaServicio.edit(r);
			}*/
			/*
			System.out.println("\n---reservaServicio.findAll()---\n");
			listaReservas = reservaServicio.findAll();
			
			for (Reserva r : listaReservas) {
				System.out.println(r);
				
			}
			System.out.println("\n");
			
			Tratamiento unias = new Tratamiento("manicura","permanente", true);
		
			tratamientoServicio.save(unias);
			
			System.out.println("\\n---tratamientoServicio.findAll()---\\n");
			List<Tratamiento> listaTratamientos = tratamientoServicio.findAll();
			for (Tratamiento t : listaTratamientos) {
				System.out.println(t);
			}
			
		};*/
		
	}

}
