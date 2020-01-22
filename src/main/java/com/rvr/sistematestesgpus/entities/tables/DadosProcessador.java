package com.rvr.sistematestesgpus.entities.tables;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "DadosProcessador")
public class DadosProcessador implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDadosProcessador;
	private String socket;
	private String foundry;
	private Integer processSize;
	private Double transistors;
	private String packag;
	private Double tCaseMax;
	
	@JsonIgnore
	@OneToOne(mappedBy = "dadosProcessador", cascade = CascadeType.ALL)
	private Processadores processador;
	
	public DadosProcessador() {
		
	}
	
	public DadosProcessador(Integer idDadosProcessador, String socket, String foundry, Integer processSize,
			Double transistors, String packag, Double tCaseMax) {
		this.idDadosProcessador = idDadosProcessador;
		this.socket = socket;
		this.foundry = foundry;
		this.processSize = processSize;
		this.transistors = transistors;
		this.packag = packag;
		this.tCaseMax = tCaseMax;
	}

	public Integer getIdDadosProcessador() {
		return idDadosProcessador;
	}

	public void setIdDadosProcessador(Integer idDadosProcessador) {
		this.idDadosProcessador = idDadosProcessador;
	}

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}

	public String getFoundry() {
		return foundry;
	}

	public void setFoundry(String foundry) {
		this.foundry = foundry;
	}

	public Integer getProcessSize() {
		return processSize;
	}

	public void setProcessSize(Integer processSize) {
		this.processSize = processSize;
	}

	public Double getTransistors() {
		return transistors;
	}

	public void setTransistors(Double transistors) {
		this.transistors = transistors;
	}

	public String getPackag() {
		return packag;
	}

	public void setPackag(String packag) {
		this.packag = packag;
	}

	public Double gettCaseMax() {
		return tCaseMax;
	}

	public void settCaseMax(Double tCaseMax) {
		this.tCaseMax = tCaseMax;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Processadores getProcessador() {
		return processador;
	}

	public void setProcessador(Processadores processador) {
		this.processador = processador;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((foundry == null) ? 0 : foundry.hashCode());
		result = prime * result + ((packag == null) ? 0 : packag.hashCode());
		result = prime * result + ((processSize == null) ? 0 : processSize.hashCode());
		result = prime * result + ((socket == null) ? 0 : socket.hashCode());
		result = prime * result + ((tCaseMax == null) ? 0 : tCaseMax.hashCode());
		result = prime * result + ((transistors == null) ? 0 : transistors.hashCode());
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
		DadosProcessador other = (DadosProcessador) obj;
		if (foundry == null) {
			if (other.foundry != null)
				return false;
		} else if (!foundry.equals(other.foundry))
			return false;
		if (packag == null) {
			if (other.packag != null)
				return false;
		} else if (!packag.equals(other.packag))
			return false;
		if (processSize == null) {
			if (other.processSize != null)
				return false;
		} else if (!processSize.equals(other.processSize))
			return false;
		if (socket == null) {
			if (other.socket != null)
				return false;
		} else if (!socket.equals(other.socket))
			return false;
		if (tCaseMax == null) {
			if (other.tCaseMax != null)
				return false;
		} else if (!tCaseMax.equals(other.tCaseMax))
			return false;
		if (transistors == null) {
			if (other.transistors != null)
				return false;
		} else if (!transistors.equals(other.transistors))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return idDadosProcessador + ": " + socket + ", foundry="
				+ foundry + ", processSize=" + processSize + ", transistors=" + transistors + ", packag=" + packag
				+ ", tCaseMax=" + tCaseMax + "]";
	}
}
