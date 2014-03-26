package biat.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import biat.domain.BanqueCentrale;
import biat.domain.Corporate;
import biat.domain.News;

/**
 * Session Bean implementation class BanqueCentraleService
 */
@Stateless
@LocalBean
public class BanqueCentraleService implements BanqueCentraleServiceRemote, BanqueCentraleServiceLocal {

	@PersistenceContext
	EntityManager em;
    public BanqueCentraleService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void createBanqueCentrale(BanqueCentrale banqueCentrale) {
	em.persist(banqueCentrale);
		
	}

	public void updateBanqueCentrale(BanqueCentrale banqueCentrale) {
	em.merge(banqueCentrale);
		
	}

	@Override
	public void removeBanqueCentrale(BanqueCentrale banqueCentrale) {
	em.remove(em.merge(banqueCentrale));
		
	}

	@Override
	public BanqueCentrale findBanqueCentralebyid(int id) {
		return em.find(BanqueCentrale.class, id);
		
	}

	public void publishInformation(BanqueCentrale banqueCentrale, News news) {
		 news.setBanqueCentrale(banqueCentrale);
		    banqueCentrale.getNews().add(news);
		    em.merge(news);
		    em.merge(banqueCentrale);
		  
		    
			
	
		
	}

	@Override
	public List<BanqueCentrale> DisplayAllCentrallBank() {
		List<BanqueCentrale> found = null;
		
String jpql = "select u from BanqueCentrale  u  ";
		
		Query query =em.createQuery(jpql);
		
		try{
			found =  query.getResultList();
		}
		catch(Exception ex){
		}
		return found;
	}
	


}
