package ui.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import data.dto.ItemEstoqueDto;
import data.model.ItemEstoque;
import service.EstoqueService;

public class EstoqueListView {
	private final static Logger L = LoggerFactory.getLogger(EstoqueListView.class);
	
	private FacesContext fc = FacesContext.getCurrentInstance();
	private EstoqueService estoqueService;
	private ItemEstoqueDto selectedItem;

	public EstoqueListView() {
		// todo Auto-generated constructor stub
	}
	
	public void removeItem() {
		try {
			ItemEstoque itemEstoque = createItemFromDto();
			
			estoqueService.removeItem(itemEstoque);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "item removido do estoque: ", String.valueOf(selectedItem.getId())));
		} catch (Exception e) {
			L.error("Erro no sistema: " + e.getMessage());
			fc.addMessage("messages", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao tentar remover item do estoque.", ""));
		}
	}

	private ItemEstoque createItemFromDto() throws ParseException {
		ItemEstoque itemEstoque = new ItemEstoque();
		
		itemEstoque.setId(Long.valueOf(selectedItem.getId()));
		itemEstoque.setLivro(selectedItem.getLivro());
		itemEstoque.setQuantidade(Integer.valueOf(selectedItem.getQuantidade()));
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
		Date dataUpdate = dateFormat.parse(selectedItem.getDataAtualizacao());
		itemEstoque.setDataAtualizacao(dataUpdate);
		Date dataCriacao = dateFormat.parse(selectedItem.getDataCriacao());
		itemEstoque.setDataCriacao(dataCriacao);
		
		return itemEstoque;
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
