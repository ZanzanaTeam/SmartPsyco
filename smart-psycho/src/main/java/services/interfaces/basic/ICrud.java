package services.interfaces.basic;

import java.util.List;

/**
 * @author MedAymen
 * 
 */

public interface ICrud<T> {

	Boolean add(T t);

	Boolean update(T t);

	Boolean delete(T t);

	T findById(Integer id);

	List<T> findAll();
}
