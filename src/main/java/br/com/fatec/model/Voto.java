package br.com.fatec.model;

import javax.persistence.*;

@Entity
public class Voto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VOTO_SEQ")
	@SequenceGenerator(sequenceName = "voto_seq", allocationSize = 1, name = "VOTO_SEQ")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "candidato_id")
	private Candidato candidato;

	public Voto() {
	}

	public Voto(Candidato candidato) {
		this.candidato = candidato;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
}
