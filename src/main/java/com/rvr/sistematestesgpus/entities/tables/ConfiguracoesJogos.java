package com.rvr.sistematestesgpus.entities.tables;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rvr.sistematestesgpus.entities.tables.pk.ConfiguracoesJogosPK;

@Entity
@Table(name = "ConfiguracoesJogos")
public class ConfiguracoesJogos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ConfiguracoesJogosPK id = new ConfiguracoesJogosPK();
	
	public ConfiguracoesJogos() {
		
	}
	
	public ConfiguracoesJogos(Jogos jogo, Configuracoes configuracao) {
		this.id.setJogo(jogo);
		this.id.setConfiguracao(configuracao);
	}
	
	@JsonIgnore
	public Jogos getJogo() {
		return id.getJogo();
	}

	public void setJogo(Jogos jogo) {
		id.setJogo(jogo);
	}

	public Configuracoes getConfiguracao() {
		return id.getConfiguracao();
	}

	public void setConfiguracao(Configuracoes configuracao) {
		id.setConfiguracao(configuracao);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ConfiguracoesJogos other = (ConfiguracoesJogos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ConfiguracoesJogos: , Jogo=" + id.getJogo().getNomeJogo() + ", Configuracao="
				+ id.getConfiguracao().getQualidadeGrafica() + "]";
	}
	
}
