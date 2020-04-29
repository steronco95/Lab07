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

	private void cerca(List<Event> parziale, int livello) {		
				
				
			}
		
			
			
			
		


	
		
	
	
	
	
	}

	


