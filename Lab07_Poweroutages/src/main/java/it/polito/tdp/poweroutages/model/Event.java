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
	private int id;

	public Event(int id, LocalDateTime inizio, LocalDateTime fine, int i) {
		this.id = id;
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
	
	public Duration OreTotali() {
		
		 
		
		Duration intervallo = Duration.between(dataInizio, dataFine);
		
		return intervallo;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + anno;
		result = prime * result + ((dataFine == null) ? 0 : dataFine.hashCode());
		result = prime * result + ((dataInizio == null) ? 0 : dataInizio.hashCode());
		result = prime * result + id;
		result = prime * result + numeroPersone;
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (anno != other.anno)
			return false;
		if (dataFine == null) {
			if (other.dataFine != null)
				return false;
		} else if (!dataFine.equals(other.dataFine))
			return false;
		if (dataInizio == null) {
			if (other.dataInizio != null)
				return false;
		} else if (!dataInizio.equals(other.dataInizio))
			return false;
		if (id != other.id)
			return false;
		if (numeroPersone != other.numeroPersone)
			return false;
		return true;
	}



	public String toString() {
		
		return this.getAnno() + " " + dataInizio.toString() + " " + dataFine.toString() + " "  + this.OreTotali() + " " + numeroPersone;
	}

}
