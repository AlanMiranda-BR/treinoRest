package com.fish2048.training;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fish2048.training.domain.Biometria;
import com.fish2048.training.domain.Cultivo;
import com.fish2048.training.domain.Ph;
import com.fish2048.training.domain.Povoamento;
import com.fish2048.training.domain.Propriedade;
import com.fish2048.training.repositories.BiometriaRepository;
import com.fish2048.training.repositories.CultivoRepository;
import com.fish2048.training.repositories.PhRepository;
import com.fish2048.training.repositories.PovoamentoRepository;
import com.fish2048.training.repositories.PropriedadeRepository;

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
	@Autowired
	private PropriedadeRepository propriedadeRepository;
	@Autowired
	private CultivoRepository cultivoRepository;
	@Autowired
	private BiometriaRepository biometriaRepository;
	@Autowired
	private PhRepository phRepository;
	
	// Apenas este método deve permancer na versão final
	public static void main(String[] args) {
		SpringApplication.run(TrainingApplication.class, args);
	}

	// Criação dos registros das tabelas do Banco de Dados (Somente para testes)
	public void run(String... args) throws Exception {
		
//inserts de povoamento
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Povoamento pov1 = new Povoamento(null, 5000, sdf.parse("12/04/2018 14:40"));
		Povoamento pov2 = new Povoamento(null, 20000, sdf.parse("22/10/2018 04:50"));
		Povoamento pov3 = new Povoamento(null, 9000, sdf.parse("20/01/2019 16:00"));
		povoamentoRepository.saveAll(Arrays.asList(pov1, pov2, pov3));
		
		//INSERT DE PROPRIEDADE
		Propriedade prop1 = new Propriedade(null, 2, 3, "emailprop1@teste.com", 47991109, 88334091,"Bairro Propriedade 1","Cidade da Propriedade 1",01,"Endereço Propriedade 1 rua","Nome Primeira Propriedade","Nome do Proprietario UM","Observacoes 1");
		Propriedade prop2 = new Propriedade(null, 2, 3, "emailprop2@teste.com", 5533325, 9944091,"Bairro Propriedade 2","Cidade da Propriedade 2",01,"Endereço Propriedade 2 rua","Nome SEGUNDA Propriedade","Nome do Proprietario DOIS","Observacoes 2");
		Propriedade prop3 = new Propriedade(null, 2, 3, "emailprop3@teste.com", 88222365, 333331,"Bairro Propriedade 3","Cidade da Propriedade 3",01,"Endereço Propriedade 3 rua","Nome tereira Propriedade","Nome do Proprietario TRES", "OBS3");
		propriedadeRepository.saveAll(Arrays.asList(prop1, prop2, prop3));
		
		//INSERT DE CULTIVOS
		Cultivo cult1 = new Cultivo(null, "Cultivo Intensivo em tanque escavado");
		Cultivo cult2 = new Cultivo(null, "Cultivo Intensivo em redes");
		Cultivo cult3 = new Cultivo(null, "Cultivo Super Intensivo em Tanques artificiais");
		cultivoRepository.saveAll(Arrays.asList(cult1, cult2, cult3));
		
		//INSERT ESPECIES
		
		//INSERT BIOMETRIA
		Biometria bio1 = new Biometria(null, sdf.parse("20/03/1932 14:23"), 30.1,  2.0, "Alguma observacao");
		Biometria bio2 = new Biometria(null, sdf.parse("22/10/1232 04:33"), 0.1,  1.0, "Alguma observacao2");
		Biometria bio3 = new Biometria(null, sdf.parse("01/11/2932 22:13"), 3.1,  1.20, "Alguma observacao3");
		biometriaRepository.saveAll(Arrays.asList(bio1, bio2, bio3));
		
		//INSERT DESPESCAS
		
		//INSERT PH
		Ph ph1 = new Ph(null, "Ácido");
		Ph ph2 = new Ph(null, "Basico");
		Ph ph3 = new Ph(null, "Ácido");
		phRepository.saveAll(Arrays.asList(ph1, ph2, ph3));
	}

}
