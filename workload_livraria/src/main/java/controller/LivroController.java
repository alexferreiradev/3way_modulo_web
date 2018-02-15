package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.model.Livro;
import service.LivroService;

public class LivroController extends HttpServlet {

	private LivroService livroService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		livroService = new LivroService();
		
		List<Livro> livros = livroService.listeLivros();
		req.setAttribute("livros", livros);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index,jsp");
		requestDispatcher.forward(req, resp);
	}

	
}
