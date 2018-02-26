package data.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import data.dao.exception.DAOException;
import data.model.Livro;

public class LivroDao extends BaseDao implements Dao {

	@Override
	public List<Livro> listeLivro(int offset, int limit) throws DAOException {
		try {
			openEntityManager();
			
			TypedQuery<Livro> query = em.createQuery("from Livro l", Livro.class);
			query.setMaxResults(limit);
			query.setFirstResult(offset);
			
			return query.getResultList();
		} catch (Exception e) {			
			L.error("Erro ao tentar buscar livros: " + e.getMessage());
			throw new DAOException("Erro desconhecido ao buscar livros no banco: " + e.getMessage(), e);
		} finally {
			closeEntityManager();
		}
	}

}
