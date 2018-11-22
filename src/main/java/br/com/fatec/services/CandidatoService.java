package br.com.fatec.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatec.dao.CandidatoRepository;
import br.com.fatec.model.Candidato;

@Service
public class CandidatoService {
	
	@Autowired
	private CandidatoRepository repository;
	
	public Candidato cadastrar(Candidato candidato) {
		return this.repository.save(candidato);
	}
	
	public List<Candidato> findAll() {
		return this.repository.findAll();
	}

	public Optional<Candidato> findById(Long candidatoId) {
		return repository.findById(candidatoId);
	}

	public void delete(Candidato candidato) {
		repository.delete(candidato);
	}
}
