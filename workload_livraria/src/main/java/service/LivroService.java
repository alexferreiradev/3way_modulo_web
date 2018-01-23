package service;

import java.util.ArrayList;
import java.util.List;

import data.dao.LivroDao;
import data.dao.exception.DAOException;
import data.model.Livro;
import service.exception.ServiceException;

public class LivroService implements LivroServiceInterface {

	private service.LivroService listaLivros;

	@Override
	public List<Livro> listaLivros() throws ServiceException {
		List<Livro> livros = new ArrayList<>();
		
		try {
			LivroDao livroDao = new LivroDao();
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

	
	public service.LivroService getListaLivros() {
		return listaLivros;
	}


	
	public void setListaLivros(service.LivroService listaLivros) {
		this.listaLivros = listaLivros;
	}



}
