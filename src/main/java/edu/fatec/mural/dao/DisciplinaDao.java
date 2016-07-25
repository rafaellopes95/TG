package edu.fatec.mural.dao;

import java.util.List;

import edu.fatec.mural.model.Disciplina;

public interface DisciplinaDao {
	
	public List<Disciplina> listDisciplinas();
	
	public Disciplina getDisciplina(String codigo);
	
	public Disciplina addDisciplina(Disciplina disciplina);
	
	public Disciplina editDisciplina(Disciplina disciplina);
	
	public Disciplina delDisciplina(Disciplina disciplina);
}
