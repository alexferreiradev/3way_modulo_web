package service;

import java.util.ArrayList;
import java.util.List;

import data.dao.LivroDao;
import data.dao.exception.DAOException;
import data.model.Livro;
import service.exception.ServiceException;

public class LivroService implements LivroServiceInterface {
	private LivroDao livroDao;

	@Override
	public List<Livro> listaLivros() throws ServiceException {
		List<Livro> livros = new ArrayList<>();
		
		try {
			setLivroDao(new LivroDao());
			List<Livro> livrosPorPreco = getLivroDao().livrosPorPreco(0);
			if (livrosPorPreco != null) {
				livros = livrosPorPreco;
			}
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("Erro no banco ao listar livros: " + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException("Erro desconhecido no banco ao listar livros.");
		}
		
		return livros;
	}

	public LivroDao getLivroDao() {
		return livroDao;
	}

	public void setLivroDao(LivroDao livroDao) {
		this.livroDao = livroDao;
	}

}
