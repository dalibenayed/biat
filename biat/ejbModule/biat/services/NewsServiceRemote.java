package biat.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import biat.domain.Corporate;
import biat.domain.News;

/**
 * Session Bean implementation class NewsServiceRemote
 */
@Stateless
@LocalBean
public class NewsServiceRemote implements NewsServiceRemoteRemote, NewsServiceRemoteLocal {

	@PersistenceContext
	  EntityManager em;
    public NewsServiceRemote() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void createNews(News news) {
		em.persist(news);
		}

	@Override
	public void removeNews(News news) {
	em.remove(em.merge(news));
		
	}

	@Override
	public News findnews(String date) {
		return em.find(News.class, date);
		
	}

	@Override
	public List<News> DisplayAllNews() {
		List<News> found = null;
		
String jpql = "select u from News u  ";
		
		Query query =em.createQuery(jpql);
		
		try{
			found =  query.getResultList();
		}
		catch(Exception ex){
		}
		return found;
	}
	
}
