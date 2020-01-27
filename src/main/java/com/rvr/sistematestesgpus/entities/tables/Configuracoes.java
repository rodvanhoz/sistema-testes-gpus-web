package com.rvr.sistematestesgpus.entities.tables;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Configuracoes")
public class Configuracoes implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConfiguracao;
	
	private Integer resolucaoAbrev;
	private String resolucaoDetalhe;
	private String api;
	private String qualidadeGrafica;
	private String ssao;
	private String fxaa;
	private String taa;
	private String rt;
	private String aa;
	private String NVidiaTec;
	
	@OneToOne(mappedBy = "configuracao")
	private ConfiguracoesJogos configuracaoJogo;
	
	public Configuracoes() {
		
	}
	
	public Configuracoes(Integer idConfiguracao, Integer resolucaoAbrev, String resolucaoDetalhe, String api,
			String qualidadeGrafica, String ssao, String fxaa, String taa, String rt, String aa, String nVidiaTec) {
		this.idConfiguracao = idConfiguracao;
		this.resolucaoAbrev = resolucaoAbrev;
		this.resolucaoDetalhe = resolucaoDetalhe;
		this.api = api;
		this.qualidadeGrafica = qualidadeGrafica;
		this.ssao = ssao;
		this.fxaa = fxaa;
		this.taa = taa;
		this.rt = rt;
		this.aa = aa;
		this.NVidiaTec = nVidiaTec;
	}
	
	public Configuracoes(Configuracoes configuracoes) {
		this.idConfiguracao = configuracoes.getIdConfiguracao();
		this.resolucaoAbrev = configuracoes.getResolucaoAbrev();
		this.resolucaoDetalhe = configuracoes.getResolucaoDetalhe();
		this.api = configuracoes.getApi();
		this.qualidadeGrafica = configuracoes.getQualidadeGrafica();
		this.ssao = configuracoes.getSsao();
		this.fxaa = configuracoes.getFxaa();
		this.taa = configuracoes.getTaa();
		this.rt = configuracoes.getRt();
		this.aa = configuracoes.getAa();
		this.NVidiaTec = configuracoes.getNVidiaTec();
	}

	public Integer getIdConfiguracao() {
		return idConfiguracao;
	}

	public void setIdConfiguracao(Integer idConfiguracao) {
		this.idConfiguracao = idConfiguracao;
	}

	public Integer getResolucaoAbrev() {
		return resolucaoAbrev;
	}

	public void setResolucaoAbrev(Integer resolucaoAbrev) {
		this.resolucaoAbrev = resolucaoAbrev;
	}

	public String getResolucaoDetalhe() {
		return resolucaoDetalhe;
	}

	public void setResolucaoDetalhe(String resolucaoDetalhe) {
		this.resolucaoDetalhe = resolucaoDetalhe;
	}

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}

	public String getQualidadeGrafica() {
		return qualidadeGrafica;
	}

	public void setQualidadeGrafica(String qualidadeGrafica) {
		this.qualidadeGrafica = qualidadeGrafica;
	}

	public String getSsao() {
		return ssao;
	}

	public void setSsao(String ssao) {
		this.ssao = ssao;
	}

	public String getFxaa() {
		return fxaa;
	}

	public void setFxaa(String fxaa) {
		this.fxaa = fxaa;
	}

	public String getTaa() {
		return taa;
	}

	public void setTaa(String taa) {
		this.taa = taa;
	}

	public String getRt() {
		return rt;
	}

	public void setRt(String rt) {
		this.rt = rt;
	}

	public String getAa() {
		return aa;
	}

	public void setAa(String aa) {
		this.aa = aa;
	}

	public String getNVidiaTec() {
		return NVidiaTec;
	}

	public void setNVidiaTec(String nVidiaTec) {
		NVidiaTec = nVidiaTec;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((NVidiaTec == null) ? 0 : NVidiaTec.hashCode());
		result = prime * result + ((aa == null) ? 0 : aa.hashCode());
		result = prime * result + ((api == null) ? 0 : api.hashCode());
		result = prime * result + ((fxaa == null) ? 0 : fxaa.hashCode());
		result = prime * result + ((qualidadeGrafica == null) ? 0 : qualidadeGrafica.hashCode());
		result = prime * result + ((resolucaoAbrev == null) ? 0 : resolucaoAbrev.hashCode());
		result = prime * result + ((resolucaoDetalhe == null) ? 0 : resolucaoDetalhe.hashCode());
		result = prime * result + ((rt == null) ? 0 : rt.hashCode());
		result = prime * result + ((ssao == null) ? 0 : ssao.hashCode());
		result = prime * result + ((taa == null) ? 0 : taa.hashCode());
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
		Configuracoes other = (Configuracoes) obj;
		if (NVidiaTec == null) {
			if (other.NVidiaTec != null)
				return false;
		} else if (!NVidiaTec.equals(other.NVidiaTec))
			return false;
		if (aa == null) {
			if (other.aa != null)
				return false;
		} else if (!aa.equals(other.aa))
			return false;
		if (api == null) {
			if (other.api != null)
				return false;
		} else if (!api.equals(other.api))
			return false;
		if (fxaa == null) {
			if (other.fxaa != null)
				return false;
		} else if (!fxaa.equals(other.fxaa))
			return false;
		if (qualidadeGrafica == null) {
			if (other.qualidadeGrafica != null)
				return false;
		} else if (!qualidadeGrafica.equals(other.qualidadeGrafica))
			return false;
		if (resolucaoAbrev == null) {
			if (other.resolucaoAbrev != null)
				return false;
		} else if (!resolucaoAbrev.equals(other.resolucaoAbrev))
			return false;
		if (resolucaoDetalhe == null) {
			if (other.resolucaoDetalhe != null)
				return false;
		} else if (!resolucaoDetalhe.equals(other.resolucaoDetalhe))
			return false;
		if (rt == null) {
			if (other.rt != null)
				return false;
		} else if (!rt.equals(other.rt))
			return false;
		if (ssao == null) {
			if (other.ssao != null)
				return false;
		} else if (!ssao.equals(other.ssao))
			return false;
		if (taa == null) {
			if (other.taa != null)
				return false;
		} else if (!taa.equals(other.taa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return idConfiguracao + " - " + resolucaoAbrev + "p - " + api + " - " + qualidadeGrafica
				+ ", ssao: " + ssao + ", fxaa: " + fxaa + ", taa: " + taa + ", rt: " + rt + ", aa: " + aa + ", NVidiaTec: "
				+ NVidiaTec;
	}	
	
}
