package data.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import data.dao.exception.DAOException;
import data.model.ItemEstoque;

public class ItemEstoqueDao extends BaseDao{

	public ItemEstoqueDao() {
	}
	
	public List<ItemEstoque> listeItems(int offset, int limit) throws DAOException {
		try {
			openEntityManager();
			
			TypedQuery<ItemEstoque> query = em.createQuery("from ItemEstoque", ItemEstoque.class);
			query.setFirstResult(offset);
			query.setMaxResults(limit);
			
			return query.getResultList();
		} catch (Exception e) {
			L.error("Erro ao listar items de estoque: " + e.getMessage());
			throw new DAOException("Erro desconhecido ao listar items de estoque", e);
		} finally {
			closeEntityManager();
		}
	}

}
