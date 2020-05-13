package com.MariaMaciasPadilla.CentroDeBelleza.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MariaMaciasPadilla.CentroDeBelleza.Modelo.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, Long>{

}
