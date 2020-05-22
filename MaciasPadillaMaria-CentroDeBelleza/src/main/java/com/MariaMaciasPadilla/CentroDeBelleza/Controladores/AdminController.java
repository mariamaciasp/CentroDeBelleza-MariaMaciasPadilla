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

import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Categoria;
import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Cliente;
import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Empleado;
import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Tratamiento;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.CategoriaServicio;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.ClienteServicio;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.EmpleadoServicio;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.TratamientoServicio;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private EmpleadoServicio empleadoservicio;
	@Autowired
	private ClienteServicio clienteservicio;
	@Autowired
	private TratamientoServicio tratamientoservicio;
	@Autowired
	private CategoriaServicio categoriaservicio;
	
	@GetMapping({"","/index","/indexAdmin"})
	public String inicio () {
		return "/index";
	}
	
	
/*	@GetMapping("/sesion")
	public String listado (Model model) {
		model.addAttribute("listaEmpleados", empleadoservicio.findAll());
		model.addAttribute("listaReservas", servicioReserva.findAll());
		model.addAttribute("listaClientes", clienteservicio.findAll());
		return "/admin/sesionAdmin";
		
	}*/
	
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
		
		return "redirect:/registroSesion";
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
		return "redirect:/registroSesion";
	}
	
	
	@GetMapping("/eliminarCliente/{id}")
	public String eliminarClienteForm (@PathVariable long id, Model model) {
		
		Cliente cliente = clienteservicio.findById(id);
		if (cliente != null) {
			clienteservicio.deleteById(id);
			return "redirect:/registroSesion";
			} else {
				return "redirect:/sesion";
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
		
		return "redirect:/sesion";
	}
	
	
	@GetMapping("/editEmpleado/{id}")
	public String editarEmpleadoForm (@PathVariable long id, Model model) {
		
		Empleado empleado = empleadoservicio.findById(id);
		if (empleado != null) {
			model.addAttribute("empleadoForm", empleado);
			return "/admin/registroEmpleado";
			} else {
				return "redirect:/admin/newEmpleado";
			}
	}
	
	@PostMapping("/editEmpleado/submit")
	public String editarEmpleadoSubmit (@ModelAttribute("empleadoForm") Empleado nuevoEmpleado) {	
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		nuevoEmpleado.setPassword(encoder.encode(nuevoEmpleado.getPassword()));
		
		empleadoservicio.edit(nuevoEmpleado);
		return "redirect:/registroSesion";
	}
	
	
	@GetMapping("/eliminarEmpleado/{id}")
	public String eliminarEmpleadoForm (@PathVariable long id, Model model) {
		
		Empleado empleado = empleadoservicio.findById(id);
		if (empleado != null) {
			empleadoservicio.deleteById(id);
			return "redirect:/registroSesion";
			} else {
				return "redirect:/registroSesion";
			}
	}
	
	
	// para tratamientos 
	
	@GetMapping("/newTratamiento")
	public String nuevoTratamientoForm (Model model) {
		model.addAttribute("tratamientoForm", new Tratamiento());
		model.addAttribute("listaCategorias", categoriaservicio.findAll());
		return "/admin/RegistroTratamiento";
	}
	
	@PostMapping("/newTratamiento/submit")
	public String nuevoTratamientoSubmit (@ModelAttribute("tratamientoForm") Tratamiento nuevoTratamiento) {
		tratamientoservicio.save(nuevoTratamiento);
		
		return "redirect:/registroSesion";
	}
	
	
	@GetMapping("/editTratamiento/{id}")
	public String editarTratamientoForm (@PathVariable long id, Model model) {
		
		Tratamiento tratamiento = tratamientoservicio.findById(id);
		if (tratamiento != null) {
			model.addAttribute("tratamientoForm", tratamiento);
			model.addAttribute("listaCategorias", categoriaservicio.findAll());
			return "/admin/RegistroTratamiento";
			} else {
				return "redirect:/admin/newTratamiento";
			}
	}
	
	@PostMapping("/editTratamiento/submit")
	public String editarTratamientoSubmit (@ModelAttribute("tratamientoForm") Tratamiento nuevotratamiento) {	
		tratamientoservicio.edit(nuevotratamiento);
		return "redirect:/registroSesion";
	}
	
	
	@GetMapping("/eliminarTratamiento/{id}")
	public String eliminarTratamientoForm (@PathVariable long id, Model model) {
		
		Tratamiento tratamiento = tratamientoservicio.findById(id);
		if (tratamiento != null) {
			tratamientoservicio.deleteById(id);
			return "redirect:/registroSesion";
			} else {
				return "redirect:/registroSesion";
			}
	}
	
	
	// para categorias 
	
	@GetMapping("/newCategoria")
	public String nuevaCategoriaForm (Model model) {
		model.addAttribute("categoriaForm", new Categoria());
		model.addAttribute("listaCategorias", categoriaservicio.findAll());
		return "/admin/RegistroCategoria";
	}
	
	@PostMapping("/newCategoria/submit")
	public String nuevoCategoriaSubmit (@ModelAttribute("categoriaForm") Categoria nuevaCategoria) {
		categoriaservicio.save(nuevaCategoria);
		
		return "redirect:/registroSesion";
	}
	
	
	@GetMapping("/editCategoria/{id}")
	public String editarCategoriaForm (@PathVariable long id, Model model) {
		
		Categoria categoria = categoriaservicio.findById(id);
		
		if (categoria != null) {
			
			model.addAttribute("categoriaForm", categoria);
			return "/admin/RegistroCategoria";
			
		} else {
			return "redirect:/admin/newCategoria";
		}
		
	}
	
	/*@PostMapping("/editCategoria/submit")
	public String editarCategoriaSubmit (@ModelAttribute("categoriaForm") Categoria nuevacategoria) {	
		categoriaservicio.edit(nuevacategoria);
		return "redirect:/registroSesion";
	}*/
	
	
	@GetMapping("/eliminarCategoria/{id}")
	public String eliminarCategoriaForm (@PathVariable long id, Model model) {
		
		Categoria categoria = categoriaservicio.findById(id);
		
		if (categoria != null) {

			
			if (tratamientoservicio.numeroTratamientosCategoria(categoria) == 0) {
				categoriaservicio.delete(categoria);
				
			} else {
				return "redirect:/registroSesion/?error=true";
			}
			
			
		}
		
		return "redirect:/registroSesion";
			

			
	}
	

}
