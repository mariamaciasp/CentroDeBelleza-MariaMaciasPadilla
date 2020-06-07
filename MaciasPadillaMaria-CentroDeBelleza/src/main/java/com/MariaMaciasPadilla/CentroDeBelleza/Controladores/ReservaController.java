package com.MariaMaciasPadilla.CentroDeBelleza.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.MariaMaciasPadilla.CentroDeBelleza.Carrito.Carrito;
import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Cliente;
import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Reserva;
import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Tratamiento;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.ReservaServicio;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.TratamientoServicio;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ReservaController {
	
	
	private final TratamientoServicio servicioTratamiento;
	private final Carrito carrito;
	@Autowired
	private ReservaServicio servicioReserva;

	
	@ModelAttribute("tratamientos")
	public List<Tratamiento> todosLosTratamientos() {
		return servicioTratamiento.findAll();
	}
	
	
	@GetMapping("/tratamientoC") 
	public String carrito(Model model) { 

		model.addAttribute("listaTratamientos", servicioTratamiento.findAll());
		
		return "tratamiento"; }
	 
	
	
	/**
	 * Métodos asociados al carrito
	 */
	
	@GetMapping("/carrito/add/{id}")
	public String addToCart(@PathVariable("id") Long id) {
		carrito.addToCarrito(id);	
		
		return "redirect:/carrito/mostrar";
	}

	@GetMapping("/carrito/mostrar")
	public String showCart(Model model/*,	@ModelAttribute("fechaYhora") LocalDateTime fechaYhora*/) {
		model.addAttribute("carrito", carrito.getCarrito());
		model.addAttribute("numTratamientossDiferentes", carrito.numeroTotalTratamientosDiferentes());
		model.addAttribute("importeTotal", carrito.importeTotal());
		model.addAttribute("numUnidades", carrito.numeroTotalDeUnidades());
		//model.addAttribute("fechaYhora", fechaYhora/*carrito*//*.obtenerFechaYhora(fechaYhora)*/);
		return "carrito";
	}
	
	@GetMapping("/carrito/remove/{id}")
	public String removeFromCart(@PathVariable("id") Long id) {
		carrito.removeFromCarrito(id);
		return "redirect:/carrito/mostrar";
	}
	
	@GetMapping("/carrito/clear")
	public String clearCart() {
		carrito.clear();
		return "redirect:/";
	}
	
	
	/*@ModelAttribute("carrito")
	public List<Tratamiento> reservasCarrito() {
		List<Long> contenido = (List<Long>) session.getAttribute("carrito");
		return (contenido == null) ? null : servicioTratamiento.variosPorId(contenido);
	}*/
	
	
	@GetMapping("/carrito/process")
	public String procesarCarrito(@AuthenticationPrincipal Cliente cliente, Model model) {
		//, @PathVariable("id") Long id
		//Tratamiento tratamiento = servicioTratamiento.findById(id);

		
	
		for (Tratamiento t : carrito.getCarrito().keySet()) {
		//	model.addAttribute("carrito", carrito.numeroTotalDeUnidades())
			Reserva reserva = new Reserva ();
			t.addReserva(reserva);
			reserva.setCliente(cliente);
			reserva.setPrecio(t.getPrecio()*carrito.cantidadDeUnTratamiento(t));
			//servicioReserva.edit(reserva);
			servicioReserva.insertarR(reserva);
			
		}
		/*List <Long> contenido = (List<Long>) session.getAttribute("carrito");
		
		if (contenido == null)
			return "redirect:/";
		*/
		
	//	Reserva r = servicioReserva.insertarRCT(new Reserva(), cliente, tratamientos);
		
		//tratamientos.forEach(t -> servicioReserva.addTratamientoReserva(t, r));
		//session.removeAttribute("carrito");
		
		//model.addAttribute("cliente", cliente.getNombre());
		// En este método habría que conectar con otro servicio
		// para transformar los datos del carrito en una compra de
		// verdad. 
		
		// TODO Procesamiento de productos
		
		// Posteriormente, habría que vaciarlo y redirigir al usuario donde corresponda
		
		carrito.clear();
		return "redirect:/";
		
	}
	
	@GetMapping("/newReserva")
	public String nuevoClienteForm (Model model) {
		model.addAttribute("reservaForm", new Reserva());
		return "/peluqueria";
	}
	
	@PostMapping("/newReserva/submit")
	public String nuevoClienteSubmit (@ModelAttribute("reservaForm") Reserva reserva, @AuthenticationPrincipal Cliente cliente
			/*@ModelAttribute("fechaYhora") LocalDateTime fechaYhora*/) {
		
		//reserva.setFechaYhora(fechaYhora);
		reserva.setCliente(cliente);
		cliente.addReservaC(reserva);
		servicioReserva.save(reserva);
		
		return "redirect:/carrito";
	}
	
	
	
	
	
}
