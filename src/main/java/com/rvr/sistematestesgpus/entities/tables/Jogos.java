package com.rvr.sistematestesgpus.entities.tables;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Jogos")
public class Jogos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idJogo;
	
	private String nomeJogo;
	private Date dtLancto;
	
	@OneToOne(mappedBy = "jogo", cascade = CascadeType.ALL)
	private ConfiguracoesJogos configuracaoJogo;
	
	public Jogos() {
		
	}
	
	public Jogos(Integer idJogo, String nomeJogo, Date dtLancto) {
		this.idJogo = idJogo;
		this.nomeJogo = nomeJogo;
		this.dtLancto = dtLancto;
	}
	
	public Jogos(Jogos jogo) {
		this.idJogo = jogo.getIdJogo();
		this.nomeJogo = jogo.getNomeJogo();
		this.dtLancto = jogo.getDtLancto();
	}

	public Integer getIdJogo() {
		return idJogo;
	}

	public void setIdJogo(Integer idJogo) {
		this.idJogo = idJogo;
	}

	public String getNomeJogo() {
		return nomeJogo;
	}

	public void setNomeJogo(String nomeJogo) {
		this.nomeJogo = nomeJogo;
	}

	public Date getDtLancto() {
		return dtLancto;
	}

	public void setDtLancto(Date dtLancto) {
		this.dtLancto = dtLancto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dtLancto == null) ? 0 : dtLancto.hashCode());
		result = prime * result + ((nomeJogo == null) ? 0 : nomeJogo.hashCode());
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
		Jogos other = (Jogos) obj;
		if (dtLancto == null) {
			if (other.dtLancto != null)
				return false;
		} else if (!dtLancto.equals(other.dtLancto))
			return false;
		if (nomeJogo == null) {
			if (other.nomeJogo != null)
				return false;
		} else if (!nomeJogo.equals(other.nomeJogo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return idJogo + " - " + nomeJogo;
	}
	
}
