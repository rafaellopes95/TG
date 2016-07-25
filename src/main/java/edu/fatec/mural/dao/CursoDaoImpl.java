package edu.fatec.mural.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.fatec.mural.model.Curso;

@Repository
@Transactional(readOnly = false)
public class CursoDaoImpl implements CursoDao {

	/*
	 * @PersistenceContext
	 * Sua funcao eh indicar para o bean do PersistenceAnnotationBeanPostProcessor onde 
	 * o EntityManager deve ser injetado
	 */
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Curso> listCursos() {
		List<Curso> cursos = entityManager.createQuery("SELECT c.sigla, c.nome, c.periodo, "
				+ "c.numSemestres FROM Curso c").getResultList();
		
		return cursos;
	}

	@Override
	public Curso getCurso(String sigla) {
		Curso curso = new Curso();
		curso = entityManager.find(Curso.class, sigla);
		
		return curso;
	}

	@Override
	public Curso addCurso(Curso curso){
		entityManager.persist(curso);
		
		return curso;
	}
	
	@Override
	public Curso editCurso(Curso curso) {
		entityManager.merge(curso);
		
		return curso;
	}

	@Override
	public Curso delCurso(Curso curso) {
		curso = entityManager.merge(curso);
		entityManager.remove(curso);
		
		return curso;
	}
}
