package com.rvr.sistematestesgpus.entities.tables;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ConfiguracoesJogos")
public class ConfiguracoesJogos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConfiguracaoJogos;
	
	@ManyToOne
	@JoinColumn(name = "IdJogo")
	private Jogos jogo;
	
	@ManyToOne
	@JoinColumn(name = "IdConfiguracao")
	private Configuracoes configuracao;
	
	public ConfiguracoesJogos() {
		
	}
	
	public ConfiguracoesJogos(Jogos jogo, Configuracoes configuracao) {
		this.jogo = jogo;
		this.configuracao = configuracao;
	}

	public Integer getIdConfiguracaoJogos() {
		return idConfiguracaoJogos;
	}

	public void setIdConfiguracaoJogos(Integer idConfiguracaoJogos) {
		this.idConfiguracaoJogos = idConfiguracaoJogos;
	}

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
	public String toString() {
		return "ConfiguracoesJogos: , Jogo=" + jogo.getNomeJogo() + ", Configuracao="
				+ configuracao.getQualidadeGrafica() + "]";
	}
	
}
