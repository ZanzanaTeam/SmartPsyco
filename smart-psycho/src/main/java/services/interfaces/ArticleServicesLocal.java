package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import domaine.Article;

@Local
public interface ArticleServicesLocal  {

	Article findById(Integer id);
	List<Article> findAll();
	Boolean delete(Article t);
	Boolean update(Article t);
	Boolean add(Article t);
	void updateVisible(Integer id);
	List<Article> findByPsychologue(Integer idPsychologue);
	List<Article> findByType(String type, Integer idPsychologue);
}
