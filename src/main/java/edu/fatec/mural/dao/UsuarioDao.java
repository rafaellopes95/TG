package edu.fatec.mural.dao;

import java.util.List;

import edu.fatec.mural.model.Usuario;

public interface UsuarioDao {

	public List<Usuario> listUsuarios();
	
	public Usuario getUsuario(String username, String password);
	
	public Usuario addUsuario(Usuario usuario);
	
	public Usuario editUsuario(Usuario usuario);
	
	public Usuario delUsuario(Usuario usuario);
}
