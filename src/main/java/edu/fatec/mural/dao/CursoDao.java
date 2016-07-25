package edu.fatec.mural.dao;

import java.util.List;

import edu.fatec.mural.model.Curso;

public interface CursoDao {

	public List<Curso> listCursos();
	
	public Curso getCurso(String sigla);
	
	public Curso addCurso(Curso curso);
	
	public Curso editCurso(Curso curso);
	
	public Curso delCurso(Curso curso);
}
