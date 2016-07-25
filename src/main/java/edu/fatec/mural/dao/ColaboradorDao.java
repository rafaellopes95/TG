package edu.fatec.mural.dao;

import java.util.List;

import edu.fatec.mural.model.Colaborador;

public interface ColaboradorDao {
	
	public List<Colaborador> listColaboradores();
	
	public Colaborador getColaborador(String codigo);
	
	public Colaborador addColaborador(Colaborador colaborador);
	
	public Colaborador editColaborador(Colaborador colaborador);
	
	public Colaborador delColaborador(Colaborador colaborador);
}
