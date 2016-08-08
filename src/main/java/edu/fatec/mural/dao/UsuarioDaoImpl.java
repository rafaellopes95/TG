package edu.fatec.mural.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.fatec.mural.model.Usuario;

@Repository
@Transactional(readOnly = false)
public class UsuarioDaoImpl implements UsuarioDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Usuario> listUsuarios() {
		List<Usuario> usuarios = entityManager.createQuery("SELECT u FROM Usuario u "
														 + "LEFT JOIN u.aluno "
														 + "LEFT JOIN u.colaborador").getResultList();

		return usuarios;
	}

	@Override
	public Usuario getUsuario(String username, String password) {
		Usuario usuario = (Usuario) entityManager.createQuery("SELECT u "
												  + "FROM Usuario u "
												  + "LEFT JOIN u.aluno "
												  + "LEFT JOIN u.colaborador "
												  + "WHERE u.username=:username "
												  + "AND u.password=:password")
												.setParameter("username", username)
												.setParameter("password", password)
												.getSingleResult();
				
		return usuario;
	}

	@Override
	public Usuario addUsuario(Usuario usuario) {
		entityManager.persist(usuario);
		
		return usuario;
	}

	@Override
	public Usuario editUsuario(Usuario usuario) {
		entityManager.merge(usuario);
		
		return usuario;
	}

	@Override
	public Usuario delUsuario(Usuario usuario) {
		usuario = entityManager.merge(usuario);
		entityManager.remove(usuario);
		
		return usuario;
	}
}
