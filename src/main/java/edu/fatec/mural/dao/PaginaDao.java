package edu.fatec.mural.dao;

import java.util.List;

import edu.fatec.mural.model.Pagina;

public interface PaginaDao {
	
	public List<Pagina> listPaginas();
	
	public Pagina getPagina(int codigo);
	
	public Pagina addPagina(Pagina pagina);
	
	public Pagina editPagina(Pagina pagina);
	
	public Pagina delPagina(Pagina pagina);
}
