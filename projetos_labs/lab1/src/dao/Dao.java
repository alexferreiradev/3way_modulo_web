package dao;

import model.Livro;

public interface Dao<ModelType> {
	
	// CRUD = Create, Recuperar, Update, Delete
	
	ModelType criar(ModelType modelo);
	
	ModelType recuperar(Long id);
	
	ModelType update(ModelType modelo);
	
	ModelType delete(Long id);	

}
