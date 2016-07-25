package edu.fatec.mural.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "disciplina")
public class Disciplina {

	@Id
	@Column(length = 10, nullable = false)
	private String codigo;
	
	@Column(length = 50, nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private int semestreOfer;
	
	@ManyToOne
	@JoinColumn(name = "cod_professor", foreignKey = @ForeignKey(name = "disc_prof_fk"))
	private Colaborador professor;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "sigla_curso", foreignKey = @ForeignKey(name = "disc_curso_fk"))
	private Curso curso;
	
	@ManyToMany(mappedBy = "disciplinas")
	@JsonIgnore
	private List<Aluno> alunos;
	
	@OneToOne(mappedBy = "disciplina")
	@JsonIgnore
	private Pagina pagina;
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getSemestreOfer() {
		return semestreOfer;
	}
	
	public void setSemestreOfer(int semestreOfer) {
		this.semestreOfer = semestreOfer;
	}
	
	public Colaborador getProfessor() {
		return professor;
	}
	
	public void setProfessor(Colaborador professor) {
		this.professor = professor;
	}
	
	public Curso getCurso() {
		return curso;
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}
	
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Pagina getPagina() {
		return pagina;
	}

	public void setPagina(Pagina pagina) {
		this.pagina = pagina;
	}

}
