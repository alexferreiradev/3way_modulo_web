package service;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import data.dao.ItemEstoqueDao;
import data.dao.exception.DAOException;
import data.dto.ItemEstoqueDto;
import data.model.ItemEstoque;
import service.exception.ServiceException;

public class EstoqueService {
	private final static Logger L = LoggerFactory.getLogger(EstoqueService.class);
	private ItemEstoqueDao dao;
	private FacesContext fc = FacesContext.getCurrentInstance();
	
	public EstoqueService() {
	}
	
	public List<ItemEstoqueDto> listeItems() throws ServiceException{
		try {
			List<ItemEstoque> items = dao.listeItems(0, 20);
			
			return createDtoFromItems(items);
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
	
	public ItemEstoque addItem(ItemEstoque item) throws ServiceException {
		try {
			item = dao.addItem(item);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item adicionado", "com sucesso"));
		} catch (Exception e) {
			L.error("Erro ao tentar adicionar item de estoque: " + e.getMessage());
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro interno", "Contate o adm do sistema"));
		}
		
		return item;
	}

	public void removeItem(ItemEstoque item) {
		try {
			item = dao.removeItem(item);
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Item removido", "com sucesso"));
		} catch (Exception e) {
			L.error("Erro ao tentar remover item de estoque: " + e.getMessage());
			fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro interno", "Contate o adm do sistema"));
		}		
	}

	private List<ItemEstoqueDto> createDtoFromItems(List<ItemEstoque> items) throws IllegalArgumentException {
		List<ItemEstoqueDto> dtos = new ArrayList<>();
		for (ItemEstoque itemEstoque : items) {
			ItemEstoqueDto dto = new ItemEstoqueDto();
			dto.setId(String.valueOf(itemEstoque.getId()));
			dto.setLivro(itemEstoque.getLivro());
			dto.setDisponivel(itemEstoque.getQuantidade() > 0);
			DateFormat dateTimeInstance = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
			String dataAtualizacao = dateTimeInstance.format(itemEstoque.getDataAtualizacao());
			dto.setDataAtualizacao(dataAtualizacao);
			String dataCriacao = dateTimeInstance.format(itemEstoque.getDataCriacao());
			dto.setDataCriacao(dataCriacao);
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
}
