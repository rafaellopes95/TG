package edu.fatec.mural.dao;

import java.util.List;

import edu.fatec.mural.model.Publicacao;

public interface PublicacaoDao {
	
	public List<Publicacao> listPublicacoes();
	
	public Publicacao getPublicacao(int codigo);
	
	public Publicacao addPublicacao(Publicacao publicacao);
	
	public Publicacao editPublicacao(Publicacao publicacao);
	
	public Publicacao delPublicacao(Publicacao publicacao);
}
