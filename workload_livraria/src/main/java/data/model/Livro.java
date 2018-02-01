package data.model;

public class Livro {
	
	private long id;
	private String codLivro;
	private String titulo;
	private String autor;
	private String imagem;
	private String descricao;
	private double preco;
	
	public Livro() {}
	
	public Livro(long id, String codLivro, String titulo, String autor, String imagem, String descricao, double preco) {
		super();
		this.id = id;
		this.codLivro = codLivro;
		this.titulo = titulo;
		this.autor = autor;
		this.imagem = imagem;
		this.descricao = descricao;
		this.preco = preco;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCodLivro() {
		return codLivro;
	}
	public void setCodLivro(String codLivro) {
		this.codLivro = codLivro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((codLivro == null) ? 0 : codLivro.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((imagem == null) ? 0 : imagem.hashCode());
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (codLivro == null) {
			if (other.codLivro != null)
				return false;
		} else if (!codLivro.equals(other.codLivro))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id != other.id)
			return false;
		if (imagem == null) {
			if (other.imagem != null)
				return false;
		} else if (!imagem.equals(other.imagem))
			return false;
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Livro [id=" + id + ", codLivro=" + codLivro + ", titulo=" + titulo + ", autor=" + autor + ", imagem="
				+ imagem + ", descricao=" + descricao + ", preco=" + preco + "]";
	}

}
