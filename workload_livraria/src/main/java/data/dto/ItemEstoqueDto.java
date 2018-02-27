package data.dto;

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
