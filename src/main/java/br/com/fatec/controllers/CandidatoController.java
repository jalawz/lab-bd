package br.com.fatec.controllers;

import br.com.fatec.model.Candidato;
import br.com.fatec.services.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
		return "redirect:/candidatos";
	}
	
	@GetMapping("/candidatos")
	public ModelAndView listarCandidatos() {
		ModelAndView modelAndView = new ModelAndView("listar-candidatos");
		List<Candidato> candidatos = this.service.findAll();
		modelAndView.addObject("candidatos", candidatos);
		return modelAndView;
	}

	@GetMapping("/candidatos/{candidatoId}")
	public String buscarCandidato(@PathVariable Long candidatoId, ModelMap model) {
		service.findById(candidatoId).map(candidato -> {
			model.put("candidato", candidato);
			return model;
		}).orElse(null);
		return "cadastro/editar-candidato";
	}

	@PostMapping("/candidatos/{candidatoId}")
	public String editarCandidato(@PathVariable Long candidatoId, Candidato candidatoReq) {
		service.findById(candidatoId).map(candidato -> {
			candidato.setNome(candidatoReq.getNome());
			candidato.setPartido(candidatoReq.getPartido());
			candidato.setSigla(candidatoReq.getSigla());
			return service.cadastrar(candidato);
		}).orElse(null);
		return "redirect:/candidatos";
	}

	@PostMapping("/candidatos/{candidatoId}/excluir")
	public String removerCandidato(@PathVariable Long candidatoId) {
		service.findById(candidatoId).map(candidato -> {
			service.delete(candidato);
			return candidato;
		}).orElse(null);
		return "redirect:/candidatos";
	}
}
