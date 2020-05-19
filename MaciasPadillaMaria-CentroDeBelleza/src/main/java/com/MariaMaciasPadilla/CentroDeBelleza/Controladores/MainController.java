package com.MariaMaciasPadilla.CentroDeBelleza.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.ClienteServicio;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.EmpleadoServicio;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.ReservaServicio;


@Controller
public class MainController {
	
	@Autowired
	private EmpleadoServicio empleadoservicio;
	@Autowired
	private ClienteServicio clienteservicio;
	@Autowired
	private ReservaServicio servicioReserva;
	
	
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
	
	
	/*@RequestMapping(method = RequestMethod.GET)
	public void welcome(SecurityContextHolderAwareRequestWrapper request) {
	    boolean b = request.isUserInRole("ROLE_ADMIN");
	    System.out.println("ROLE_ADMIN=" + b);

	    boolean c = request.isUserInRole("ROLE_USER");
	    System.out.println("ROLE_USER=" + c);
	}
	*/
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/registroSesion")
	public String registroSesion(SecurityContextHolderAwareRequestWrapper request, Model model) {	
		
		boolean a = request.isUserInRole("ROLE_ADMIN");
		boolean u = request.isUserInRole("ROLE_USER");
			
		if (a) {
			model.addAttribute("listaEmpleados", empleadoservicio.findAll());
			model.addAttribute("listaReservas", servicioReserva.findAll());
			model.addAttribute("listaClientes", clienteservicio.findAll());
			return "/admin/sesionAdmin";
			
		} else if (u) {
			return "/user/sesionUser";
			
		} else{
			
			return "/registroCliente";
		}
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
