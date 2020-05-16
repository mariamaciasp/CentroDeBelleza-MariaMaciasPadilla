package com.MariaMaciasPadilla.CentroDeBelleza.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	@GetMapping({"","/index","/indexUser"})
	public String inicio () {
		return "/user/indexUser";
	}
	
	@GetMapping("/sesion")
	public String sesion () {
		return "/user/sesionUser";
	}
	

}
