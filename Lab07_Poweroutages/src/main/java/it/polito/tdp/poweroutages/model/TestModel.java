package it.polito.tdp.poweroutages.model;

public class TestModel {

	public static void main(String[] args) {
		
		Model model = new Model();
		System.out.println(model.getNercList());

		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\");
		
		Nerc n = new Nerc(12,"MRO");
		StringBuffer result = new StringBuffer();
		for(Event e : model.listaEventi(n)) {
			result.append(e).append("\n");
		}
		
		System.out.println(result.toString());
		
//		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\");
//		
//		System.out.println(model.listaEventi(n).get(0).OreTotali());
//		
		System.out.println("\n\\\\\\\\\\\\\\\\\\\\\\\\\n");
		
		System.out.println(model.maxEventi(2, 50));
		
		
	}

}
