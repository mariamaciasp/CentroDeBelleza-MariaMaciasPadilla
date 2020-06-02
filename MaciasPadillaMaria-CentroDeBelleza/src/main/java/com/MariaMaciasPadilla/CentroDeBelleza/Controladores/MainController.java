package com.MariaMaciasPadilla.CentroDeBelleza.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Categoria;
import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Cliente;
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
	
	
	@ModelAttribute("categorias")
	public List<Categoria> listaCategorias () {	
		return servicioCategoria.findAll();
	}
	
	@ModelAttribute("tratamientos")
	public List <Tratamiento> listaTratamientos () {
		List <Tratamiento> tratamientos = servicioTratamiento.findAll();
		return tratamientos;
	}

	
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
		listaCategorias();
		listaTratamientos();
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
		listaCategorias();
		listaTratamientos();
		return "index";
	}

	
	@GetMapping("/login")
	public String login() {
		listaCategorias();
		listaTratamientos();
		return "login";
	}
	
	@GetMapping("/registroSesion")
	public String registroSesion(@AuthenticationPrincipal Cliente cliente, SecurityContextHolderAwareRequestWrapper request, Model model) {	
		
		listaCategorias();
		listaTratamientos();
		
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
			model.addAttribute("listaReservas", servicioReserva.findAll());
			model.addAttribute("nombre", cliente.getNombre());
			model.addAttribute("apellidos", cliente.getApellidos());
			model.addAttribute("fechaNacimiento", cliente.getFechaNacimiento());
			model.addAttribute("telefono", cliente.getTelefono());
			model.addAttribute("email", cliente.getEmail());
			
			
			//model.addAttribute("clienteNombreForm", cliente.getNombre());
			return "/user/sesionUser";
			
		} else{
			
			return "/login";
		}
	}
	
	@GetMapping("/registroCliente")
	public String nuevoClienteForm (Model model) {
		listaCategorias();
		listaTratamientos();
		model.addAttribute("clienteForm", new Cliente());
		return "/registroCliente";
	}
	
	@PostMapping("/registroCliente/submit")
	public String nuevoClienteSubmit (@ModelAttribute("clienteForm") Cliente nuevoCliente) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		nuevoCliente.setPassword(encoder.encode(nuevoCliente.getPassword()));
		servicioCliente.save(nuevoCliente);
		
		return "redirect:/login";
	}
	
	
	
	
	@GetMapping("/carrito")
	public String carrito() {
		listaCategorias();
		listaTratamientos();
		return "/carrito";
	}
	
	
	
	@GetMapping("/privacidad")
	public String privacidad() {
		listaCategorias();
		listaTratamientos();
		return "privacidad";
	}
	
	@GetMapping("/cookies")
	public String cookies() {
		listaCategorias();
		listaTratamientos();
		return "cookies";
	}

}
