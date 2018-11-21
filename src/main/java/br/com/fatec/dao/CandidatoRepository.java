package br.com.fatec.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fatec.model.Candidato;

@Repository
public interface CandidatoRepository extends JpaRepository<Candidato, Long> {

}
