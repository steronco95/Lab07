package it.polito.tdp.poweroutages.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		System.out.println(model.getNercList());

		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\");
		
		
		Nerc n = new Nerc(3,"MAAC");
		
		List<Event> temp = model.listaEventi(n);
		StringBuffer result = new StringBuffer();
		for(Event e : temp) {
			result.append(e).append("\n");
		}
		
		
		
		
		System.out.println(result.toString());
		
		System.out.println(model.oreTotali(temp));
		
		System.out.println(model.calcolaPersone(temp));

		
		System.out.println("\n\\\\\\\\\\\\\\\\\\\\\\\\\\\n");
		
//		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\");
//		
//		System.out.println(model.listaEventi(n).get(0).OreTotali());
//		
		System.out.println("\n\\\\\\\\\\\\\\\\\\\\\\\\\n");
		
		StringBuffer result1 = new StringBuffer();
		
		List<Event> ricorsione = model.maxEventi(5,300);
		
		String res = "";
		
		for(Event e : ricorsione) {
			res += e.toString() + "\n";
		}
		
		System.out.println(res);
		
		System.out.println(model.oreTotali(ricorsione));
		
		System.out.println(model.getMaxYear() + " " + model.getMaxHour());
		
		System.out.println(ricorsione.size());
		System.out.println(model.calcolaPersone(ricorsione));
		
	}

}
