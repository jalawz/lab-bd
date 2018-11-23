package br.com.fatec.controllers;

import br.com.fatec.model.Candidato;
import br.com.fatec.model.Voto;
import br.com.fatec.services.CandidatoService;
import br.com.fatec.services.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class VotoController {

    @Autowired
    private VotoService votoService;

    @Autowired
    private CandidatoService candidatoService;

    @Autowired
    JdbcTemplate jdbcTemplate;


    @GetMapping("/votos")
    public String listarCandidatos(ModelMap model) {
        model.put("candidatos", candidatoService.findAll());
        return "voto/listar-candidatos-voto";
    }

    @PostMapping("/votar/{candidatoId}")
    public String computarVoto(@PathVariable Long candidatoId, ModelMap model) {
        candidatoService.findById(candidatoId).map(candidato -> {
            Voto voto = new Voto();
            voto.setCandidato(candidato);
            candidato.getVotos().add(voto);
            model.put("voto", votoService.saveVoto(voto));
            candidatoService.cadastrar(candidato);
            return voto;
        }).orElse(null);
        return "voto/voto-sucesso";
    }

    @GetMapping("/apuracao")
    public String getApuracao(ModelMap model) {
        Double totalVotos = jdbcTemplate.queryForObject("select count(*) from voto", Double.class);
        List<Candidato> candidatos = candidatoService.findAll();
        model.put("totalVotos", totalVotos);
        model.put("candidatos", candidatos);
        return "voto/apuracao";
    }

}
