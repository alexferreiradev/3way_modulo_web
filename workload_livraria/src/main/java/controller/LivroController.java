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
import service.exception.ServiceException;

public class LivroController extends HttpServlet {
	public static final String LISTA_LIVROS = "lista_livros";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cmdParam = req.getParameter("cmd");
		switch (cmdParam) {
		case LISTA_LIVROS:
			listarLivros(req, resp);
			break;
		default:
			resp.getWriter().println("Erro: Comando invalido");
			break;
		}
	}

	private void listarLivros(HttpServletRequest req, HttpServletResponse resp) {
		LivroService livroService = new LivroService();
		try {
			List<Livro> livros = livroService.listaLivros();
			req.setAttribute("livros", livros);
			
			RequestDispatcher rd = req.getRequestDispatcher("/pages/lista_livros.jsp");
			rd.forward(req, resp);
		} catch (ServiceException e) {
			e.printStackTrace();
			printMensagemErro("Erro ao tentar buscar livros: " + e.getMessage(), resp);
		} catch (ServletException e) {
			e.printStackTrace();
			printMensagemErro("Erro de servlet", resp);
		} catch (IOException e) {
			e.printStackTrace();
			printMensagemErro("Erro de IO", resp);
		}
	}

	private void printMensagemErro(String msg, HttpServletResponse resp) {
		try {
			resp.sendError(500, msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
