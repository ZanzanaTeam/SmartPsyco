package services.implementation;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import domaine.Article;
import services.interfaces.ArticleServicesLocal;
import services.interfaces.UtilisateurServicesLocal;

@Stateless
public class ArticleServices implements ArticleServicesLocal{

	@PersistenceContext
	EntityManager entityManager;
	
	@EJB UtilisateurServicesLocal psychologueServicesLocal;
	
	@Override
	public Boolean add(Article t) {
		try {
			entityManager.merge(t);
			return true;
		} catch (Exception ee) {
			return false;
		}
	}

	@Override
	public Boolean update(Article t) {
		try {
			entityManager.merge(t);
			return true;
		} catch (Exception ee) {
			return false;
		}
	}

	@Override
	public Boolean delete(Article t) {

		try {
			entityManager.remove(findById(t.getId()));
			return true;
		} catch (Exception ee) {
			return false;
		}
	}

	@Override
	public Article findById(Integer id) {
		return entityManager.find(Article.class, id);
	}

	@Override
	public List<Article> findAll() {
		String jpql = "select ex from Article ar where ar.visible = true";
		return entityManager.createQuery(jpql, Article.class)
				.getResultList();
	}

	@Override
	public void updateVisible(Integer id) {
		Article article = findById(id);
		article.setVisible(!article.getVisible());
		entityManager.merge(article);
	}

	@Override
	public List<Article> findByPsychologue(Integer idPsychologue) {
		
		String jpql = "select e from Article a where a.psychologue.id = :id";
		Query query = entityManager.createQuery(jpql,Article.class);
		query.setParameter("id", idPsychologue);
		return query.getResultList();
	}

	@Override
	public List<Article> findByType(String type, Integer idPsychologue) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	

}
