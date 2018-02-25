package service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import data.dao.LivroDao;
import data.dao.exception.DAOException;
import data.model.Livro;
import service.exception.ServiceException;

public class LivroService {
	private final static Logger L = LoggerFactory.getLogger(LivroService.class);
	
	private LivroDao livroDao;
	
	public List<Livro> listeLivros() throws ServiceException{
		try {
			return livroDao.listeLivro(0, 20); // todo adicionar command para receber parametros de paginacao
		} catch (DAOException e) {
			L.error("Erro no banco ao tentar listar livros: " + e.getMessage());
			throw new ServiceException("Erro no banco de dados, contate o ADM do sistema");
		}
	}

	public LivroDao getLivroDao() {
		return livroDao;
	}

	public void setLivroDao(LivroDao livroDao) {
		this.livroDao = livroDao;
	}

}
