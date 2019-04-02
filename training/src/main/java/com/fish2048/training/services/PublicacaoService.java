package com.fish2048.training.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fish2048.training.domain.Publicacao;
import com.fish2048.training.repositories.PublicacaoRepository;

@Service
public class PublicacaoService {
	@Autowired
	private PublicacaoRepository publicacaoRepository;
	
	//FIND BY ID
	public Publicacao find(Integer id) {
		Optional<Publicacao> obj = publicacaoRepository.findById(id);
		return obj.orElse(null);	
	}
		//INSERT
	public Publicacao insert (Publicacao obj) {
		obj.setId(null);
		return publicacaoRepository.save(obj);
	}
}

