package data.dao;

import java.util.Iterator;
import java.util.List;

import data.dao.exception.DAOException;
import data.model.Livro;

public class TestaLivroDao {

	public static void main(String[] args) {
		LivroDao livroDao = new LivroDao();
		
		List<Livro> livros;
		try {
			livros = livroDao.listeLivro(0, 20);
			Iterator<Livro> iterator = livros.iterator();
			while (iterator.hasNext()) {
				Livro livro = (Livro) iterator.next();
				System.out.println("Livro: " + livro);
			}
		} catch (DAOException e) {
			// todo Auto-generated catch block
			e.printStackTrace();
		}
	}

}
