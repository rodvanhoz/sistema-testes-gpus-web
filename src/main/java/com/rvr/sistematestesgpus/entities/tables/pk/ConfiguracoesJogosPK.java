package com.rvr.sistematestesgpus.entities.tables.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.rvr.sistematestesgpus.entities.tables.Configuracoes;
import com.rvr.sistematestesgpus.entities.tables.Jogos;

@Embeddable
public class ConfiguracoesJogosPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "jogo_id")
	private Jogos jogo;
	
	@ManyToOne
	@JoinColumn(name = "configuracao_id")
	private Configuracoes configuracao;
	
	public Jogos getJogo() {
		return jogo;
	}
	public void setJogo(Jogos jogo) {
		this.jogo = jogo;
	}
	public Configuracoes getConfiguracao() {
		return configuracao;
	}
	public void setConfiguracao(Configuracoes configuracao) {
		this.configuracao = configuracao;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((configuracao == null) ? 0 : configuracao.hashCode());
		result = prime * result + ((jogo == null) ? 0 : jogo.hashCode());
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
		ConfiguracoesJogosPK other = (ConfiguracoesJogosPK) obj;
		if (configuracao == null) {
			if (other.configuracao != null)
				return false;
		} else if (!configuracao.equals(other.configuracao))
			return false;
		if (jogo == null) {
			if (other.jogo != null)
				return false;
		} else if (!jogo.equals(other.jogo))
			return false;
		return true;
	}
	
	
}
