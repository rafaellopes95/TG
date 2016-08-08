package edu.fatec.mural.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.fatec.mural.model.Publicacao;

@Repository
@Transactional(readOnly = false)
public class PublicacaoDaoImpl implements PublicacaoDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Publicacao> listPublicacoes() {
		List<Publicacao> publicacoes = entityManager.createQuery("SELECT p FROM Publicacao p "
				+ "LEFT JOIN p.colaborador "
				+ "LEFT JOIN p.aluno "
				+ "LEFT JOIN p.pagina").getResultList();
		
		return publicacoes;
	}

	@Override
	public Publicacao getPublicacao(int codigo) {
		Publicacao publicacao = entityManager.find(Publicacao.class, codigo);
		
		return publicacao;
	}

	@Override
	public Publicacao addPublicacao(Publicacao publicacao) {
		entityManager.persist(publicacao);
		
		return publicacao;
	}

	@Override
	public Publicacao editPublicacao(Publicacao publicacao) {
		entityManager.merge(publicacao);
		
		return publicacao;
	}

	@Override
	public Publicacao delPublicacao(Publicacao publicacao) {
		publicacao = entityManager.merge(publicacao);
		entityManager.remove(publicacao);
		
		return publicacao;
	}
}
