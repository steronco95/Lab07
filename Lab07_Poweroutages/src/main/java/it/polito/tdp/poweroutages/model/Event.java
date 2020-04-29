package it.polito.tdp.poweroutages.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Event {

	private LocalDateTime dataInizio;
	private LocalDateTime dataFine;
	private int anno;
	private int numeroPersone;

	public Event(LocalDateTime inizio, LocalDateTime fine, int i) {
		this.dataInizio = inizio;
		this.dataFine = fine;
		this.numeroPersone = i;
	}

	
	
	public LocalDateTime getDataInizio() {
		return dataInizio;
	}



	public void setDataInizio(LocalDateTime dataInizio) {
		this.dataInizio = dataInizio;
	}



	public LocalDateTime getDataFine() {
		return dataFine;
	}



	public void setDataFine(LocalDateTime dataFine) {
		this.dataFine = dataFine;
	}

	public int getNumeroPersone() {
		
		return numeroPersone;
	}
	
	public int getAnno() {
		
		return dataInizio.getYear();
	}
	
	public long OreTotali() {
		
		 
		
		long intervallo = (Duration.between(dataInizio, dataFine).getSeconds());
		
		return intervallo;
	}


	public String toString() {
		
		return this.getAnno() + " " + dataInizio.toString() + " " + dataFine.toString() + " "  + this.OreTotali() + " " + numeroPersone;
	}

}
