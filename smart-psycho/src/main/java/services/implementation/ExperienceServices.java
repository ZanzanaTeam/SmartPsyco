package services.implementation;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.ExperienceServicesLocal;
import services.interfaces.UtilisateurServicesLocal;
import domaine.Experience;

@Stateless
public class ExperienceServices implements ExperienceServicesLocal {

	@PersistenceContext
	EntityManager entityManager;
	
	@EJB UtilisateurServicesLocal patientServicesLocal;

	@Override
	public Boolean add(Experience t) {
		try {
			entityManager.merge(t);
			return true;
		} catch (Exception ee) {
			return false;
		}
	}

	@Override
	public Boolean update(Experience t) {
		try {
			entityManager.merge(t);
			return true;
		} catch (Exception ee) {
			return false;
		}
	}

	@Override
	public Boolean delete(Experience t) {

		try {
			entityManager.remove(findById(t.getId()));
			return true;
		} catch (Exception ee) {
			return false;
		}
	}

	@Override
	public Experience findById(Integer id) {
		return entityManager.find(Experience.class, id);
	}

	@Override
	public List<Experience> findAll() {
		String jpql = "select ex from Experience ex";
		return entityManager.createQuery(jpql, Experience.class)
				.getResultList();
	}

	@Override
	public void updateVisible(Integer id) {

		Experience experience = findById(id);
		experience.setVisible(!experience.getVisible());
		entityManager.merge(experience);
	}

	@Override
	public List<Experience> findByPatient(Integer idPatient) {
		
		String jpql = "select e from Experience e where e.patient.id = :id";
		Query query = entityManager.createQuery(jpql,Experience.class);
		query.setParameter("id", idPatient);
		return query.getResultList();
	}
}
