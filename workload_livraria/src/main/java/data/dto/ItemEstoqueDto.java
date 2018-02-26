package data.dto;

import data.model.Livro;

public class ItemEstoqueDto {
	private Livro livro;
	private boolean disponivel;
	private String dataAtualizacao;

	public ItemEstoqueDto() {
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

	@Override
	public String toString() {
		return "ItemEstoqueDto [livro=" + livro + ", disponivel=" + disponivel + ", dataAtualizacao=" + dataAtualizacao
				+ "]";
	}
}
