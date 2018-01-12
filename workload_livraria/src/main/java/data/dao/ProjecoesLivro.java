package data.dao;

import java.util.List;

import data.model.Livro;

public interface ProjecoesLivro {

	List<Livro> livrosPorChaveValor(String chave, String valor);
	
	List<Livro> livrosPorCodigo(String codigo);
	
	List<Livro> livrosPorPreco(double preco);
}
