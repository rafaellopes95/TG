package edu.fatec.mural.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.fatec.mural.model.Colaborador;

@Repository
@Transactional(readOnly = false)
public class ColaboradorDaoImpl implements ColaboradorDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Colaborador> listColaboradores() {
		List<Colaborador> colaboradores = entityManager.createQuery("SELECT c.codigo, c.nome, "
				+ "c.formacao, c.tipoColab FROM Colaborador c").getResultList();
		
		return colaboradores;
	}

	@Override
	public Colaborador getColaborador(String codigo) {
		Colaborador colaborador = entityManager.find(Colaborador.class, codigo);
		
		return colaborador;
	}

	@Override
	public Colaborador addColaborador(Colaborador colaborador) {
		entityManager.persist(colaborador);
		
		return colaborador;
	}

	@Override
	public Colaborador editColaborador(Colaborador colaborador) {
		entityManager.merge(colaborador);
		
		return colaborador;
	}

	@Override
	public Colaborador delColaborador(Colaborador colaborador) {
		colaborador = entityManager.merge(colaborador);
		entityManager.remove(colaborador);
		
		return colaborador;
	}

}
