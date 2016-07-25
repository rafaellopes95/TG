package edu.fatec.mural.dao;

import java.util.List;

import edu.fatec.mural.model.Aluno;

public interface AlunoDao {

	public List<Aluno> listAlunos();
	
	public Aluno getAluno(String ra);
	
	public Aluno addAluno(Aluno aluno);
	
	public Aluno editAluno(Aluno aluno);
	
	public Aluno delAluno(Aluno aluno);
}
