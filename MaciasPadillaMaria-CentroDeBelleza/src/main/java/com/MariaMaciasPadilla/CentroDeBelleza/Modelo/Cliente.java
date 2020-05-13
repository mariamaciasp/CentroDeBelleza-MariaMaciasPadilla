package com.MariaMaciasPadilla.CentroDeBelleza.Modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
public class Cliente extends Usuario{
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="cliente")
	private List <Reserva> reservasC = new ArrayList <> ();
	
	public void addReservaC(Reserva r) {
		this.reservasC.add(r);
		r.setCliente(this);
	}
	
	public void removeReservaC(Reserva r) {
		this.reservasC.remove(r);
		r.setCliente(null);
	}

	
}
