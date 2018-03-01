package ui.view;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import data.model.ItemEstoque;
import data.model.Livro;
import service.EstoqueService;

public class AddLivroEstoqueView {
	private final static Logger L = LoggerFactory.getLogger(AddLivroEstoqueView.class);
	
	private FacesContext fc = FacesContext.getCurrentInstance();
	private Livro selectedLivro;
	private int quantidade;
	private EstoqueService estoqueService;
	
	public String addLivro() {
		L.info("Add livro feito");
		try {
			ItemEstoque item = new ItemEstoque();
			item.setLivro(this.selectedLivro);
			item.setQuantidade(quantidade);
			
			estoqueService.addItem(item);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "item adicionado ao estoque.", "detail"));
			L.info("Add livro feito");
		} catch (Exception e) {
			L.error("Erro no sistema");
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar adicionar item ao estoque.", "erro"));
		}
		
		return "estoque";
	}

	public Livro getSelectedLivro() {
		return selectedLivro;
	}

	public void setSelectedLivro(Livro selectedLivro) {
		this.selectedLivro = selectedLivro;
	}

	public EstoqueService getEstoqueService() {
		return estoqueService;
	}

	public void setEstoqueService(EstoqueService estoqueService) {
		this.estoqueService = estoqueService;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
