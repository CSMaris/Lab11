package it.polito.tdp.bar;

public class GruppoClienti {
	
	private int numeroPersone;
	private float tolleranza;
	
	public GruppoClienti(int numeroPersone, float tolleranza) {
		
		this.numeroPersone = numeroPersone;
		this.tolleranza = tolleranza;
	}
	
	
	public int getNumeroPersone() {
		return numeroPersone;
	}

	public float getTolleranza() {
		return tolleranza;
	}
	

}
