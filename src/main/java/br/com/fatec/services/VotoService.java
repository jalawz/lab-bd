package br.com.fatec.services;

import br.com.fatec.dao.VotoRepository;
import br.com.fatec.model.Voto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotoService {

    @Autowired
    private VotoRepository votoRepository;

    public Voto saveVoto(Voto voto) {
        return votoRepository.save(voto);
    }
}
