package it.polito.tdp.bar;

public class GruppoClienti {
	
	private int numeroPersone;
	private float tolleranza;
	private int tavolo;
	
	public GruppoClienti(int numeroPersone, float tolleranza) {
		
		this.numeroPersone = numeroPersone;
		this.tolleranza = tolleranza;
		tavolo=0;
	}
	
	
	public int getNumeroPersone() {
		return numeroPersone;
	}

	public float getTolleranza() {
		return tolleranza;
	}


	public int getTavolo() {
		return tavolo;
	}


	public void setTavolo(int tavolo) {
		this.tavolo = tavolo;
	}
	
	

}
