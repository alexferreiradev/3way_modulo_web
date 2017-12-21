package dao;

import java.util.List;

import model.Livro;

public class TestaPesquisar {

	public static void main(String[] args) {
		LivroDao livroDao = new LivroDao();
		
		Livro livroGrandeSertoes = livroDao.recuperar(1L);
		System.out.println(livroGrandeSertoes);
		
		List<Livro> livros = livroDao.consultar("MUNDO");
		for (Livro livro : livros) {
			System.out.println("Codigo: " + livro.getCodigo());
			System.out.println("Titulo: " + livro.getTitulo());
			System.out.println("Desc: " + livro.getDescricao());
			System.out.println("Imagem: " + livro.getImagem());
			System.out.println("Preco: " + livro.getPreco());
		}

	}

}
