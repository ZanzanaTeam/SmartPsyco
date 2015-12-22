package services.implementation;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.PatientServicesLocal;
import domaine.Patient;

@Stateless
@LocalBean
public class PatientServices implements PatientServicesLocal {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Boolean add(Patient t) {
		try {
			entityManager.merge(t);
			return true;
		} catch (Exception ee) {
			return false;
		}
	}

	@Override
	public Boolean update(Patient t) {
		try {
			entityManager.merge(t);
			return true;
		} catch (Exception ee) {
			return false;
		}
	}

	@Override
	public Boolean delete(Patient t) {

		try {
			entityManager.remove(findById(t.getId()));
			return true;
		} catch (Exception ee) {
			return false;
		}
	}

	@Override
	public Patient findById(Integer id) {
		return entityManager.find(Patient.class, id);
	}

	@Override
	public List<Patient> findAll() {
		String jpql = "select patient from Patient patient";
		return entityManager.createQuery(jpql, Patient.class).getResultList();
	}

	@Override
	public Boolean findPatientByLoginPassword(String login, String password) {
		String jpql = "select patient from Patient patient "
				+ "where patient.login = :login and patient.password = :password";
		Query query = entityManager.createQuery(jpql, Patient.class);
		query.setParameter("login", login);
		query.setParameter("password", password);
		try {
			query.getSingleResult();
			return true;
		} catch (Exception ee) {
			return false;
		}
	}

	@Override
	public Boolean findPatientByLogin(String login) {
		String jpql = "select patient from Patient patient "
				+ "where patient.login = :login";
		Query query = entityManager.createQuery(jpql, Patient.class);
		query.setParameter("login", login);
		
		
		try {
		
			if (query.getResultList().size() != 0)
				return true;
			else
				return false;
		} catch (Exception ee) {
			System.err.println(ee.getMessage());
			return false;
		}
	}
}
