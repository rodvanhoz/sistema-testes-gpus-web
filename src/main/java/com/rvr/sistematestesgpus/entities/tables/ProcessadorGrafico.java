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
@Table(name = "ProcessadorGrafico")
public class ProcessadorGrafico implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProcGrafico;
	
	private String nomeGpu;
	private String variantGpu;
	private String arquitetura;
	private String fundicao;
	private Integer nnProcessador;
	private Double nroTransistors;
	private Integer mmProcessador;
	
	@JsonIgnore
	@OneToOne(mappedBy = "processadorGrafico", cascade = CascadeType.ALL)
	private Gpus gpu;
	
	public ProcessadorGrafico() {
		
	}
	
	public ProcessadorGrafico(Integer idProcGrafico, String nomeGpu, String variantGpu, String arquitetura,
			String fundicao, Integer nnProcessador, Double nroTransistors, Integer mmProcessador) {
		this.idProcGrafico = idProcGrafico;
		this.nomeGpu = nomeGpu;
		this.variantGpu = variantGpu;
		this.arquitetura = arquitetura;
		this.fundicao = fundicao;
		this.nnProcessador = nnProcessador;
		this.nroTransistors = nroTransistors;
		this.mmProcessador = mmProcessador;
	}

	public Integer getIdProcGrafico() {
		return idProcGrafico;
	}

	public void setIdProcGrafico(Integer idProcGrafico) {
		this.idProcGrafico = idProcGrafico;
	}

	public String getNomeGpu() {
		return nomeGpu;
	}

	public void setNomeGpu(String nomeGpu) {
		this.nomeGpu = nomeGpu;
	}

	public String getVariantGpu() {
		return variantGpu;
	}

	public void setVariantGpu(String variantGpu) {
		this.variantGpu = variantGpu;
	}

	public String getArquitetura() {
		return arquitetura;
	}

	public void setArquitetura(String arquitetura) {
		this.arquitetura = arquitetura;
	}

	public String getFundicao() {
		return fundicao;
	}

	public void setFundicao(String fundicao) {
		this.fundicao = fundicao;
	}

	public Integer getNnProcessador() {
		return nnProcessador;
	}

	public void setNnProcessador(Integer nnProcessador) {
		this.nnProcessador = nnProcessador;
	}

	public Double getNroTransistors() {
		return nroTransistors;
	}

	public void setNroTransistors(Double nroTransistors) {
		this.nroTransistors = nroTransistors;
	}

	public Integer getMmProcessador() {
		return mmProcessador;
	}

	public void setMmProcessador(Integer mmProcessador) {
		this.mmProcessador = mmProcessador;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Gpus getGpu() {
		return gpu;
	}

	public void setGpu(Gpus gpu) {
		this.gpu = gpu;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arquitetura == null) ? 0 : arquitetura.hashCode());
		result = prime * result + ((fundicao == null) ? 0 : fundicao.hashCode());
		result = prime * result + ((mmProcessador == null) ? 0 : mmProcessador.hashCode());
		result = prime * result + ((nnProcessador == null) ? 0 : nnProcessador.hashCode());
		result = prime * result + ((nomeGpu == null) ? 0 : nomeGpu.hashCode());
		result = prime * result + ((nroTransistors == null) ? 0 : nroTransistors.hashCode());
		result = prime * result + ((variantGpu == null) ? 0 : variantGpu.hashCode());
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
		ProcessadorGrafico other = (ProcessadorGrafico) obj;
		if (arquitetura == null) {
			if (other.arquitetura != null)
				return false;
		} else if (!arquitetura.equals(other.arquitetura))
			return false;
		if (fundicao == null) {
			if (other.fundicao != null)
				return false;
		} else if (!fundicao.equals(other.fundicao))
			return false;
		if (mmProcessador == null) {
			if (other.mmProcessador != null)
				return false;
		} else if (!mmProcessador.equals(other.mmProcessador))
			return false;
		if (nnProcessador == null) {
			if (other.nnProcessador != null)
				return false;
		} else if (!nnProcessador.equals(other.nnProcessador))
			return false;
		if (nomeGpu == null) {
			if (other.nomeGpu != null)
				return false;
		} else if (!nomeGpu.equals(other.nomeGpu))
			return false;
		if (nroTransistors == null) {
			if (other.nroTransistors != null)
				return false;
		} else if (!nroTransistors.equals(other.nroTransistors))
			return false;
		if (variantGpu == null) {
			if (other.variantGpu != null)
				return false;
		} else if (!variantGpu.equals(other.variantGpu))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return idProcGrafico + ": " + nomeGpu + " / " + variantGpu;
	}
	
}
