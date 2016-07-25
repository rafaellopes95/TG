package edu.fatec.mural.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.fatec.mural.model.Aluno;

@Repository
@Transactional(readOnly = false)
public class AlunoDaoImpl implements AlunoDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Aluno> listAlunos() {
		List<Aluno> alunos = entityManager.createQuery("SELECT a.ra, a.nome, a.sexo, "
				+ "a.anoIngresso, a.semestreCur, a.curso.sigla, a.curso.nome FROM Aluno a").getResultList();
			
		return alunos;
	}

	@Override
	public Aluno getAluno(String ra) {
		Aluno aluno = entityManager.find(Aluno.class, ra);
		
		return aluno;
	}

	@Override
	public Aluno addAluno(Aluno aluno) {
		entityManager.persist(aluno);
		
		return aluno;
	}

	@Override
	public Aluno editAluno(Aluno aluno) {
		entityManager.merge(aluno);
		
		return aluno;
	}

	@Override
	public Aluno delAluno(Aluno aluno) {
		aluno = entityManager.merge(aluno);
		entityManager.remove(aluno);
		
		return aluno;
	}
}
