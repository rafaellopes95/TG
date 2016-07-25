package edu.fatec.mural.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Aluno")
public class Aluno {

	@Id
	private String ra;
	
	@Column(length = 50, nullable = false)
	private String nome;
	
	@Column(length = 1, nullable = false)
	private char sexo;
	
	@Temporal(TemporalType.DATE)
	private Date anoIngresso;
	
	@Column(nullable = false)
	private int semestreCur;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "sigla_curso", foreignKey = @ForeignKey(name = "aluno_curso_fk"))
	private Curso curso;
	
	@ManyToMany
	@JoinTable(name = "aluno_disciplina", joinColumns = {@JoinColumn(name = "ra_aluno", foreignKey = @ForeignKey(name = "aluno_disc_fk"))}, 
										  inverseJoinColumns = {@JoinColumn(name = "cod_disciplina", foreignKey = @ForeignKey(name = "disc_aluno_fk"))} 
	)
	private List<Disciplina> disciplinas;
	
	@OneToMany(mappedBy = "aluno")
	@JsonIgnore //usado p evitar loop infinito durante a serializacao em json pelo Jackson
	private List<Publicacao> publicacoes;

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public char getSexo() {
		return sexo;
	}
	
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public Date getDataIngresso() {
		return anoIngresso;
	}
	
	public void setDataIngresso(Date dataIngresso) {
		this.anoIngresso = dataIngresso;
	}
	
	public int getSemestreCur() {
		return semestreCur;
	}

	public void setSemestreCur(int semestreCur) {
		this.semestreCur = semestreCur;
	}
	
	public Curso getCurso() {
		return curso;
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public List<Publicacao> getPublicacoes() {
		return publicacoes;
	}

	public void setPublicacoes(List<Publicacao> publicacoes) {
		this.publicacoes = publicacoes;
	}
}
