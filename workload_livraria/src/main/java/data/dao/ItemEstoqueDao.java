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
	
	public ItemEstoque addItem(ItemEstoque item) throws DAOException {
		try {
			openEntityManager();
			em.getTransaction().begin();
			item = em.merge(item);
			em.getTransaction().commit();
			
			return item;
		} catch (Exception e) {
			if (em.getTransaction() != null && em.getTransaction().isActive()) {
				L.debug("Realizando rollback de adicao de item de estoque.");
				em.getTransaction().rollback();
			}
			
			L.error("Erro ao salvar item de estoque: " + e.getMessage());
			throw new DAOException("Erro desconhecido ao salvar item de estoque", e);
		} finally {
			closeEntityManager();
		}
	}

	public ItemEstoque removeItem(ItemEstoque item) throws DAOException {
		try {
			openEntityManager();
			
			em.getTransaction().begin();
			item = em.find(ItemEstoque.class, item.getId());
			em.remove(item);
			em.getTransaction().commit();
			
			return item;
		} catch (Exception e) {
			if (em.getTransaction() != null && em.getTransaction().isActive()) {
				L.debug("Realizando rollback de remocao de item de estoque.");
				em.getTransaction().rollback();
			}
			
			L.error("Erro ao remover item de estoque: " + e.getMessage());
			throw new DAOException("Erro desconhecido ao remover item de estoque", e);
		} finally {
			closeEntityManager();
		}
	}

}
