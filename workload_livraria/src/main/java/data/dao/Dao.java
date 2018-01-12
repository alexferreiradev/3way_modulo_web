package data.dao;

public interface Dao<ModelType> {
	
	ModelType create(ModelType modelo);
	
	ModelType recuperar(long id);
	
	ModelType update(long id, String chave, String valor);
	
	ModelType delete(ModelType modelo);

}
