package data.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import data.dao.exception.DAOException;
import data.model.Livro;

public class LivroDao implements Dao {
	private final static Logger L = LoggerFactory.getLogger(LivroDao.class);
	
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria");
	private EntityManager em;

	@Override
	public List<Livro> listeLivro(int offset, int limit) throws DAOException {
		List<Livro> livros = new ArrayList<>();
		
		try {
			em = factory.createEntityManager();
			TypedQuery<Livro> query = em.createQuery("from Livro l", Livro.class);
			query.setMaxResults(limit);
			query.setFirstResult(offset);
			livros = query.getResultList(); // todo verificar se retorna null
		} catch (Exception e) {
			L.error("Erro ao tentar buscar livros: " + e.getMessage());
			throw new DAOException("Erro desconhecido ao buscar livros no banco: " + e.getMessage());
		}
		
		return livros;
	}

}
