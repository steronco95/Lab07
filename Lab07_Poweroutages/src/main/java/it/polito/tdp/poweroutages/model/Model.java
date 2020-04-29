package it.polito.tdp.poweroutages.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.stream.Collectors.*;
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
		
		cerca(parziale);
		
		return bestSoluzione;
	}

	private void cerca(List<Event> parziale) {
		
		
			
			
			if( bestSoluzione == null || this.calcolaPersone(parziale) > this.calcolaPersone(bestSoluzione)) {
				bestSoluzione = new ArrayList<>(parziale);
				
			}
		
		
		
		for(Event e : eventiNerc) {
			if(!parziale.contains(e)) {
				parziale.add(e);
				if(rangeAnno(parziale)  && maxOre(parziale)) {
					cerca(parziale);
					parziale.remove(e);
					
				}
				parziale.remove(e);
			
			}
			
			
				return;
				
				
				
				
			}
		
		}
		
	
	

	

	private boolean maxOre(List<Event> parziale) {
		
		long ore =0;
		
		for(Event e : parziale){
			ore += e.OreTotali();
		}
		
		
		
		if((ore/3600) <= this.maxHour) {
			return true;
		}
		
		return false;
	}

	private boolean rangeAnno(List<Event> parziale) {
		
		int maxAnno =0;
		int minAnno =0;
		
		for(Event e : parziale) {
			if(minAnno ==0 || e.getAnno() < minAnno) {
				minAnno = e.getAnno();
			}
		}
		
		for(Event e : parziale) {
			if(maxAnno ==0 || e.getAnno() > maxAnno) {
				maxAnno = e.getAnno();
			}
		}
		
		if((maxAnno - minAnno) <= maxYear) {
			return true;
		}
		
		return false;
	}

	private int calcolaPersone(List<Event> parziale) {
		
		int tot =0;
		
		if(parziale.size() >1) {
			
			for(Event e : parziale) {
				tot += e.getNumeroPersone();
			}
		}
		
		return tot;
	}
	
		
	

	

	

	
		
			
			
			
		


	
		
	
	
	
	
	}

	


