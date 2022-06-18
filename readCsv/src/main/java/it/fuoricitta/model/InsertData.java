package it.fuoricitta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "record")
public class InsertData {
	
	@Id
	@Column(name = "idRecord")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;
	
	@Column(name = "description", length = 25)
	private String description;
	
	@Column(name = "scadenza", length = 25)
	private String scadenza;
	
	@Column(name = "valore", length = 10)
	private double valore;
	
	public InsertData() {
	}

	public InsertData(int code, String description, String scadenza, double valore) {
		this.code = code;
		this.description = description;
		this.scadenza = scadenza;
		this.valore = valore;
	}



	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getScadenza() {
		return scadenza;
	}

	public void setScadenza(String scadenza) {
		this.scadenza = scadenza;
	}

	public double getValore() {
		return valore;
	}

	public void setValore(double valore) {
		this.valore = valore;
	}

	
}
