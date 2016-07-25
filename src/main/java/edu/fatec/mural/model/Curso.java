package edu.fatec.mural.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "curso")
public class Curso {

	@Id
	@Column(length = 20)
	private String sigla;
	
	@Column(length = 50, nullable = false)
	private String nome;
	
	@Column(length = 1, nullable = false)
	private char periodo;
	
	@Column(nullable = false)
	private int numSemestres;

	@OneToMany(mappedBy = "curso")
	@JsonIgnore
	private List<Disciplina> disciplinas;
	
	@OneToMany(mappedBy = "curso")
	@JsonIgnore
	private List<Aluno> alunos;
	
	@ManyToMany(mappedBy = "cursos")
	@JsonIgnore
	private List<Colaborador> professores;
	
	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public char getPeriodo() {
		return periodo;
	}
	
	public void setPeriodo(char periodo) {
		this.periodo = periodo;
	}
	
	public int getNumSemestres() {
		return numSemestres;
	}
	
	public void setNumSemestres(int numSemestres) {
		this.numSemestres = numSemestres;
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}
	
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	public List<Colaborador> getProfessores() {
		return professores;
	}
	
	public void setProfessores(List<Colaborador> professores) {
		this.professores = professores;
	}
	
}
