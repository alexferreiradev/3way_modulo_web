package service;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import data.dao.ItemEstoqueDao;
import data.dao.exception.DAOException;
import data.dto.ItemEstoqueDto;
import data.model.ItemEstoque;
import data.model.Livro;
import service.exception.ServiceException;

public class EstoqueService {
	private final static Logger L = LoggerFactory.getLogger(EstoqueService.class);
	private ItemEstoqueDao dao;
	private Livro selectedLivro;
	
	public EstoqueService() {
	}
	
	public List<ItemEstoqueDto> listeItems() throws ServiceException{
		try {
			List<ItemEstoque> items = dao.listeItems(0, 20);
			
			return createDtoFromItems(items);
//			return new ArrayList<>();
		} catch (IllegalArgumentException e) {
			L.error("Erro ao tentar converter model em dto: " + e.getMessage());
			throw new ServiceException("Erro ao converter dados do banco. Contate ao ADM.", e);
		} catch (DAOException e) {
			L.error("Erro no serviço de estoque ao acessar o banco: " + e.getMessage());
			throw new ServiceException("Erro no banco de dados. Contate ao ADM.", e);
		} catch (Exception e) {
			L.error("Erro no serviço de estoque desconhecido: " + e.getMessage());
			throw new ServiceException("Erro interno no sistema. Contate ao ADM.", e);
		}
	}
	
	public String addItem() {
//		FacesContext.getCurrentInstance().addMessage("Livro adicionado no estoque", null);
		L.info("Livro: " + selectedLivro + " adicionado no estoque");
		return "estoque";
	}

	private List<ItemEstoqueDto> createDtoFromItems(List<ItemEstoque> items) throws IllegalArgumentException {
		List<ItemEstoqueDto> dtos = new ArrayList<>();
		for (ItemEstoque itemEstoque : items) {
			ItemEstoqueDto dto = new ItemEstoqueDto();
			dto.setLivro(itemEstoque.getLivro());
			dto.setDisponivel(itemEstoque.getQuantidade() > 0);
			DateFormat dateTimeInstance = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
			String dataAtualizacao = dateTimeInstance.format(itemEstoque.getDataAtualizacao());
			dto.setDataAtualizacao(dataAtualizacao);
			dtos.add(dto);
		}
		
		return dtos;
	}

	public ItemEstoqueDao getDao() {
		return dao;
	}

	public void setDao(ItemEstoqueDao dao) {
		this.dao = dao;
	}

	public Livro getSelectedLivro() {
		return selectedLivro;
	}

	public void setSelectedLivro(Livro selectedLivro) {
		this.selectedLivro = selectedLivro;
	}

}
