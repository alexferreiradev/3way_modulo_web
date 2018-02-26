package data.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-02-25T21:44:12.147-0300")
@StaticMetamodel(ItemEstoque.class)
public class ItemEstoque_ extends BaseModel_ {
	public static volatile SingularAttribute<ItemEstoque, Long> id;
	public static volatile SingularAttribute<ItemEstoque, Integer> quantidade;
	public static volatile SingularAttribute<ItemEstoque, Livro> livro;
}
