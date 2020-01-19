package com.rvr.sistematestesgpus.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rvr.sistematestesgpus.entities.tables.Configuracoes;
import com.rvr.sistematestesgpus.entities.tables.ConfiguracoesJogos;
import com.rvr.sistematestesgpus.entities.tables.Jogos;
import com.rvr.sistematestesgpus.repositories.ConfiguracoesJogosRepository;
import com.rvr.sistematestesgpus.repositories.ConfiguracoesRepository;
import com.rvr.sistematestesgpus.repositories.JogosRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private JogosRepository jogoRepository;
	
	@Autowired
	private ConfiguracoesRepository configuracaoRepository;
	
	@Autowired
	private ConfiguracoesJogosRepository configuracoesJogosRepository;

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
	}
	
	
}
