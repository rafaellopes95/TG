package edu.fatec.mural.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	private String username;
	
	@Column(length = 30, nullable = false)
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Role privilegio;
	
	@OneToOne
	@JoinColumn(name = "usuario_aluno", foreignKey = @ForeignKey(name = "usuario_aluno_fk"))
	private Aluno aluno;
	
	@OneToOne
	@JoinColumn(name = "usuario_colab", foreignKey = @ForeignKey(name = "usuario_colab_fk"))
	private Colaborador colaborador;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getPrivilegio() {
		return privilegio;
	}

	public void setPrivilegio(Role privilegio) {
		this.privilegio = privilegio;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}
}
