package com.MariaMaciasPadilla.CentroDeBelleza.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Cliente;
import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Reserva;
import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Tratamiento;
import com.MariaMaciasPadilla.CentroDeBelleza.Repositorios.ReservaRepository;
import com.MariaMaciasPadilla.CentroDeBelleza.Servicios.Base.BaseService;

@Service
public class ReservaServicio extends BaseService<Reserva, Long, ReservaRepository>{

	//private List <Reserva> listaReservas = new ArrayList <Reserva>(); 

	public ReservaServicio(ReservaRepository repo) {
		super(repo);		
	}
	
	@Autowired
	ReservaRepository reservaRepository;
	
	@Autowired
	TratamientoServicio tratamientoServicio;
	
	
	public Reserva insertarRC(Reserva r, Cliente c) {
		r.setCliente(c);
		return reservaRepository.save(r);
	}
	
	public Reserva insertarRCT(Reserva r, Cliente c, Tratamiento t) {
		r.setTratamiento(t);
		r.setCliente(c);
		return reservaRepository.save(r);
	}
	
	public Reserva insertarR(Reserva r) {
		return reservaRepository.save(r);
	}
	
	public Tratamiento addTratamientoReserva(Tratamiento t, List<Reserva> r) {
		t.setReservas(r);
		return tratamientoServicio.edit(t);
	}
	
	public Reserva buscarPorId(long numReserva) {
		return reservaRepository.findById(numReserva).orElse(null);
	}
	
	public List<Reserva> todas() {
		return reservaRepository.findAll();
	}
	
	public List<Reserva> porCliente(Cliente c) {
		return reservaRepository.findByCliente(c);
	}



}
