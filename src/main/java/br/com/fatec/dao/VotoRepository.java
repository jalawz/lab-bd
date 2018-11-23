package br.com.fatec.dao;

import br.com.fatec.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {

    List<Voto> findAllByCandidatoId(Long candidatoId);
}
