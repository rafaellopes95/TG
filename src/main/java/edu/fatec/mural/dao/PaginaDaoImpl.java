package edu.fatec.mural.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.fatec.mural.model.Pagina;

@Repository
@Transactional(readOnly = false)
public class PaginaDaoImpl implements PaginaDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Pagina> listPaginas() {
		List<Pagina> paginas = entityManager.createQuery("SELECT p.codigo, p.nome, "
				+ "p.descricao, p.disciplina.codigo, p.disciplina.nome FROM Pagina p").getResultList();
		
		return paginas;
	}

	@Override
	public Pagina getPagina(int codigo) {
		Pagina pagina = entityManager.find(Pagina.class, codigo);
		
		return pagina;
	}

	@Override
	public Pagina addPagina(Pagina pagina) {
		entityManager.persist(pagina);
		
		return pagina;
	}

	@Override
	public Pagina editPagina(Pagina pagina) {
		entityManager.merge(pagina);
		
		return pagina;
	}

	@Override
	public Pagina delPagina(Pagina pagina) {
		pagina = entityManager.merge(pagina);
		entityManager.remove(pagina);
		
		return pagina;
	}
}
