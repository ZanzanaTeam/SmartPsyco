package services.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import services.interfaces.basic.ICrud;
import domaine.Category;

public class CategoryServices implements ICrud<Category> {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Boolean add(Category t) {
		entityManager.persist(t);
		return null;
	}

	@Override
	public Boolean update(Category t) {
		entityManager.merge(t);
		return null;
	}

	@Override
	public Boolean delete(Category t) {
		
		return null;
	}

	@Override
	public Category findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
