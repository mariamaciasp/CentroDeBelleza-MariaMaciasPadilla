package com.MariaMaciasPadilla.CentroDeBelleza.Controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Categoria;
import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Tratamiento;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.CategoriaServicio;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.TratamientoServicio;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private TratamientoServicio tratamientoservicio;
	@Autowired
	private CategoriaServicio categoriaservicio;	
	
	
	@ModelAttribute("categorias")
	public List<Categoria> listaCategorias () {	
		return categoriaservicio.findAll();
	}
	
	@ModelAttribute("tratamientos")
	public List <Tratamiento> listaTratamientos () {
		List <Tratamiento> tratamientos = tratamientoservicio.findAll();
		return tratamientos;
	}
	
	@GetMapping({"","/index","/indexUser"})
	public String inicio () {
		listaCategorias();
		listaTratamientos();
		return "/index";
	}
	
	
	

}
