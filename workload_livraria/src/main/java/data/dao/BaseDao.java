package data.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseDao {
	protected final static Logger L = LoggerFactory.getLogger(BaseDao.class);
	
	protected final static EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria");
	protected EntityManager em;

	public BaseDao() {
	}

	protected synchronized void closeEntityManager() {
		if (em != null && em.isOpen()) {
			em.close();
		}
	}
	
	protected synchronized void openEntityManager() {
		if (em == null || !em.isOpen()) {
			em = factory.createEntityManager();
		}
	}
}
