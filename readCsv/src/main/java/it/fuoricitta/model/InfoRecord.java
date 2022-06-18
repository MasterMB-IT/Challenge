package it.fuoricitta.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inforecord")
public class InfoRecord {
	
	@Id
	@Column(name = "idRecord")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRecord;
	
	
	@Column(name = "nome_record")
	private String nomeFile;
	
	@Column(name = "dimensione")
	private long dimensioneFile;
	
	public InfoRecord() {
	}

	public int getIdRecord() {
		return idRecord;
	}
	

	public void setIdRecord(int idRecord) {
		this.idRecord = idRecord;
	}



	public String getNomeFile() {
		return nomeFile;
	}

	public void setNomeFile(String nomeFile) {
		this.nomeFile = nomeFile;
	}

	public long getDimensioneFile() {
		return dimensioneFile;
	}

	public void setDimensioneFile(long dimensioneFile) {
		this.dimensioneFile = dimensioneFile;
	}
	
}
