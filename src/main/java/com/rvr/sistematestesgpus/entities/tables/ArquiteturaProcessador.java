package com.rvr.sistematestesgpus.entities.tables;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ArquiteturaProcessador")
public class ArquiteturaProcessador implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idArquiteturaProc;
	
	private Arquiteturas Arquitetura;
	private Processadores Processador;
	
	public ArquiteturaProcessador() {
		
	}
	
	public ArquiteturaProcessador(Integer idArquiteturaProc, Arquiteturas arquitetura, Processadores processador) {
		this.idArquiteturaProc = idArquiteturaProc;
		Arquitetura = arquitetura;
		Processador = processador;
	}

	public Integer getIdArquiteturaProc() {
		return idArquiteturaProc;
	}

	public void setIdArquiteturaProc(Integer idArquiteturaProc) {
		this.idArquiteturaProc = idArquiteturaProc;
	}

	public Arquiteturas getArquitetura() {
		return Arquitetura;
	}

	public void setArquitetura(Arquiteturas arquitetura) {
		Arquitetura = arquitetura;
	}

	public Processadores getProcessador() {
		return Processador;
	}

	public void setProcessador(Processadores processador) {
		Processador = processador;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ArquiteturaProcessador [idArquiteturaProc=" + idArquiteturaProc + ", Arquitetura=" + Arquitetura.getNomeArquitetura()
				+ ", Processador=" + Processador + "]";
	}
	
}
