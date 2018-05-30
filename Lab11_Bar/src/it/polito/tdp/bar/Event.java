package it.polito.tdp.bar;

import java.time.LocalTime;

public class Event {
	private LocalTime ora ;
	private EventType tipo ;
	
	private GruppoClienti gruppo;

	public Event(LocalTime ora, EventType tipo, GruppoClienti gruppo) {
		
		this.ora = ora;
		this.tipo = tipo;
		this.gruppo=gruppo;
	}

	public LocalTime getOra() {
		return ora;
	}

	public EventType getTipo() {
		return tipo;
	}

	public GruppoClienti getGruppo() {
		return gruppo;
	}
	
	
	
	

}
