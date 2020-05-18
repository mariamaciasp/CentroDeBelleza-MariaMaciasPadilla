package com.MariaMaciasPadilla.CentroDeBelleza.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.ReservaServicio;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private EmpleadoServicio empleadoservicio;
	@Autowired
	private ClienteServicio clienteservicio;
	@Autowired
	private ReservaServicio servicioReserva;
	
	@GetMapping({"","/index","/indexAdmin"})
	public String inicio () {
		return "/admin/indexAdmin";
	}
	
	@GetMapping("/sesion")
	public String listado (Model model) {
		model.addAttribute("listaEmpleados", empleadoservicio.findAll());
		model.addAttribute("listaReservas", servicioReserva.findAll());
		model.addAttribute("listaClientes", clienteservicio.findAll());
		return "/admin/sesionAdmin";
		
	}
	
	@GetMapping("/newCliente")
	public String nuevoClienteForm (Model model) {
		model.addAttribute("clienteForm", new Cliente());
		return "/registroCliente";
	}
	
	@PostMapping("/newCliente/submit")
	public String nuevoClienteSubmit (@ModelAttribute("clienteForm") Cliente nuevoCliente) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		nuevoCliente.setPassword(encoder.encode(nuevoCliente.getPassword()));
		clienteservicio.save(nuevoCliente);
		
		return "redirect:/admin/sesion";
	}
	
	
	@GetMapping("/editCliente/{id}")
	public String editarClienteForm (@PathVariable long id, Model model) {
		
		Cliente cliente = clienteservicio.findById(id);
		if (cliente != null) {
			model.addAttribute("clienteForm", cliente);
			return "/registroCliente";
			} else {
				return "redirect:/admin/new";
			}
	}
	
	@PostMapping("/editCliente/submit")
	public String editarClienteSubmit (@ModelAttribute("clienteForm") Cliente nuevoCliente) {	
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		nuevoCliente.setPassword(encoder.encode(nuevoCliente.getPassword()));
		
		clienteservicio.edit(nuevoCliente);
		return "redirect:/admin/sesion";
	}
	
	
	@GetMapping("/eliminarCliente/{id}")
	public String eliminarClienteForm (@PathVariable long id, Model model) {
		
		Cliente cliente = clienteservicio.findById(id);
		if (cliente != null) {
			clienteservicio.deleteById(id);
			return "redirect:/admin/sesion";
			} else {
				return "redirect:/admin/sesion";
			}
	}
	
	/*
	 * @PostMapping("/eliminar/submit") public String eliminarClienteSubmit
	 * (@ModelAttribute("clienteForm") Cliente nuevoCliente) { BCryptPasswordEncoder
	 * encoder = new BCryptPasswordEncoder();
	 * nuevoCliente.setPassword(encoder.encode(nuevoCliente.getPassword()));
	 * 
	 * clienteservicio.delete(nuevoCliente); return "redirect:/admin/sesion"; }
	 */
	
	@GetMapping("/newEmpleado")
	public String nuevoEmpleadoForm (Model model) {
		model.addAttribute("empleadoForm", new Empleado());
		return "/admin/registroEmpleado";
	}
	
	@PostMapping("/newEmpleado/submit")
	public String nuevoEmpleadoSubmit (@ModelAttribute("empleadoForm") Empleado nuevoEmpleado) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		nuevoEmpleado.setPassword(encoder.encode(nuevoEmpleado.getPassword()));
		empleadoservicio.save(nuevoEmpleado);
		
		return "redirect:/admin/sesion";
	}
	
	
	@GetMapping("/editEmpleado/{id}")
	public String editarEmpleadoForm (@PathVariable long id, Model model) {
		
		Empleado empleado = empleadoservicio.findById(id);
		if (empleado != null) {
			model.addAttribute("empleadoForm", empleado);
			return "/admin/registroEmpleado";
			} else {
				return "redirect:/admin/new";
			}
	}
	
	@PostMapping("/editEmpleado/submit")
	public String editarEmpleadoSubmit (@ModelAttribute("empleadoForm") Empleado nuevoEmpleado) {	
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		nuevoEmpleado.setPassword(encoder.encode(nuevoEmpleado.getPassword()));
		
		empleadoservicio.edit(nuevoEmpleado);
		return "redirect:/admin/sesion";
	}
	
	
	@GetMapping("/eliminarEmpleado/{id}")
	public String eliminarEmpleadoForm (@PathVariable long id, Model model) {
		
		Empleado empleado = empleadoservicio.findById(id);
		if (empleado != null) {
			empleadoservicio.deleteById(id);
			return "redirect:/admin/sesion";
			} else {
				return "redirect:/admin/sesion";
			}
	}
	

}
