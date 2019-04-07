package com.fish2048.training.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Alan Felipe Miranda.
 * 
 *         Classe responsavel por relacionar todas as demais. Qualquer
 *         informação relevante a classe deve ser estar aqui. Informações
 *         específicas dos métodos devem estar em JavaDocs logo acima do método
 *         a que se refere. A organização das classes deve ser padronizada
 *         separando por seção, identificadas com "//nome da seção"
 */
@Entity
public class Povoamento implements Serializable {
	private static final long serialVersionUID = 1L;

	// Atributos
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer qtdPeixePovoamento;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataPovoamento;

	// Relacionamentos
	@ManyToOne
	@JoinColumn(name = "cultivo_id")
	private Cultivo cultivo;

	@ManyToMany(cascade = CascadeType.REMOVE)
	@JoinTable(name = "povoamento_lotepeixe")
	private List<LotePeixe> lotesPeixes = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "viveiro_id")
	private Viveiro viveiro;

	@OneToMany(mappedBy = "id.povoamento")
	@JsonIgnore
	private List<Manejo> manejos = new ArrayList<>();

	@OneToMany(mappedBy = "povoamento")
	@JsonIgnore
	private List<Biometria> biometrias = new ArrayList<>();

	@OneToMany(mappedBy = "povoamento")
	@JsonIgnore
	private List<Alimentacao> alimentacoes = new ArrayList<>();

	@OneToMany(mappedBy = "povoamento")
	@JsonIgnore
	private List<IndiceZootecnico> indicesZootecnicos;
	
	@OneToMany(mappedBy = "povoamento")
	@JsonIgnore
	private List<Parametro> parametros = new ArrayList<>();
	
	@ManyToOne
	private Pesquisa pesquisa;
	
	@ManyToOne
	private Piscicultor piscicultor;
	
	@OneToMany(mappedBy = "povoamento")
	@JsonIgnore
	private List<TaxaArracoamento> taxaArracoamentos;
	
	// Construtores
	public Povoamento() {
	}

	public Povoamento(Integer id, Integer qtdPeixePovoamento, Date dataPovoamento) {
		super();
		this.id = id;
		this.qtdPeixePovoamento = qtdPeixePovoamento;
		this.dataPovoamento = dataPovoamento;
	}

	// Getters e Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQtdPeixePovoamento() {
		return qtdPeixePovoamento;
	}

	public void setQtdPeixePovoamento(Integer qtdPeixePovoamento) {
		this.qtdPeixePovoamento = qtdPeixePovoamento;
	}

	public Date getDataPovoamento() {
		return dataPovoamento;
	}

	public void setDataPovoamento(Date dataPovoamento) {
		this.dataPovoamento = dataPovoamento;
	}

	public Cultivo getCultivo() {
		return cultivo;
	}

	public void setCultivo(Cultivo cultivo) {
		this.cultivo = cultivo;
	}

	public List<LotePeixe> getLotesPeixes() {
		return lotesPeixes;
	}

	public void setLotesPeixes(List<LotePeixe> lotesPeixes) {
		this.lotesPeixes = lotesPeixes;
	}

	public Viveiro getViveiro() {
		return viveiro;
	}

	public void setViveiro(Viveiro viveiro) {
		this.viveiro = viveiro;
	}

	public List<Manejo> getManejos() {
		return manejos;
	}

	public void setManejos(List<Manejo> manejos) {
		this.manejos = manejos;
	}

	public List<Biometria> getBiometrias() {
		return biometrias;
	}

	public void setBiometrias(List<Biometria> biometrias) {
		this.biometrias = biometrias;
	}

	public List<Alimentacao> getAlimentacoes() {
		return alimentacoes;
	}

	public void setAlimentacoes(List<Alimentacao> alimentacoes) {
		this.alimentacoes = alimentacoes;
	}

	public List<IndiceZootecnico> getIndicesZootecnicos() {
		return indicesZootecnicos;
	}

	public void setIndicesZootecnicos(List<IndiceZootecnico> indicesZootecnicos) {
		this.indicesZootecnicos = indicesZootecnicos;
	}

	public List<Parametro> getParametros() {
		return parametros;
	}

	public void setParametros(List<Parametro> parametros) {
		this.parametros = parametros;
	}

	public Pesquisa getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(Pesquisa pesquisa) {
		this.pesquisa = pesquisa;
	}

	public Piscicultor getPiscicultor() {
		return piscicultor;
	}

	public void setPiscicultor(Piscicultor piscicultor) {
		this.piscicultor = piscicultor;
	}

	// HashCode e equals
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
		Povoamento other = (Povoamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
