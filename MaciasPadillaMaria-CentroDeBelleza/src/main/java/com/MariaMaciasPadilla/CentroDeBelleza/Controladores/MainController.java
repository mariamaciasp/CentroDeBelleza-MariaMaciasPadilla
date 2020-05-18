package com.MariaMaciasPadilla.CentroDeBelleza.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping({"/","/index"})
	public String inicio() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/registroCliente")
	public String registro() {
		return "/registroCliente";
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
