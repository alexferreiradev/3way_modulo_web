package data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.dao.conection.FabricaConexao;
import data.model.Livro;

public class LivroDao implements Dao {

	@Override
	public List<Livro> listeLivro() {
		List<Livro> livros = new ArrayList<>();
		
		Connection connection = FabricaConexao.getConnection();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement("select * from estoque");
			ResultSet resultSet = prepareStatement.executeQuery();
			
			while(resultSet.next()) {
				Livro livro = new Livro();
				livro.setId(resultSet.getLong("id"));
				livro.setCodLivro(resultSet.getString("COD_LIVRO"));
				livro.setTitulo(resultSet.getString("TITULO"));
				livro.setAutor(resultSet.getString("AUTOR"));
				livro.setDescricao(resultSet.getString("DESCRICAO"));
				livro.setImagem(resultSet.getString("IMAGEM"));
				livro.setPreco(resultSet.getDouble("PRECO"));
				
				livros.add(livro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return livros;
	}

}
