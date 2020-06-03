package com.MariaMaciasPadilla.CentroDeBelleza;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Categoria;
import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Cliente;
import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Empleado;
import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Reserva;
import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Tratamiento;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.CategoriaServicio;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.ReservaServicio;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.TratamientoServicio;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.UsuarioServicio;

@SpringBootApplication
public class MaciasPadillaMariaCentroDeBellezaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaciasPadillaMariaCentroDeBellezaApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner init(UsuarioServicio servicioUsuario, ReservaServicio servicioReserva, 
			CategoriaServicio servicioCategoria, TratamientoServicio servicioTratamiento, PasswordEncoder passwordEncoder) {
		return args -> {
			
			// Categorías
			
						Categoria peluqueria = new Categoria ("Peluquería");
						Categoria maquillaje = new Categoria ("Maquillaje");
						Categoria unias = new Categoria ("Uñas");
						Categoria depilacion = new Categoria ("Depilación");
						Categoria masaje = new Categoria ("Masaje");
						Categoria tratamientos = new Categoria ("Tratamientos");
						servicioCategoria.save(peluqueria);
						servicioCategoria.save(maquillaje);
						servicioCategoria.save(unias);
						servicioCategoria.save(depilacion);
						servicioCategoria.save(masaje);
						servicioCategoria.save(tratamientos);

						
						// Tratamientos
						// peluquería
						Tratamiento t1 = new Tratamiento ("//www.soy-de.com/images/thumbs/La-Alianza-de-Empresarios-de-Peluqueria-de-Espa%C3%B1a--0042936.jpeg","Corte de pelo","Melenas largas, medias melenas, corto todo vale para 2020. Disfruta de ucon ese peinado de siempre que tan bien te sienta. Todo y más en las mejores manos.", 15.00);
						Tratamiento t2 = new Tratamiento ("/img/tinte2.jpg","Tinte y mechas","Expertos en tintes, mechas, decolorados y una gran variedad de tratamientos para tu cabello. Creando un efecto impactante y a la vez natural.", 33.00);
						Tratamiento t3 = new Tratamiento ("/img/peinado.png","Lavado y peinado","Consigue ese peinado ideal para cualquier evento. Recogidos, semirecogidos o sueltos, te asesoramos para estar perfecta ese día especial.", 25.00);
						Tratamiento t4 = new Tratamiento ("/img/tratamientoCapilar.jpg","Tratamientos capilares","Todo tipo de tratamientos capilares para el cuidado de tu pelo, así como un asesoramiento personalizado. Consigue un pelo sano, cuidado y con brillo con nuestros tratamientos.", 55.00);
						
						List <Tratamiento> listaPeluqueria = Arrays.asList(t1, t2, t3, t4);
						
						for (Tratamiento t : listaPeluqueria) {
							servicioTratamiento.save(t);
						}
						
						for (Tratamiento t : listaPeluqueria) {
							peluqueria.addTratamiento(t);
							servicioTratamiento.edit(t);
				
						}
						
						// maquillaje
						Tratamiento t5 = new Tratamiento ("/img/novias.jpg","Maquillaje de novias","Disfruta de ese día tan especial con un maquillaje personalizado, sencillo y natural o si lo prefieres prueba con algo mágico y atrevido para ese gran día.", 70.00);
						Tratamiento t6 = new Tratamiento ("/img/maquillaje2.jpg","Maquillaje exprés (30 minutos)","Asiste a esa fiesta con un maquillaje casual y desenfadado. Sigue siendo más tú que nunca y con el mejor asesoramiento a tu disposición.", 25.00);
						Tratamiento t7 = new Tratamiento ("/img/maquillaje1.jpg","Maquillaje en 60 minutos","Elige un maquillaje personalizado para ese evento tan importante al que tienes que asistir este año. Contacta con nosotros para asesorarte si lo necesitas.", 45.00);
						
						List <Tratamiento> listaMaquillaje = Arrays.asList(t5, t6, t7);
						
						for (Tratamiento t : listaMaquillaje) {
							servicioTratamiento.save(t);
						}
						
						for (Tratamiento t : listaMaquillaje) {
							maquillaje.addTratamiento(t);
							servicioTratamiento.edit(t);
				
						}
						
						// uñas
						Tratamiento t8 = new Tratamiento ("/img/manicura.jpg","Manicura","Disfruta de unas uñas cuidadas con colores y diseños exclusivos. Elige entre una gran gama de colores desde los clásicos hasta las últimas tendencias de la temporada.", 35.00);
						Tratamiento t9 = new Tratamiento ("/img/pedicura.jpg","Pedicura","Ten tus pies cuidados y en perfecto estado en cualquier época del año. Luce tus pies con diseños exclusivos.", 25.00);
						
						List <Tratamiento> listaUnias = Arrays.asList(t8, t9);
						
						for (Tratamiento t : listaUnias) {
							servicioTratamiento.save(t);
						}
						
						for (Tratamiento t : listaUnias) {
							unias.addTratamiento(t);
							servicioTratamiento.edit(t);
				
						}
						
						
						// depilación
						Tratamiento t10 = new Tratamiento ("/img/depilacionCera.jpg","Depilación con cera","Si busca una depilación de piernas, axilas o ingles, la cera es la mejor técnica semipermanente relativamente indolora con un resultado garantizado de hasta cuatro semanas.", 18.00);
						Tratamiento t11 = new Tratamiento ("/img/depilacionLaser.jpg","Depilación laser","Con nuestro método único y eficaz dile adiós al pelo para siempre. Opta por esta cómoda solución para librarte permanentemente del pelo.", 40.00);
						Tratamiento t12 = new Tratamiento ("/img/depilacionHilo.jpg","Depilación con hilo","Esta nueva nueva técnica de depilación es la más usadas de entre las 'celebrities' y además tiene una gran cantidad de beneficios para la piel.", 15.00);
						
						List <Tratamiento> listaDepilacion = Arrays.asList(t10, t11, t12);
						
						for (Tratamiento t : listaDepilacion) {
							servicioTratamiento.save(t);
						}
						
						for (Tratamiento t : listaDepilacion) {
							depilacion.addTratamiento(t);
							servicioTratamiento.edit(t);
				
						}
						
						// masaje
						Tratamiento t13 = new Tratamiento ("/img/masajeRelajante.jpg","Masaje relajante","Desde nuestro centro queremos que te sientas bien, y para ello te ofrecemos masajes para eliminar el estres de la rutina diaria y relajar esas partes del cuerpo que se encuentran mas cargadas.", 30.00);
						Tratamiento t14 = new Tratamiento ("/img/masajePareja.jpg","Masaje en pareja","Disfruta del mejor masaje en la mejor compañía posible. Desconectar de la rutina diaria es más fácil si lo haces en buena compañía.", 60.00);
						Tratamiento t15 = new Tratamiento ("/img/masajeTailandes.jpg","Masaje tailandés","El masaje tailandés forma parte de una verdadera filosofía de vida en Tailandia, y se inspira en prácticas relajantes milenarias como el yoga y la meditación.", 40.00);
						Tratamiento t16 = new Tratamiento ("/img/fisioterapia.jpg","Fisioterapia","Contamos con profesionales sanitarios y técnicos especialistas en la recuperación muscular. Ofrecemos un servicio de alta calidad para una mayor y más eficaz recuperación.", 45.00);
						
						List <Tratamiento> listaMasaje = Arrays.asList(t13, t14, t15, t16);
						
						for (Tratamiento t : listaMasaje) {
							servicioTratamiento.save(t);
						}
						
						for (Tratamiento t : listaMasaje) {
							masaje.addTratamiento(t);
							servicioTratamiento.edit(t);
				
						}
						
						// tratamientos
						Tratamiento t17 = new Tratamiento ("/img/limpiezaFacial.jpg","Limpieza facial","Si quieres lucir una piel luminosa y uniforme, este es tu tratamiento. Líbrate de las impurezas, la contaminación y la propia grasa de la piel.", 30.00);
						Tratamiento t18 = new Tratamiento ("/img/peeling.jpg","Peeling químico","Este tratamiento no quirúrgico, cuyo efecto inmediato consiste en la eliminación de una parte del cutis, así como un efecto tardío de regeneración de la piel, renovando la matriz dérmica y dejándola sin determinados defectos estéticos como manchas, arrugas...", 37.00);
						Tratamiento t19 = new Tratamiento ("/img/diseñoCejas.jpg","Diseño y tinte de cejas","Este tratamiento cosmético combina hábilmente la remodelación de la forma con la aplicación del maquillaje para un resultado hiper elegante.", 27.00);
						
						List <Tratamiento> listaTratamientos = Arrays.asList(t17, t18, t19);
						
						for (Tratamiento t : listaTratamientos) {
							servicioTratamiento.save(t);
						}
						
						for (Tratamiento t : listaTratamientos) {
							tratamientos.addTratamiento(t);
							servicioTratamiento.edit(t);
				
						}
			
			
			
			// Empleados
			Empleado emple = new Empleado();
			emple.setEmail("admin");
			emple.setApellidos("Macías");
			emple.setNombre("María");
			emple.setDni("11223344L");
			emple.setFechaNacimiento(LocalDate.of(2000, 02, 20));
			emple.setTelefono("959416374");
			emple.setPassword(passwordEncoder.encode("admin"));
			emple.setEsAdmin(true);
			
			servicioUsuario.save(emple);
			servicioUsuario.save(new Empleado("Antonio", "García", LocalDate.of(2018, 10, 30) ,"954000000", "antonio@mail.com",passwordEncoder.encode("1234"), "298u9834", true));
			servicioUsuario.save(new Empleado("María","López", LocalDate.of(2018, 10, 30) , "954000000", "maria@mail.com", passwordEncoder.encode("1234"), "298u9834", true));
			servicioUsuario.save(new Empleado("Manuel","Padilla", LocalDate.of(2018, 10, 30) , "954000000","manuel@mail.com", passwordEncoder.encode("1234"), "298u9834", true));						
					
			// Clientes
			Cliente cliente = new Cliente();
			cliente.setEmail("user");
			cliente.setPassword(passwordEncoder.encode("1234"));
			cliente.setFechaNacimiento(LocalDate.of(1990, 1, 1));
			cliente.setApellidos("registrado");
			cliente.setNombre("usuario");
			cliente.setTelefono("959416374");
			
			servicioUsuario.save(new Cliente("Antonio", "García", LocalDate.of(2018, 10, 30) , "954000000","antoniogarcia@mail.com",passwordEncoder.encode("1234")));
			servicioUsuario.save(new Cliente("Maria", "Macias", LocalDate.of(1994, 05, 02), "95943423", "mariamacias@gmail.com", passwordEncoder.encode("1234")));
			
			
			Cliente cliente2 = new Cliente();
			cliente2.setEmail("user2");
			cliente2.setPassword(passwordEncoder.encode("1234"));
			cliente2.setFechaNacimiento(LocalDate.of(1990, 1, 1));
			cliente2.setApellidos("usuario2");
			cliente2.setNombre("usuario2");
			cliente2.setTelefono("95941sds74");
			
			

			// Reservas
			
			Reserva r1 = new Reserva(LocalDateTime.now(),20.0, emple, cliente);
			Reserva r2 = new Reserva(LocalDateTime.now(),10.0, emple, cliente);
			Reserva r3 = new Reserva(LocalDateTime.now(),100.0, emple, cliente2);
			
			cliente.addReservaC(r1);
			cliente.addReservaC(r2);
			cliente2.addReservaC(r3);
			servicioUsuario.save(cliente2);
			servicioUsuario.save(cliente);

			servicioReserva.save(new Reserva(LocalDateTime.now(),20.0, emple, cliente));
			servicioReserva.save(new Reserva(LocalDateTime.now(),10, emple, cliente));
			servicioReserva.save(new Reserva(LocalDateTime.now(),100, emple, cliente2));

			
					
				
			};
		
		
		
	}

}
