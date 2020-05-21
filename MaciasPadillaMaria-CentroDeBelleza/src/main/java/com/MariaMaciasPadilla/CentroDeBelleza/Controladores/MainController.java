package com.MariaMaciasPadilla.CentroDeBelleza.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Tratamiento;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.CategoriaServicio;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.ClienteServicio;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.EmpleadoServicio;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.ReservaServicio;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.TratamientoServicio;


@Controller
public class MainController {
	
	@Autowired
	private EmpleadoServicio servicioEmpleado;
	@Autowired
	private ClienteServicio servicioCliente;
	@Autowired
	private ReservaServicio servicioReserva;
	@Autowired
	private TratamientoServicio servicioTratamiento;
	@Autowired
	private CategoriaServicio servicioCategoria;
	
	private final String BASE_IMAGE_PATH;
	private static final int NUM_TRATAMIENTOS_ALEATORIOS = 8;
	
	
	public MainController(TratamientoServicio servicioTratamiento, @Value("${image.base-path:/files}") String path) {
		this.servicioTratamiento = servicioTratamiento;
		this.BASE_IMAGE_PATH = path;
	}
	
	@ModelAttribute("base_image_path")
	public String baseImagePath() {
		return this.BASE_IMAGE_PATH;
	}

	
	@GetMapping("/peluqueria")
	public String indexTratamiento(@RequestParam(name="idCategoria", required=false) Long idCategoria, Model model) {		
		
		model.addAttribute("categorias", servicioCategoria.findAll());
		
		List <Tratamiento> tratamientos;
		
		if (idCategoria == null) {
			tratamientos = servicioTratamiento.obtenerTratamientosAleatorios(NUM_TRATAMIENTOS_ALEATORIOS);
		} else {			
			tratamientos = servicioTratamiento.findAllByCategoria(idCategoria);
		}
		
		model.addAttribute("tratamientos", tratamientos);
		
		return "peluqueria";
	}
	
	@GetMapping("/peluqueria/{id}")
	public String showDetails(@PathVariable("id") Long id, Model model) {
		Tratamiento t = servicioTratamiento.findById(id);
		if (t != null) {
			model.addAttribute("tratamiento", t);
			return "detalles";
		}
		
		return "redirect:/peluqueria";
		
	}
	
	@GetMapping("/detalles")
	public String detalles(Model model) {
		
			model.addAttribute("tratamiento", servicioTratamiento.findAll());
			return "detalles";
		
		
	}
	
	
	
	/*@GetMapping({"/","/index"})
	public String inicio(SecurityContextHolderAwareRequestWrapper request) {
		boolean a = request.isUserInRole("ROLE_ADMIN");
		boolean u = request.isUserInRole("ROLE_USER");
		
		if (a) {
			return "/privacidad";
			
		} else if (u) {
			return "/privacidad";
		} else{
			return "/index";
		}
		
	}*/

	@GetMapping({"/","/index"})
	public String inicio() {
		return "index";
	}

	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/registroSesion")
	public String registroSesion(SecurityContextHolderAwareRequestWrapper request, Model model) {	
		
		//boolean a = request.isUserInRole("ROLE_ADMIN");
		//boolean u = request.isUserInRole("ROLE_USER");
			
		if (request.isUserInRole("ROLE_ADMIN")) {
			model.addAttribute("listaEmpleados", servicioEmpleado.findAll());
			model.addAttribute("listaReservas", servicioReserva.findAll());
			model.addAttribute("listaClientes", servicioCliente.findAll());
			model.addAttribute("listaTratamientos", servicioTratamiento.findAll());
			model.addAttribute("listaCategorias", servicioCategoria.findAll());
			return "/admin/sesionAdmin";
			
		} else if (request.isUserInRole("ROLE_USER")) {
			return "/user/sesionUser";
			
		} else{
			
			return "/registroCiente";
		}
	}
	
	
	/*@GetMapping("/peluqueria")
	public String peluqueria() {
		return "peluqueria";
	}*/
	
	@GetMapping("/tratamientos")
	public String tratamientos() {
		return "tratamientos";
	}
	
	@GetMapping("/carrito")
	public String carrito() {
		return "carrito";
	}
	
	
	
	@GetMapping("/privacidad")
	public String privacidad() {
		return "privacidad";
	}
	
	@GetMapping("/cookies")
	public String cookies() {
		return "cookies";
	}

}
