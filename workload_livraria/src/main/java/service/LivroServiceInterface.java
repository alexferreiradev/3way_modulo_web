package service;

import java.util.List;

import data.model.Livro;
import service.exception.ServiceException;

public interface LivroServiceInterface {
	
	List<Livro> listaLivros() throws ServiceException;

}
