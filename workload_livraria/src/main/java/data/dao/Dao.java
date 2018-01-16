package data.dao;

import data.dao.exception.DAOException;

public interface Dao<ModelType> {
	
	ModelType create(ModelType modelo) throws DAOException;
	
	ModelType recuperar(long id) throws DAOException;
	
	ModelType update(long id, String chave, String valor) throws DAOException;
	
	ModelType delete(ModelType modelo) throws DAOException;

}
