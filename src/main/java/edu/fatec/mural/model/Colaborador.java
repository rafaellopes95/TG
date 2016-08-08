package edu.fatec.mural.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "colaborador")
public class Colaborador {

	@Id
	@Column(length = 10)
	private String codigo;
	
	@Column(length = 50, nullable = false)
	private String nome;
	
	@Column(length = 50, nullable = false)
	private String formacao;
	
	@Column(length = 1, nullable = false)
	private char tipoColab;
	
	@OneToMany(mappedBy = "professor")
	@JsonIgnore
	private List<Disciplina> disciplinas;
	
	@ManyToMany
	@JoinTable(name = "professor_curso", joinColumns = {@JoinColumn(name = "cod_prof", foreignKey = @ForeignKey(name = "prof_curso_fk"))}, 
										 inverseJoinColumns = {@JoinColumn(name = "sigla_curso", foreignKey = @ForeignKey(name = "curso_prof_fk"))} 
	)
	private List<Curso> cursos;
	
	@OneToMany(mappedBy = "colaborador")
	@JsonIgnore
	private List<Publicacao> publicacoes;
	
	@OneToOne(mappedBy = "colaborador")
	@JsonIgnore
	private Usuario usuario;
	
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
	
	public String getFormacao() {
		return formacao;
	}
	
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	
	public char getTipoColab() {
		return tipoColab;
	}
	
	public void setTipoColab(char tipoColab) {
		this.tipoColab = tipoColab;
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public List<Curso> getCursos() {
		return cursos;
	}
	
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	public List<Publicacao> getPublicacoes() {
		return publicacoes;
	}
	
	public void setPublicacoes(List<Publicacao> publicacoes) {
		this.publicacoes = publicacoes;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
