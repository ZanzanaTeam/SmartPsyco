package services.implementation;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import services.interfaces.UtilisateurServicesLocal;
import domaine.Patient;
import domaine.Utilisateur;

@Stateless
@LocalBean
public class UtilisateurServices implements UtilisateurServicesLocal {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Boolean add(Utilisateur t) {
		try {
			entityManager.merge(t);
			return true;
		} catch (Exception ee) {
			return false;
		}
	}

	@Override
	public Boolean update(Utilisateur t) {
		try {
			entityManager.merge(t);
			return true;
		} catch (Exception ee) {
			return false;
		}
	}

	@Override
	public Boolean delete(Utilisateur t) {

		try {
			entityManager.remove(findById(t.getId()));
			return true;
		} catch (Exception ee) {
			return false;
		}
	}

	@Override
	public Utilisateur findById(Integer id) {
		return entityManager.find(Utilisateur.class, id);
	}

	@Override
	public List<Utilisateur> findAll() {
		String jpql = "select patient from Utilisateur patient";
		return entityManager.createQuery(jpql, Utilisateur.class).getResultList();
	}

	@Override
	public Utilisateur findByLoginPassword(String login, String password) {
		String jpql = "select patient from Utilisateur patient "
				+ "where patient.login = :login and patient.password = :password";
		Query query = entityManager.createQuery(jpql, Utilisateur.class);
		query.setParameter("login", login);
		query.setParameter("password", password);
		try {
			return (Utilisateur) query.getSingleResult();
		} catch (Exception ee) {
			return null;
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
