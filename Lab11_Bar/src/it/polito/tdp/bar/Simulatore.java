package it.polito.tdp.bar;

import java.time.LocalTime;
import java.util.PriorityQueue;




public class Simulatore {
	
	//parametri
	private int T10=2;
	private int T8=4;
	private int T6=4;
	private int T4=5;
	
	private int EVENTMINTIME=1; //minuti minimi tra un evento e l'altro
	private int EVENTMAXTIME=10;//minuti max tra un evento e l'altro
	
	private int MINPEOPLE=1;//num componenti minimo del gruppo
	private int MAXPEOPLE=10;//num max ''
	
	private int BARMINTIME=60;//tempo minimo per stare al bar
	private int BARMAXTIME=120;//tempo max ''
	
	private float MINTOLLERANCE=0;
	private float MAXTOLLERANCE=(float) 0.9;
	
	private float MINOCCUPATION=(float) 0.5;
	
	private LocalTime T_INIZIO=LocalTime.of(8,0);
	
	//modello del mondo
	private int T10occupati;
	private int T8occupati;
	private int T60occupati;
	private int T40occupati;
	
	//valori in output
	private int totClienti;
	private int totClientiSoddisfatti;
	private int totClientiInsoddisfatti;
	
	//coda degli eventi
	private PriorityQueue<Event> queue = new PriorityQueue<>();
	
	
	
	public void init() {
		
		LocalTime ora = T_INIZIO;
		
		for (int i = 0; i < 2000; i++) {
			GruppoClienti gc=new GruppoClienti(MINPEOPLE*(1+(int)(Math.random()*MAXPEOPLE)), (float) (0.9*Math.random()) ); //poi quando arrivi all'evento basta che prendi un numero random e controlli che sia minore o maggiore del livello di tolleranza imposto
			Event e = new Event(ora, EventType.ENTRATA, gc);
			ora = ora.plusMinutes( EVENTMINTIME*(1+(int)(Math.random()*EVENTMAXTIME)));
			queue.add(e) ;
		}
		
		totClienti=0;
		totClientiSoddisfatti=0;
		totClientiInsoddisfatti=0;
		
		
		
		
		
		
	}
	
	
	public void setT_INIZIO(LocalTime t_INIZIO) {
		T_INIZIO = t_INIZIO;
	}


	public void run() {
		
	}
	
	private void processEvent(Event e) {
		
	}


	public int getTotClienti() {
		return totClienti;
	}


	public int getTotClientiSoddisfatti() {
		return totClientiSoddisfatti;
	}


	public int getTotClientiInsoddisfatti() {
		return totClientiInsoddisfatti;
	}


	public void setEVENTMINTIME(int eVENTMINTIME) {
		EVENTMINTIME = eVENTMINTIME;
	}


	public void setEVENTMAXTIME(int eVENTMAXTIME) {
		EVENTMAXTIME = eVENTMAXTIME;
	}


	public void setMINPEOPLE(int mINPEOPLE) {
		MINPEOPLE = mINPEOPLE;
	}


	public void setMAXPEOPLE(int mAXPEOPLE) {
		MAXPEOPLE = mAXPEOPLE;
	}


	public void setBARMINTIME(int bARMINTIME) {
		BARMINTIME = bARMINTIME;
	}


	public void setBARMAXTIME(int bARMAXTIME) {
		BARMAXTIME = bARMAXTIME;
	}


	public void setMINTOLLERANCE(float mINTOLLERANCE) {
		MINTOLLERANCE = mINTOLLERANCE;
	}


	public void setMAXTOLLERANCE(float mAXTOLLERANCE) {
		MAXTOLLERANCE = mAXTOLLERANCE;
	}


	public void setMINOCCUPATION(float mINOCCUPATION) {
		MINOCCUPATION = mINOCCUPATION;
	}
	
	
	
	
	
	
	
	
	
	
	

}
