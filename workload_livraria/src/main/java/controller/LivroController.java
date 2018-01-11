package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LivroController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher rd = req.getRequestDispatcher("/pages/teste.jsp");
		List<String> lista = new ArrayList<String>();
		lista.add("teste1");
		lista.add("teste2");
		lista.add("teste3");
		lista.add("teste4");
		lista.add("teste5");
		lista.add("teste6");
		req.setAttribute("at", lista);
		rd.include(req, resp);
	}
	
}
