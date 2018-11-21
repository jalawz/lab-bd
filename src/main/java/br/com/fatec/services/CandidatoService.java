package br.com.fatec.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.dao.CandidatoRepository;
import br.com.fatec.model.Candidato;

@Service
public class CandidatoService {
	
	@Autowired
	private CandidatoRepository repository;
	
	public void cadastrar(Candidato candidato) {
		this.repository.save(candidato);
	}
	
	public List<Candidato> findAll() {
		return this.repository.findAll();
	}
}
