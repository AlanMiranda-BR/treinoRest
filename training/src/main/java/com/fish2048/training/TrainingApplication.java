package com.fish2048.training;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fish2048.training.domain.Alimentacao;
import com.fish2048.training.domain.Autorias;
import com.fish2048.training.domain.Biometria;
import com.fish2048.training.domain.Cultivo;
import com.fish2048.training.domain.CustoRacao;
import com.fish2048.training.domain.Despesca;
import com.fish2048.training.domain.EspeciePeixe;
import com.fish2048.training.domain.IndiceZootecnico;
import com.fish2048.training.domain.LotePeixe;
import com.fish2048.training.domain.Manejo;
import com.fish2048.training.domain.ManejoPK;
import com.fish2048.training.domain.Parametro;
import com.fish2048.training.domain.Pesquisa;
import com.fish2048.training.domain.Pesquisador;
import com.fish2048.training.domain.Ph;
import com.fish2048.training.domain.Piscicultor;
import com.fish2048.training.domain.Povoamento;
import com.fish2048.training.domain.Propriedade;
import com.fish2048.training.domain.Publicacao;
import com.fish2048.training.domain.Racao;
import com.fish2048.training.domain.TaxaArracoamento;
import com.fish2048.training.domain.TipoViveiro;
import com.fish2048.training.domain.Viveiro;
import com.fish2048.training.repositories.AlimentacaoRepository;
import com.fish2048.training.repositories.AutoriasRepository;
import com.fish2048.training.repositories.BiometriaRepository;
import com.fish2048.training.repositories.CultivoRepository;
import com.fish2048.training.repositories.CustoRacaoRepository;
import com.fish2048.training.repositories.DespescaRepository;
import com.fish2048.training.repositories.EspeciePeixeRepository;
import com.fish2048.training.repositories.IndiceZootecnicoRepository;
import com.fish2048.training.repositories.LotePeixeRepository;
import com.fish2048.training.repositories.ManejoRepository;
import com.fish2048.training.repositories.ParametroRepository;
import com.fish2048.training.repositories.PesquisaRepository;
import com.fish2048.training.repositories.PesquisadorRepository;
import com.fish2048.training.repositories.PhRepository;
import com.fish2048.training.repositories.PiscicultorRepository;
import com.fish2048.training.repositories.PovoamentoRepository;
import com.fish2048.training.repositories.PropriedadeRepository;
import com.fish2048.training.repositories.PublicacaoRepository;
import com.fish2048.training.repositories.RacaoRepository;
import com.fish2048.training.repositories.TaxaArracoamentoRepository;
import com.fish2048.training.repositories.TipoViveiroRepository;
import com.fish2048.training.repositories.ViveiroRepository;

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
	private AlimentacaoRepository alimentacaoRepository;
	@Autowired
	private AutoriasRepository autoriasRepository;
	@Autowired
	private BiometriaRepository biometriaRepository;
	@Autowired
	private CultivoRepository cultivoRepository;
	@Autowired
	private CustoRacaoRepository custoRacaoRepository;
	@Autowired
	private DespescaRepository despescaRepository;
	@Autowired
	private EspeciePeixeRepository especiePeixeRepository;
	@Autowired
	private IndiceZootecnicoRepository indiceZootecnicoRepository;
	@Autowired
	private LotePeixeRepository lotePeixeRepository;
	@Autowired
	private ManejoRepository manejoRepository;
	@Autowired
	private ParametroRepository parametroRepository;
	@Autowired
	private PesquisaRepository pesquisaRepository;
	@Autowired
	private PesquisadorRepository pesquisadorRepository;
	@Autowired
	private PhRepository phRepository;
	@Autowired
	private PiscicultorRepository piscicultorRepository;
	@Autowired
	private PovoamentoRepository povoamentoRepository;
	@Autowired
	private PropriedadeRepository propriedadeRepository;
	@Autowired
	private PublicacaoRepository publicacaoRepository;
	@Autowired
	private RacaoRepository racaoRepository;
	@Autowired
	private TipoViveiroRepository tipoViveiroRepository;
	@Autowired
	private ViveiroRepository viveiroRepository;
	@Autowired
	private TaxaArracoamentoRepository taxaArracoamentoRepository;
	
	
	// Apenas este método deve permancer na versão final
	public static void main(String[] args) {
		SpringApplication.run(TrainingApplication.class, args);
	}

	// Criação dos registros das tabelas do Banco de Dados (Somente para testes)
	public void run(String... args) throws Exception {
		//Usar o padrão sdf.parse("20/03/1932 14:23")  para preencher campos de data/hora
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		//PESQUISADORES
		Pesquisador pesd1 = new Pesquisador(null, "João", 156464, "plantar mandioca", 9594661, "joao@email.com", "roça");
		Pesquisador pesd2 = new Pesquisador(null, "Maria", 156464, "algas marinhas", 6564671, "maria@email.com", "mar");
		Pesquisador pesd3 = new Pesquisador(null, "Jenifer", 156464, "virar o zoinho", 9594661, "jenifer@email.com", "terreiro");
		pesquisadorRepository.saveAll(Arrays.asList(pesd1, pesd2, pesd3));
		
		//PESQUISAS
		Pesquisa pesq1 = new Pesquisa(null, sdf.parse("01/04/2018 13:40"), sdf.parse("04/04/2018 13:40"));
		Pesquisa pesq2 = new Pesquisa(null, sdf.parse("02/04/2018 13:40"), sdf.parse("05/04/2018 13:40"));
		Pesquisa pesq3 = new Pesquisa(null, sdf.parse("03/04/2018 13:40"), sdf.parse("06/04/2018 13:40"));
		pesquisaRepository.saveAll(Arrays.asList(pesq1, pesq2, pesq3));
		
		//AUTORIAS
		Autorias aut1 = new Autorias(null, 6549846);
		Autorias aut2 = new Autorias(null, 7651665);
		Autorias aut3 = new Autorias(null, 8641134);
		aut1.setPesquisa(pesq1);
		aut2.setPesquisa(pesq2);
		aut3.setPesquisa(pesq3);
		aut1.setPesquisador(pesd1);
		aut2.setPesquisador(pesd2);
		aut3.setPesquisador(pesd3);
		autoriasRepository.saveAll(Arrays.asList(aut1, aut2, aut3));
		
		//BIOMETRIAS
		Biometria bio1 = new Biometria(null, sdf.parse("20/03/1932 14:23"), 30.1,  2.0, "Alguma observacao");
		Biometria bio2 = new Biometria(null, sdf.parse("22/10/1232 04:33"), 0.1,  1.0, "Alguma observacao2");
		Biometria bio3 = new Biometria(null, sdf.parse("01/11/2932 22:13"), 3.1,  1.20, "Alguma observacao3");
		
		//CULTIVOS
		Cultivo cult1 = new Cultivo(null, "Cultivo Intensivo em tanque escavado");
		Cultivo cult2 = new Cultivo(null, "Cultivo Intensivo em redes");
		Cultivo cult3 = new Cultivo(null, "Cultivo Super Intensivo em Tanques artificiais");
		
		//ESPECIES PEIXES
		EspeciePeixe esp1 = new EspeciePeixe(null, "autralopitecus", "Baiacu");
		EspeciePeixe esp2 = new EspeciePeixe(null, "gnomalukus", "Lambari");
		EspeciePeixe esp3 = new EspeciePeixe(null, "pegaynomeuls", "Jundiá");
		especiePeixeRepository.saveAll(Arrays.asList(esp1, esp2, esp3));
				
		//LOTES PEIXES
		LotePeixe lot1 = new LotePeixe(null, sdf.parse("01/04/2018 13:40"), 12, 123.4, 45);
		LotePeixe lot2 = new LotePeixe(null, sdf.parse("02/05/2018 13:40"), 14, 254.5, 51);
		LotePeixe lot3 = new LotePeixe(null, sdf.parse("03/06/2018 13:40"), 65, 46.45, 135);
		lot1.setEspeciePeixe(esp1);
		lot2.setEspeciePeixe(esp2);
		lot3.setEspeciePeixe(esp3);
		
		//PHs
		Ph ph1 = new Ph(null, "Ácido");
		Ph ph2 = new Ph(null, "Basico");
		Ph ph3 = new Ph(null, "Neutro");
		phRepository.saveAll(Arrays.asList(ph1, ph2, ph3));
		
		//ALIMENTACOES
		Alimentacao ali1 = new Alimentacao(null, sdf.parse("01/04/2018 13:40"), 155.00, 10.50, 12.50, 130.40, 4, "nada a Declarar1");
		Alimentacao ali2 = new Alimentacao(null, sdf.parse("10/05/2018 14:30"), 250.00, 25.50, 24.50, 250.00, 4, "Nada a declarar2");
		Alimentacao ali3 = new Alimentacao(null, sdf.parse("20/06/2018 15:30"), 350.00, 35.50, 34.50, 350.00, 4, "Nada a declarar3");
		ali1.setPh(ph1);
		ali2.setPh(ph2);
		ali3.setPh(ph3);
				
		//TIPOS DE VIVEIROS
		TipoViveiro tipoViveiro1 = new TipoViveiro(null, "Tanque Escavado");
		TipoViveiro tipoViveiro2 = new TipoViveiro(null, "Rede");
		TipoViveiro tipoViveiro3 = new TipoViveiro(null, "Pinico");
		tipoViveiroRepository.saveAll(Arrays.asList(tipoViveiro1, tipoViveiro2, tipoViveiro3));
				
		//VIVEIROS
		Viveiro viveiro1 = new Viveiro(null, 45.4f, sdf.parse("12/04/2018 14:40"));
		Viveiro viveiro2 = new Viveiro(null, 106.00f, sdf.parse("22/04/2018 14:40"));
		Viveiro viveiro3 = new Viveiro(null, 206.00f, sdf.parse("02/04/2018 14:40"));
		viveiro1.setTipoViveiro(tipoViveiro1);
		viveiro2.setTipoViveiro(tipoViveiro2);
		viveiro3.setTipoViveiro(tipoViveiro3);
		
		//DESPESCAS
		Despesca desp1 = new Despesca(null, 200, sdf.parse("01/04/2018 13:40"));
		Despesca desp2 = new Despesca(null, 300, sdf.parse("10/05/2018 14:30"));
		Despesca desp3 = new Despesca(null, 400, sdf.parse("20/06/2018 15:30"));
		
		//PISCICULTORES
		Piscicultor pisc1 = new Piscicultor(null, "Zé", "Bagre", "6516515", "ze@dobagre.com");
		Piscicultor pisc2 = new Piscicultor(null, "Tonho", "Tilapia", "5416515", "tonho@datilapia.com");
		Piscicultor pisc3 = new Piscicultor(null, "Xico", "Tucunaré", "9516515", "xico@dotucuna.com");
		
		//PROPRIEDADES
		Propriedade prop1 = new Propriedade(null, 2, 3, "emailprop1@teste.com", 47991109, 88334091,"Bairro Propriedade 1","Cidade da Propriedade 1",01,"Endereço Propriedade 1 rua","Nome Primeira Propriedade","Nome do Proprietario UM","Observacoes 1");
		Propriedade prop2 = new Propriedade(null, 2, 3, "emailprop2@teste.com", 5533325, 9944091,"Bairro Propriedade 2","Cidade da Propriedade 2",01,"Endereço Propriedade 2 rua","Nome SEGUNDA Propriedade","Nome do Proprietario DOIS","Observacoes 2");
		Propriedade prop3 = new Propriedade(null, 2, 3, "emailprop3@teste.com", 88222365, 333331,"Bairro Propriedade 3","Cidade da Propriedade 3",01,"Endereço Propriedade 3 rua","Nome tereira Propriedade","Nome do Proprietario TRES", "OBS3");
		prop1.getPiscicultores().add(pisc1);
		prop2.getPiscicultores().add(pisc2);
		prop3.getPiscicultores().add(pisc3);
		pisc1.getPropriedades().add(prop1);
		pisc2.getPropriedades().add(prop2);
		pisc3.getPropriedades().add(prop3);
		viveiro1.setPropriedade(prop1);
		viveiro2.setPropriedade(prop2);
		viveiro3.setPropriedade(prop3);
			
		propriedadeRepository.saveAll(Arrays.asList(prop1, prop2, prop3));
		piscicultorRepository.saveAll(Arrays.asList(pisc1, pisc2, pisc3));
				
		//POVOAMENTOS
		Povoamento pov1 = new Povoamento(null, 5000, sdf.parse("12/04/2018 14:40"));
		Povoamento pov2 = new Povoamento(null, 20000, sdf.parse("22/10/2018 04:50"));
		Povoamento pov3 = new Povoamento(null, 9000, sdf.parse("20/01/2019 16:00"));
		
		desp1.setPovoamento(pov1);
		desp2.setPovoamento(pov2);
		desp3.setPovoamento(pov3);
		
		pov1.getLotesPeixes().add(lot1);
		pov2.getLotesPeixes().add(lot2);
		pov3.getLotesPeixes().add(lot3);
		
		lot1.getPovoamentos().add(pov1);
		lot2.getPovoamentos().add(pov2);
		lot3.getPovoamentos().add(pov3);
				
		pov1.setCultivo(cult1);
		pov2.setCultivo(cult2);
		pov3.setCultivo(cult3);
		
		cult1.getPovoamentos().add(pov1);
		cult2.getPovoamentos().add(pov2);
		cult3.getPovoamentos().add(pov3);
		
		pov1.setViveiro(viveiro1);
		pov2.setViveiro(viveiro2);
		pov3.setViveiro(viveiro3);
		
		viveiro1.getPovoamentos().add(pov1);
		viveiro2.getPovoamentos().add(pov2);
		viveiro3.getPovoamentos().add(pov3);
		
		bio1.setPovoamento(pov1);
		bio2.setPovoamento(pov2);
		bio3.setPovoamento(pov3);
		
		pov1.getBiometrias().add(bio1);
		pov2.getBiometrias().add(bio2);
		pov3.getBiometrias().add(bio3);
		
		ali1.setPovoamento(pov1);
		ali2.setPovoamento(pov2);
		ali3.setPovoamento(pov3);
		
		pov1.getAlimentacoes().add(ali1);
		pov2.getAlimentacoes().add(ali2);
		pov3.getAlimentacoes().add(ali3);
		
		pov1.setPesquisa(pesq1);
		pov2.setPesquisa(pesq2);
		pov3.setPesquisa(pesq3);
		
		pov1.setPiscicultor(pisc1);
		pov2.setPiscicultor(pisc2);
		pov3.setPiscicultor(pisc3);
		
				
		cultivoRepository.saveAll(Arrays.asList(cult1, cult2, cult3));
		lotePeixeRepository.saveAll(Arrays.asList(lot1, lot2, lot3));
		viveiroRepository.saveAll(Arrays.asList(viveiro1, viveiro2, viveiro3));
		despescaRepository.saveAll(Arrays.asList(desp1, desp2, desp3));
		biometriaRepository.saveAll(Arrays.asList(bio1, bio2, bio3));
		alimentacaoRepository.saveAll(Arrays.asList(ali1, ali2, ali3));
		povoamentoRepository.saveAll(Arrays.asList(pov1, pov2, pov3));
		
		//PARAMETROS
		Parametro param1 = new Parametro(null, sdf.parse("01/04/2018 13:40"), 45.5, 23.4, "ácido","molinho" , "choque", "salobra", "média", "Sem nem oque é isso 1");
		Parametro param2 = new Parametro(null, sdf.parse("02/05/2018 13:20"), 125.2, 20.4, "Alcalino", "mole", "choque", "doce", "muita",  "Sem nem oque é isso 2");
		Parametro param3 = new Parametro(null, sdf.parse("02/05/2018 13:20"), 125.2, -20.4, "basico", "dura", "freeze", "salgada", "pouca",  "Sem nem oque é isso 3");
		param1.setPovoamento(pov1);
		param2.setPovoamento(pov1);
		param3.setPovoamento(pov3);
		param1.setPh(ph1);
		param2.setPh(ph2);
		param3.setPh(ph3);
		parametroRepository.saveAll(Arrays.asList(param1, param2, param3));

		//INDICES ZOOTECNICOS
		IndiceZootecnico ind1 = new IndiceZootecnico(null, sdf.parse("01/04/2018 13:40"), 153.4F, 564.5F, 135.4F, 120.4F, 135.6F, 135.5F, "Sei lá 1");
		IndiceZootecnico ind2 = new IndiceZootecnico(null, sdf.parse("02/05/2018 13:40"), 253.4F, 664.5F, 235.4F, 220.4F, 235.6F, 235.5F, "Sei lá 2");
		IndiceZootecnico ind3 = new IndiceZootecnico(null, sdf.parse("03/06/2018 13:40"), 353.4F, 764.5F, 335.4F, 320.4F, 335.6F, 335.5F, "Sei lá 3");
		ind1.setPovoamento(pov1);
		ind2.setPovoamento(pov1);
		ind3.setPovoamento(pov3);
		indiceZootecnicoRepository.saveAll(Arrays.asList(ind1, ind2, ind3));
		
		//MANEJOS
		Optional<Povoamento> pov = povoamentoRepository.findById(1);
		Manejo mane1 = new Manejo(new ManejoPK(pov.orElseThrow(null),sdf.parse("12/04/2018 14:40")), "Manutenção em Alimentadores", "Periodico");
		manejoRepository.saveAll(Arrays.asList(mane1));
		
		//TAXA ARRAÇOAMENTOS
		TaxaArracoamento taxaArracoamento1 = new TaxaArracoamento(null, sdf.parse("12/04/2018 14:40"), 456.5f, 25.0f, 70, "Nada a declarar 1");
		TaxaArracoamento taxaArracoamento2 = new TaxaArracoamento(null, sdf.parse("12/04/2018 14:40"), 456.5f, 25.0f, 70, "Nada a declarar 2");
		TaxaArracoamento taxaArracoamento3 = new TaxaArracoamento(null, sdf.parse("12/04/2018 14:40"), 456.5f, 25.0f, 70, "Nada a declarar 3");
		taxaArracoamento1.setPovoamento(pov1);
		taxaArracoamento2.setPovoamento(pov2);
		taxaArracoamento3.setPovoamento(pov3);
		taxaArracoamentoRepository.saveAll(Arrays.asList(taxaArracoamento1, taxaArracoamento2, taxaArracoamento3));
	
		//PUBLICACOES
		Publicacao publ1 = new Publicacao(null, "Artigo", sdf.parse("12/04/2018 14:40"), "Camboriu", "IFC", "nada");
		Publicacao publ2 = new Publicacao(null, "Documento", sdf.parse("22/04/2018 14:40"), "Bal. Camboriú", "Tia Maria", "Social");
		Publicacao publ3 = new Publicacao(null, "Tese", sdf.parse("02/04/2018 14:40"), "Itajai", "IFSC", "nada");
		publ1.setPesquisa(pesq1);
		publ2.setPesquisa(pesq2);
		publ3.setPesquisa(pesq3);
		publicacaoRepository.saveAll(Arrays.asList(publ1, publ2, publ3));
		
			
		//RACOES
		Racao rac1 = new Racao(null, "Farinha", 651, "Mofada");
		Racao rac2 = new Racao(null, "Biscoitos", 651, "Pedigree");
		Racao rac3 = new Racao(null, "Massinha", 651, "Não provei");
		racaoRepository.saveAll(Arrays.asList(rac1, rac2, rac3));
		
		//CUSTOS RACOES
		CustoRacao cus1 = new CustoRacao(null, sdf.parse("01/04/2018 13:40"), 2, 1500.00, "nada a declarar1");
		CustoRacao cus2 = new CustoRacao(null, sdf.parse("10/05/2018 14:30"), 2, 1500.00, "nada a declarar2");
		CustoRacao cus3 = new CustoRacao(null, sdf.parse("20/06/2018 15:30"), 2, 1500.00, "nada a declarar3");
		cus1.setRacao(rac1);
		cus2.setRacao(rac2);
		cus3.setRacao(rac3);
		custoRacaoRepository.saveAll(Arrays.asList(cus1, cus2, cus3));
		
		
	}

}
