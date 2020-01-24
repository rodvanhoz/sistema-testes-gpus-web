package com.rvr.sistematestesgpus.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rvr.sistematestesgpus.entities.tables.CaracteristicasGraficas;
import com.rvr.sistematestesgpus.entities.tables.Configuracoes;
import com.rvr.sistematestesgpus.entities.tables.ConfiguracoesJogos;
import com.rvr.sistematestesgpus.entities.tables.DadosProcessador;
import com.rvr.sistematestesgpus.entities.tables.Gpus;
import com.rvr.sistematestesgpus.entities.tables.Jogos;
import com.rvr.sistematestesgpus.entities.tables.ProcessadorGrafico;
import com.rvr.sistematestesgpus.entities.tables.Processadores;
import com.rvr.sistematestesgpus.entities.tables.RenderConfig;
import com.rvr.sistematestesgpus.repositories.CaracteristicasGraficasRepository;
import com.rvr.sistematestesgpus.repositories.ConfiguracoesJogosRepository;
import com.rvr.sistematestesgpus.repositories.ConfiguracoesRepository;
import com.rvr.sistematestesgpus.repositories.DadosProcessadorRepository;
import com.rvr.sistematestesgpus.repositories.GpusRepository;
import com.rvr.sistematestesgpus.repositories.JogosRepository;
import com.rvr.sistematestesgpus.repositories.ProcessadorGraficoRepository;
import com.rvr.sistematestesgpus.repositories.RenderConfigRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private JogosRepository jogoRepository;
	
	@Autowired
	private ConfiguracoesRepository configuracaoRepository;
	
	@Autowired
	private ConfiguracoesJogosRepository configuracoesJogosRepository;
	
	@Autowired
	private DadosProcessadorRepository dadosProcessadorRepository;
	
	@Autowired
	private ProcessadorGraficoRepository processadorGraficoRepository;
	
	@Autowired
	private CaracteristicasGraficasRepository caracteristicasGraficasRepository;
	
	@Autowired
	private RenderConfigRepository renderConfigRepository;
	
	@Autowired
	private GpusRepository gpuRepository; 
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Jogos j1 = new Jogos(null, "Borderlands", sdf.parse("10/01/2010"));
		jogoRepository.saveAll(Arrays.asList(j1));
		
		Configuracoes c1 = new Configuracoes(null, 1080, "1920x1080", "DX9", "Ultra Graphics Present Settings", "N", "N", "N", "N", "N", "N");
		Configuracoes c2 = new Configuracoes(null, 1080, "1920x1080", "DX9", "Medium Graphics Present Settings", "N", "N", "N", "N", "N", "N");
		Configuracoes c3 = new Configuracoes(null, 1080, "1920x1080", "DX9", "Low Graphics Present Settings", "N", "N", "N", "N", "N", "N");
		configuracaoRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		ConfiguracoesJogos cj1 = new ConfiguracoesJogos(j1, c1);
		ConfiguracoesJogos cj2 = new ConfiguracoesJogos(j1, c2);
		ConfiguracoesJogos cj3 = new ConfiguracoesJogos(j1, c3);
		configuracoesJogosRepository.saveAll(Arrays.asList(cj1, cj2, cj3));
		
		DadosProcessador dp1 = new DadosProcessador(null, "Intel Socket 1151", "Intel", 14, null, "FC-LGA1151", 72.0);
		dadosProcessadorRepository.saveAll(Arrays.asList(dp1));
		
		Processadores p1 = new Processadores(null, dp1, "Intel", "Core i7-8700", "Desktop",  sdf.parse("10/01/2010"), "Coffee Lake", null, "DDR4", 3200.0, 4600.0, 100.0, 32.0, "N", 6, 12, 1, null, 65.0);
		dp1.setProcessador(p1);
		dadosProcessadorRepository.saveAll(Arrays.asList(dp1));
		
		
		ProcessadorGrafico pg1 = new ProcessadorGrafico(null, "Navi 10", "Navi 10 XT ", "RDNA 1.0", "TSMC", 7, 10.300 , 251);
		ProcessadorGrafico pg2 = new ProcessadorGrafico(null, "Navi 20", "Navi 20 XT ", "RDNA 2.0", "TSMC", 7, 10.300 , 251);
		ProcessadorGrafico pg3 = new ProcessadorGrafico(null, "Navi 14", "Navi 14 XT ", "RDNA 3.0", "TSMC", 7, 10.300 , 251);
		
		CaracteristicasGraficas cg1 = new CaracteristicasGraficas(null, "11.0 (12_1)", "4.0", "1.2", "1.1.117", "7.5", "6.4");
		CaracteristicasGraficas cg2 = new CaracteristicasGraficas(null, "10.0 (10_0)", "3.6", "1.2", "1.1.117", "7.5", "6.4");
		CaracteristicasGraficas cg3 = new CaracteristicasGraficas(null, "12.0 (12_1)", "4.6", "1.2", "1.1.117", "7.5", "6.4");

		RenderConfig rc1 = new RenderConfig(null, 2176, 136, 64, 34, 64, 4096, 272, 34);
		RenderConfig rc2 = new RenderConfig(null, 1176, 36, 34, 34, 64, 4096, 272, 34);
		RenderConfig rc3 = new RenderConfig(null, 7176, 136, 64, 34, 64, 4096, 272, 34);
		
		processadorGraficoRepository.saveAll(Arrays.asList(pg1, pg2, pg3));
		caracteristicasGraficasRepository.saveAll(Arrays.asList(cg1, cg2, cg3));
		renderConfigRepository.saveAll(Arrays.asList(rc1, rc2, rc3));

		Gpus g1 = new Gpus(null, pg1, cg1, rc1, "NVIDIA", "GeForce RTX 2060 SUPER", 8192, "GDDR6", 256, 160.0, 1470.0, 1650.0, 1750.0, 14000.0, "PCIe 3.0 x16", sdf.parse("10/01/2010"));
		
		pg1.setGpu(g1);
		cg1.setGpu(g1);
		rc1.setGpu(g1);
		
//		processadorGraficoRepository.saveAll(Arrays.asList(pg1));
//		caracteristicasGraficasRepository.saveAll(Arrays.asList(cg1));
//		renderConfigRepository.saveAll(Arrays.asList(rc1));
		
		gpuRepository.saveAll(Arrays.asList(g1));
		
}
	
	
}
