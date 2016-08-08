package edu.fatec.mural.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.fatec.mural.model.Disciplina;

@Repository
@Transactional(readOnly = false)
public class DisciplinaDaoImpl implements DisciplinaDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Disciplina> listDisciplinas() {
		List<Disciplina> disciplinas = entityManager.createQuery("SELECT d FROM Disciplina d "
				+ "LEFT JOIN d.professor "
				+ "LEFT JOIN d.curso "
				+ "LEFT JOIN d.pagina "
				+ "LEFT JOIN d.alunos").getResultList();
		
		return disciplinas;
	}

	@Override
	public Disciplina getDisciplina(String codigo) {
		Disciplina disciplina = entityManager.find(Disciplina.class, codigo);
		
		return disciplina;
	}

	@Override
	public Disciplina addDisciplina(Disciplina disciplina) {
		entityManager.persist(disciplina);
		
		return disciplina;
	}

	@Override
	public Disciplina editDisciplina(Disciplina disciplina) {
		entityManager.merge(disciplina);
		
		return disciplina;
	}

	@Override
	public Disciplina delDisciplina(Disciplina disciplina) {
		disciplina = entityManager.merge(disciplina);
		entityManager.remove(disciplina);
		
		return disciplina;
	}

}
