package data.dto;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import data.model.ItemEstoque;
import data.model.Livro;

public class ItemEstoqueDto {
	private String id;
	private Livro livro;
	private boolean disponivel;
	private String quantidade;
	private String dataAtualizacao;
	private String dataCriacao;

	public ItemEstoqueDto() {
		this.id = "";
		this.quantidade = "";
		this.dataAtualizacao = "";
		this.dataCriacao = "";
	}
	
	public ItemEstoque createItemFromDto() throws ParseException {
		ItemEstoque itemEstoque = new ItemEstoque();
		
		itemEstoque.setId(Long.valueOf(id));
		itemEstoque.setLivro(livro);
		Integer qtd = quantidade.isEmpty() ? new Integer(1) : Integer.valueOf(quantidade);
		itemEstoque.setQuantidade(qtd);
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);
		Date dataAtualizacao = this.dataAtualizacao.isEmpty() ? null : dateFormat.parse(this.dataAtualizacao);
		itemEstoque.setDataAtualizacao(dataAtualizacao);
		Date dataCriacao = this.dataCriacao.isEmpty() ? null : dateFormat.parse(this.dataCriacao);
		itemEstoque.setDataCriacao(dataCriacao);
		
		return itemEstoque;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public String getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(String dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(String dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public String toString() {
		return "ItemEstoqueDto [id=" + id + ", livro=" + livro + ", disponivel=" + disponivel + ", quantidade="
				+ quantidade + ", dataAtualizacao=" + dataAtualizacao + ", dataCriacao=" + dataCriacao + "]";
	}
}
