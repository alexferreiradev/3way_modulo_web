package data.dao;

import java.util.List;

import data.dao.exception.DAOException;
import data.model.Livro;

public interface Dao {
	
	List<Livro> listeLivro(int offset, int limit) throws DAOException;

}
