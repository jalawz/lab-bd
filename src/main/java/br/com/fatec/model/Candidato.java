package br.com.fatec.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Candidato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAND_SEQ")
	@SequenceGenerator(sequenceName = "candidato_seq", allocationSize = 1, name = "CAND_SEQ")
	private Long id;
	private String nome;
	private String partido;
	private Integer sigla;

	@OneToMany
	private List<Voto> votos = new ArrayList<>();

	public Candidato() {
		super();
	}

	public Candidato(Long id, String nome, String partido, Integer sigla) {
		super();
		this.id = id;
		this.nome = nome;
		this.partido = partido;
		this.sigla = sigla;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

	public Integer getSigla() {
		return sigla;
	}

	public void setSigla(Integer sigla) {
		this.sigla = sigla;
	}

	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}
}
