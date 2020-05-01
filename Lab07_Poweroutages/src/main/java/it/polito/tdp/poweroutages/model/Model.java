package it.polito.tdp.poweroutages.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.stream.Collectors.*;

import java.time.Duration;

import static java.util.Comparator.*;

import it.polito.tdp.poweroutages.DAO.PowerOutageDAO;

public class Model {
	
	PowerOutageDAO podao;
	private List<Event> eventiNerc;
	private List<Event> bestSoluzione;
	private int maxYear;
	private int maxHour;
	private long bestHour;
	private int totalePersone;
	
	public Model() {
		podao = new PowerOutageDAO();
	}
	
	public List<Nerc> getNercList() {
		return podao.getNercList();
	}
	
	public List<Event> listaEventi(Nerc n){
		
		this.eventiNerc = podao.getEventList(n.getId()).stream().sorted(comparing(Event::getAnno)).collect(toList());
		
		return eventiNerc;
		
	}
	
	public List<Event> maxEventi(int maxYear, int maxHour){
		
		
		
		this.maxYear = maxYear;
		this.maxHour = maxHour;
		
		List<Event> parziale = new ArrayList<>();
		
		cerca(parziale,0);
		
		
		return bestSoluzione;
	}

	private void cerca(List<Event> parziale,int livello) {
		
		
			
			
			if( bestSoluzione == null || this.calcolaPersone(parziale) > this.calcolaPersone(bestSoluzione) || livello == parziale.size()-1) {
				bestSoluzione = new ArrayList<>(parziale);
				
			}
		
			
		
		for(Event e : eventiNerc) {
			if(!parziale.contains(e)) {
				parziale.add(e);
				if(rangeAnno(parziale,e) && maxOre(parziale)) {
					
					cerca(parziale,livello+1);
					
					
				}	
				parziale.remove(e);
			}
				
				
				
			}
		
		}
		
	
	

	

	private boolean maxOre(List<Event> parziale) {
		
		long ore =0;
		
		for(Event e : parziale){
			ore += e.OreTotali().toHours();
		}
		
		
		
		if(ore <= this.maxHour) {
			return true;
		}
		
		return false;
	}

	private boolean rangeAnno(List<Event> parziale, Event e2) {
		
		int maxAnno =0;
		int minAnno =0;
		
		
		
		
		
			for(Event e : parziale) {
				if(minAnno ==0 || e.getDataFine().getYear() < minAnno) {
					minAnno = e.getDataFine().getYear();
				}
			}
			
			for(Event e : parziale) {
				if(maxAnno ==0 || e.getDataFine().getYear() > maxAnno) {
					maxAnno = e.getDataFine().getYear();
				}
			}
		
		
		
//		if(maxAnno ==0 || e2.getDataFine().getYear() > maxAnno) {
//			maxAnno = e2.getDataFine().getYear();
//		}
//		
//		if(minAnno ==0 || e2.getDataFine().getYear() < minAnno) {
//			minAnno = e2.getDataFine().getYear();
//		}
		
		if((maxAnno - minAnno) < maxYear) {
			return true;
		}
		
		return false;
	}

	public int calcolaPersone(List<Event> parziale) {
		
		int tot =0;
		
		if(parziale.size() >1) {
			
			for(Event e : parziale) {
				tot += e.getNumeroPersone();
			}
		}
		
		return tot;
	}

	public long oreTotali(List<Event> ricorsione) {
		
		long ore =0;
		
		for(Event e : ricorsione){
			ore += e.OreTotali().toHours() ;
		}
		
		
		
		return ore;
	}

	public int getMaxYear() {
		// TODO Auto-generated method stub
		return this.maxYear;
	}

	public int getMaxHour() {
		// TODO Auto-generated method stub
		return this.maxHour;
	}
	
		
	

	

	

	
		
			
			
			
		


	
		
	
	
	
	
	}

	


