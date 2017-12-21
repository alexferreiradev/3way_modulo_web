package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Livro;

public class LivroDao implements Dao<Livro> {

	private static final String NOME_COL_AUTOR_LIVRO = "autor";
	private static final String OBTER_LIVRO_COD = ""
			+ "Select * from estoque e where e.cod_livro = ?;";
	
	private static final String NOME_COL_COD_LIVRO = "cod_livro";
	private static final String NOME_COL_TITULO_LIVRO = "titulo";
	private static final String NOME_COL_DESC_LIVRO = "descricao";
	private static final String NOME_COL_PRECO_LIVRO = "preco";
	private static final String NOME_COL_IMAGEM_LIVRO = "imagem";
	private static final String OBTER_LIVROS_POR_TITULO = ""
			+ "Select * from estoque e where e.titulo like ?;";
	

	@Override
	public Livro criar(Livro modelo) {
		// todo Auto-generated method stub
		return null;
	}

	@Override
	public Livro recuperar(Long id) {
		Livro livro = new Livro();
		
		try (Connection con = FabricaConexao.getConnection();){
			PreparedStatement ps = con.prepareStatement(OBTER_LIVRO_COD);
			ps.setInt(1, Integer.parseInt(String.valueOf(id)));
			
			ResultSet resultadoBanco = ps.executeQuery();
			livro.setCodigo(resultadoBanco.getInt(NOME_COL_COD_LIVRO));
			livro.setTitulo(resultadoBanco.getString(NOME_COL_TITULO_LIVRO));
			livro.setDescricao(resultadoBanco.getString(NOME_COL_DESC_LIVRO));
			livro.setAutor(resultadoBanco.getString(NOME_COL_AUTOR_LIVRO));
			livro.setImagem(resultadoBanco.getString(NOME_COL_IMAGEM_LIVRO));
			livro.setPreco(resultadoBanco.getDouble(NOME_COL_PRECO_LIVRO));
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return livro;
	}

	@Override
	public Livro update(Livro modelo) {
		// todo Auto-generated method stub
		return null;
	}

	@Override
	public Livro delete(Long id) {
		// todo Auto-generated method stub
		return null;
	}
	
	public List<Livro> consultar(String titulo){
		List<Livro> livros = new ArrayList<>();
		
		
		try (Connection con = FabricaConexao.getConnection();){
			PreparedStatement ps = con.prepareStatement(OBTER_LIVROS_POR_TITULO);
			ps.setString(1, "%"+titulo+"%");
			
			ResultSet resultadoBanco = ps.executeQuery();
			while(resultadoBanco.next()) {
				Livro livro = new Livro();
				livro.setCodigo(resultadoBanco.getInt(NOME_COL_COD_LIVRO));
				livro.setTitulo(resultadoBanco.getString(NOME_COL_TITULO_LIVRO));
				livro.setDescricao(resultadoBanco.getString(NOME_COL_DESC_LIVRO));
				livro.setAutor(resultadoBanco.getString(NOME_COL_AUTOR_LIVRO));
				livro.setImagem(resultadoBanco.getString(NOME_COL_IMAGEM_LIVRO));
				livro.setPreco(resultadoBanco.getDouble(NOME_COL_PRECO_LIVRO));
				
				livros.add(livro);
			}
			
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return livros;
		}
		
		return livros;
	}

}
