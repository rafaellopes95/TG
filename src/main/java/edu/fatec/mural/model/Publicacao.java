package edu.fatec.mural.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "publicacao")
public class Publicacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	
	@Column(length = 50, nullable = false)
	private String autor;
	
	@Column(length = 1, nullable = false)
	private char tipoAutor;
	
	@Column(length = 500)
	private String texto;
	
	@Column(length = 100)
	private String imagem;
	
	@Column(length = 100)
	private String arquivo;
	
	@ManyToOne
	@JoinColumn(name = "cod_colaborador", foreignKey = @ForeignKey(name = "public_colab_fk"))
	private Colaborador colaborador;
	
	@ManyToOne
	@JoinColumn(name = "cod_aluno", foreignKey = @ForeignKey(name = "public_aluno_fk"))
	private Aluno aluno;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "cod_pagina", foreignKey = @ForeignKey(name = "public_pag_fk"))
	private Pagina pagina;
	
	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public char getTipoAutor() {
		return tipoAutor;
	}
	
	public void setTipoAutor(char tipoAutor) {
		this.tipoAutor = tipoAutor;
	}
	
	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public String getImagem() {
		return imagem;
	}
	
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	public String getArquivo() {
		return arquivo;
	}
	
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	
	public Colaborador getColaborador() {
		return colaborador;
	}
	
	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public Pagina getPagina() {
		return pagina;
	}
	
	public void setPagina(Pagina pagina) {
		this.pagina = pagina;
	}
	
}
