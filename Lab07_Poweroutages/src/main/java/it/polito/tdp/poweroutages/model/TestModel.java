package it.polito.tdp.poweroutages.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		System.out.println(model.getNercList());

		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\");
		
		
		Nerc n = new Nerc(12,"MRO");
		
		List<Event> temp = model.listaEventi(n);
		StringBuffer result = new StringBuffer();
		for(Event e : temp) {
			result.append(e).append("\n");
		}
		
		
		
		System.out.println(result.toString());
		System.out.println("\n\\\\\\\\\\\\\\\\\\\\\\\\\\\n");
		
//		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\");
//		
//		System.out.println(model.listaEventi(n).get(0).OreTotali());
//		
		System.out.println("\n\\\\\\\\\\\\\\\\\\\\\\\\\n");
		
		StringBuffer result1 = new StringBuffer();
		
		List<Event> ricorsione = model.maxEventi(4,1000);
		
		for(Event e : ricorsione) {
			result.append(e).append("\n");
		}
		
		System.out.println(result.toString());
		
		
		
		
	}

}
