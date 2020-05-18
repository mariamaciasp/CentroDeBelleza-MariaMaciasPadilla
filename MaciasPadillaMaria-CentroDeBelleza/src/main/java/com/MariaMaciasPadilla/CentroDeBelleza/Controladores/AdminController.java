package com.MariaMaciasPadilla.CentroDeBelleza.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Cliente;
import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Empleado;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.ClienteServicio;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.EmpleadoServicio;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private EmpleadoServicio empleadoservicio;
	@Autowired
	private ClienteServicio clienteservicio;
	//@Autowired
	//private ReservaServicio servicioReserva;
	
	@GetMapping({"","/index"})
	public String inicio () {
		return "/admin/index";
	}
	
	// INTENTO DE FORMULARIO, FALTAN COSAS EN LAS PLANTILLAS PARA PODER HACERLO
	@GetMapping("/sesion")
	public String listado (Model model) {
		model.addAttribute("listaEmpleados", empleadoservicio.findAll());
		//model.addAttribute("listaReservas", servicioReserva.findAll());
		model.addAttribute("listaClientes", clienteservicio.findAll());
		return "/admin/sesionAdmin";
		
	}
	
	@GetMapping("/new")
	public String nuevoClienteForm (Model model) {
		model.addAttribute("clienteForm", new Cliente());
		return "/registro";
	}
	
	@PostMapping("/new/submit")
	public String nuevoClienteSubmit (@ModelAttribute("clienteForm") Cliente nuevoCliente) {
		clienteservicio.save(nuevoCliente);
		return "redirect:/admin/sesion";
	}
	
	
	@GetMapping("/edit/{id}")
	public String editarClienteForm (@PathVariable long id, Model model) {
		
		Cliente cliente = clienteservicio.findById(id);
		if (cliente != null) {
			model.addAttribute("clienteForm", cliente);
			return "/registro";
			} else {
				return "redirect:/admin/new";
			}
	}
	
	@PostMapping("/edit/submit")
	public String editarClienteSubmit (@ModelAttribute("clienteForm") Cliente nuevoCliente) {		
		clienteservicio.edit(nuevoCliente);
		return "redirect:/admin/sesion";
	}

}
