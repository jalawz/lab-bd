package br.com.fatec.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.fatec.model.Candidato;
import br.com.fatec.services.CandidatoService;

@Controller
public class CandidatoController {
	
	@Autowired
	private CandidatoService service;
	
	@GetMapping("/cadastrar-candidato")
	public String cadastrarCandidato() {
		return "cadastro/cadastro-candidato";
	}
	
	@PostMapping(value = "/cadastrar-candidato", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public String cadastroCandidato(Candidato candidato) {
		this.service.cadastrar(candidato);
		return "redirect:cadastrar-candidato";
	}
	
	@GetMapping("/listar-candidatos")
	public String listarCandidatos(ModelMap model) {
		List<Candidato> candidatos = this.service.findAll();
		model.put("candidatos", candidatos);
		return "listar-candidatos";
	}
}
