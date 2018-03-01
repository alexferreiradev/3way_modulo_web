package ui.view;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import data.dto.ItemEstoqueDto;
import service.EstoqueService;

public class EstoqueListView {
	private final static Logger L = LoggerFactory.getLogger(EstoqueListView.class);
	
	private FacesContext fc = FacesContext.getCurrentInstance();
	private EstoqueService estoqueService;
	private ItemEstoqueDto selectedItem;

	public EstoqueListView() {
		// todo Auto-generated constructor stub
	}
	
	public void removaItem() {
		try {			
			estoqueService.removeItem(selectedItem.createItemFromDto());
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "item removido do estoque: ", String.valueOf(selectedItem.getId())));
		} catch (Exception e) {
			L.error("Erro no sistema: " + e.getMessage());
			fc.addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar remover item do estoque.", ""));
		}
	}
	
	public String editar() {
		FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Funcao nao implementada.", "details"));
		L.info("Chamou editar");
		return "estoque";
	}

	public EstoqueService getEstoqueService() {
		return estoqueService;
	}

	public void setEstoqueService(EstoqueService estoqueService) {
		this.estoqueService = estoqueService;
	}

	public ItemEstoqueDto getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(ItemEstoqueDto selectedItem) {
		this.selectedItem = selectedItem;
	}

}
