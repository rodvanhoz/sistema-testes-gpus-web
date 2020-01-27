package com.rvr.sistematestesgpus.entities.tables;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TestesGpu")
public class TestesGpu implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTesteGpu;
		
	@OneToOne
	@JoinColumn(name = "IdGpu")
	private Gpus gpu;
	
	@OneToOne
	@JoinColumn(name = "IdProcessador")
	private Processadores processador;
	
	@OneToOne
	@JoinColumn(name = "IdConfiguracaoJogo")
	private ConfiguracoesJogos configuracaoJogo;
	
	private String nomeDriverGpu;
	private Double avgFps;
	private Double minFps;
	private Date dtTeste;
	private String nomeTester;
	
	public TestesGpu() {
		
	}
	
	public TestesGpu(Integer idTesteGpu, ConfiguracoesJogos configuracaoJogo, Gpus gpu, Processadores processador,
			String nomeDriverGpu, Double avgFps, Double minFps, Date dtTeste, String nomeTester) {
		this.idTesteGpu = idTesteGpu;
		this.configuracaoJogo = configuracaoJogo;
		this.gpu = gpu;
		this.processador = processador;
		this.nomeDriverGpu = nomeDriverGpu;
		this.avgFps = avgFps;
		this.minFps = minFps;
		this.dtTeste = dtTeste;
		this.nomeTester = nomeTester;
	}
	
	public Integer getIdTesteGpu() {
		return idTesteGpu;
	}
	
	public void setIdTesteGpu(Integer idTesteGpu) {
		this.idTesteGpu = idTesteGpu;
	}
	
	public ConfiguracoesJogos getConfiguracaoJogo() {
		return configuracaoJogo;
	}
	
	public void setConfiguracaoJogo(ConfiguracoesJogos configuracaoJogo) {
		this.configuracaoJogo = configuracaoJogo;
	}
	
	public Gpus getGpu() {
		return gpu;
	}
	
	public void setGpu(Gpus gpu) {
		this.gpu = gpu;
	}
	
	public Processadores getProcessador() {
		return processador;
	}
	
	public void setProcessador(Processadores processador) {
		this.processador = processador;
	}
	
	public String getNomeDriverGpu() {
		return nomeDriverGpu;
	}
	
	public void setNomeDriverGpu(String nomeDriverGpu) {
		this.nomeDriverGpu = nomeDriverGpu;
	}
	
	public Double getAvgFps() {
		return avgFps;
	}
	
	public void setAvgFps(Double avgFps) {
		this.avgFps = avgFps;
	}
	
	public Double getMinFps() {
		return minFps;
	}
	
	public void setMinFps(Double minFps) {
		this.minFps = minFps;
	}
	
	public Date getDtTeste() {
		return dtTeste;
	}
	
	public void setDtTeste(Date dtTeste) {
		this.dtTeste = dtTeste;
	}
	
	public String getNomeTester() {
		return nomeTester;
	}
	
	public void setNomeTester(String nomeTester) {
		this.nomeTester = nomeTester;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	@Override
	public String toString() {
		return "TestesGpu [idTesteGpu=" + idTesteGpu + ", ConfiguracaoJogo=" + configuracaoJogo + ", Gpu=" + gpu.getNomeModelo()
				+ ", Processador=" + processador.getNomeModelo() + ", nomeDriverGpu=" + nomeDriverGpu + ", avgFps=" + avgFps
				+ ", minFps=" + minFps + ", dtTeste=" + dtTeste + ", nomeTester=" + nomeTester + "]";
	}
	
	
}
