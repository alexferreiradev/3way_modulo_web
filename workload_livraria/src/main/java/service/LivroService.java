package service;

import java.util.ArrayList;
import java.util.List;

import data.dao.LivroDao;
import data.dao.exception.DAOException;
import data.model.Livro;
import service.exception.ServiceException;

//@ManagedBean(name="livroService")
//@RequestScoped
public class LivroService implements LivroServiceInterface {
	private LivroDao livroDao;
	
	@Override
	public List<Livro> listLivros() throws ServiceException {
		List<Livro> livros = new ArrayList<>();
		
		try {
			List<Livro> livrosPorPreco = livroDao.livrosPorPreco(0);
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
