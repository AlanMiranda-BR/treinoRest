package com.fish2048.training;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fish2048.training.domain.Povoamento;
import com.fish2048.training.repositories.PovoamentoRepository;

/**
 * @author Alan Felipe Miranda 
 * Starter do SpringBoot, criado automaticamente
 * pelo "Spring Starter Project". o implements CommandLineRunner é
 * utilizado para rodar o método run(String... args), é usado somente
 * para testes para criar registros no Banco de dados e deve ser
 * removido na versão "final".
 */
@SpringBootApplication
public class TrainingApplication implements CommandLineRunner {

	// Instanciação dos Repositories (Somente para testes)
	@Autowired
	private PovoamentoRepository povoamentoRepository;

	// Apenas este método deve permancer na versão final
	public static void main(String[] args) {
		SpringApplication.run(TrainingApplication.class, args);
	}

	// Criação dos registros das tabelas do Banco de Dados (Somente para testes)
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Povoamento pov1 = new Povoamento(null, 5000, sdf.parse("12/04/2018 14:40"));
		Povoamento pov2 = new Povoamento(null, 20000, sdf.parse("22/10/2018 04:50"));
		Povoamento pov3 = new Povoamento(null, 9000, sdf.parse("20/01/2019 16:00"));

		povoamentoRepository.saveAll(Arrays.asList(pov1, pov2, pov3));
	}

}
