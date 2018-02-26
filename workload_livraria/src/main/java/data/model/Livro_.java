package data.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-02-25T21:14:30.238-0300")
@StaticMetamodel(Livro.class)
public class Livro_ extends BaseModel_ {
	public static volatile SingularAttribute<Livro, Long> id;
	public static volatile SingularAttribute<Livro, String> titulo;
	public static volatile SingularAttribute<Livro, String> autor;
	public static volatile SingularAttribute<Livro, String> imagem;
	public static volatile SingularAttribute<Livro, String> descricao;
	public static volatile SingularAttribute<Livro, Double> preco;
}
