package data.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8899106506205294313L;
	
	@Column(name="data_criacao")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date dataCriacao;

	@Column(name="data_atualizacao")
	@Temporal(TemporalType.TIMESTAMP)
	protected Date dataAtualizacao;
	
	public BaseModel() {}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataUpdate) {
		this.dataAtualizacao = dataUpdate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((dataAtualizacao == null) ? 0 : dataAtualizacao.hashCode());
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
		BaseModel other = (BaseModel) obj;
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (dataAtualizacao == null) {
			if (other.dataAtualizacao != null)
				return false;
		} else if (!dataAtualizacao.equals(other.dataAtualizacao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BaseModel [dataCriacao=" + dataCriacao + ", dataAtualizacao=" + dataAtualizacao + "]";
	}
}
