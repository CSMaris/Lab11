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
	private int BARMAXTIME=2;//num di BARMINTIME max ''
	
	private float MINTOLLERANCE=0;
	private float MAXTOLLERANCE=(float) 0.9;
	
	
	
	private LocalTime T_INIZIO=LocalTime.of(8,0);
	
	//modello del mondo
	private int T10occupati;
	private int T8occupati;
	private int T6occupati;
	private int T4occupati;
	
	//valori in output
	private int totClienti;
	private int totClientiSoddisfatti;
	private int totClientiInsoddisfatti;
	
	//coda degli eventi
	private PriorityQueue<Event> queue = new PriorityQueue<>();
	
	
	
	public void init() {
		
		LocalTime ora = T_INIZIO;
		
		for (int i = 0; i < 2000; i++) {
			GruppoClienti gc=new GruppoClienti(MINPEOPLE*(1+(int)(Math.random()*MAXPEOPLE)), (float) (MAXTOLLERANCE*Math.random()) ); //poi quando arrivi all'evento basta che prendi un numero random e controlli che sia minore o maggiore del livello di tolleranza imposto
			Event e = new Event(ora, EventType.ENTRATA, gc);
			queue.add(e) ;
			ora = ora.plusMinutes( EVENTMINTIME*(1+(int)((Math.random()*EVENTMAXTIME)-1)));
		}
		
		totClienti=0;
		totClientiSoddisfatti=0;
		totClientiInsoddisfatti=0;
		
		T10occupati=0;
		T8occupati=0;
		T6occupati=0;
		T4occupati=0;
		
		this.run();
		
		
		
	}
	
	
	public void run() {
		
		Event e;
		
		while ((e = queue.poll()) != null)
			processEvent(e);
		
	}
	
	private void processEvent(Event e) {
		
		switch(e.getTipo()) {
		
		case ENTRATA:
			int num=e.getGruppo().getNumeroPersone();
			LocalTime ora=e.getOra();
			totClienti+=num;
			
			if(num<=4) {
				if(T4occupati< T4 && num>=2) {
					T4occupati++;
					totClientiSoddisfatti+=num;
					Event e2=new Event(ora.plusMinutes((int)(BARMINTIME*(1+(BARMAXTIME-1)*Math.random()))),EventType.USCITA,e.getGruppo());
					queue.add(e2);
					e.getGruppo().setTavolo(4);
				}
				else if(T6occupati<T6 && num>=3) {
					T6occupati++;
					totClientiSoddisfatti+=num;
					Event e2=new Event(ora.plusMinutes((int)(BARMINTIME*(1+(BARMAXTIME-1)*Math.random()))),EventType.USCITA,e.getGruppo());
					queue.add(e2);
					e.getGruppo().setTavolo(6);
				}
				else if(T8occupati<T8 && num>=4) {
					T8occupati++;
					totClientiSoddisfatti+=num;
					Event e2=new Event(ora.plusMinutes((int)(BARMINTIME*(1+(BARMAXTIME-1)*Math.random()))),EventType.USCITA,e.getGruppo());
					queue.add(e2);
					e.getGruppo().setTavolo(8);
				}
				else if(Math.random()<=e.getGruppo().getTolleranza())
					totClientiSoddisfatti+=num;
				else
					totClientiInsoddisfatti+=num;
					
			}
			
			if(num<=6 && num>4) {
				if(T6occupati< T6) {
					T6occupati++;
					totClientiSoddisfatti+=num;
					Event e2=new Event(ora.plusMinutes((int)(BARMINTIME*(1+(BARMAXTIME-1)*Math.random()))),EventType.USCITA,e.getGruppo());
					queue.add(e2);
					e.getGruppo().setTavolo(6);
				}
				else if(T8occupati<T8) {
					T8occupati++;
					totClientiSoddisfatti+=num;
					Event e2=new Event(ora.plusMinutes((int)(BARMINTIME*(1+(BARMAXTIME-1)*Math.random()))),EventType.USCITA,e.getGruppo());
					queue.add(e2);
					e.getGruppo().setTavolo(8);
				}
				else if(T10occupati<T10 && num>=5) {
					T10occupati++;
					totClientiSoddisfatti+=num;
					Event e2=new Event(ora.plusMinutes((int)(BARMINTIME*(1+(BARMAXTIME-1)*Math.random()))),EventType.USCITA,e.getGruppo());
					queue.add(e2);
					e.getGruppo().setTavolo(10);
				}
				else if(Math.random()<=e.getGruppo().getTolleranza())
					totClientiSoddisfatti+=num;
				else
					totClientiInsoddisfatti+=num;
			}
			
			if(num<=8 && num>6) {
				 if(T8occupati<T8) {
					T8occupati++;
					totClientiSoddisfatti+=num;
					Event e2=new Event(ora.plusMinutes((int)(BARMINTIME*(1+(BARMAXTIME-1)*Math.random()))),EventType.USCITA,e.getGruppo());
					queue.add(e2);
					e.getGruppo().setTavolo(8);
					
				 }
				else if(T10occupati<T10) {
					T10occupati++;
					totClientiSoddisfatti+=num;
					Event e2=new Event(ora.plusMinutes((int)(BARMINTIME*(1+(BARMAXTIME-1)*Math.random()))),EventType.USCITA,e.getGruppo());
					queue.add(e2);
					e.getGruppo().setTavolo(10);
				}
				else if(Math.random()<=e.getGruppo().getTolleranza())
					totClientiSoddisfatti+=num;
				else
					totClientiInsoddisfatti+=num;
			}
			
			if(num>8) {
				 if(T10occupati<T10) {
					T10occupati++;
					totClientiSoddisfatti+=num;
					Event e2=new Event(ora.plusMinutes((int)(BARMINTIME*(1+(BARMAXTIME-1)*Math.random()))),EventType.USCITA,e.getGruppo());
					queue.add(e2);
				 }
				 else if(Math.random()<=e.getGruppo().getTolleranza())
						totClientiSoddisfatti+=num;
					else
						totClientiInsoddisfatti+=num;
				 
				 
			}
			
			break;
			
		case USCITA:
			int tavolo=e.getGruppo().getTavolo();
			if(tavolo==4)
				T4occupati--;
			if(tavolo==6)
				T6occupati--;
			if(tavolo==8)
				T8occupati--;
			if(tavolo==10)
				T10occupati--;
			
			break;
			
		}
		
		
		
	}
	
	
	public void setT_INIZIO(LocalTime t_INIZIO) {
		T_INIZIO = t_INIZIO;
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


	
	
	
	
	
	
	
	
	
	
	

}
