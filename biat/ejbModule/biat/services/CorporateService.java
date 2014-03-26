package biat.services;

import java.util.List;
import javax.persistence.Query;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import biat.domain.Banque;
import biat.domain.Corporate;
import biat.domain.Trader;

/**
 * Session Bean implementation class CorporateService
 */
@Stateless
@LocalBean
public class CorporateService implements CorporateServiceRemote, CorporateServiceLocal {
	@PersistenceContext
 EntityManager em;
    public CorporateService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addCorporate(Corporate corporate) {
	em.persist(corporate);
		
	}

	@Override
	public void updateBanque(Corporate corporate) {
	em.merge(corporate);
		
	}

	@Override
	public void removeBanque(Corporate corporate) {
		em.remove(em.merge(corporate));
		
	}

	@Override
	public Corporate findCorporatebyId(int id) {
		
	return em.find(Corporate.class, id);
	}

	@Override
	public List<Corporate> findAllCorporates() {
		List<Corporate> found = null;
		
String jpql = "select u from Corporate u  ";
		
		Query query =em.createQuery(jpql);
		
		try{
			found =  query.getResultList();
		}
		catch(Exception ex){
		}
		return found;
	}

	@Override
	public void addcorporatetobank(Banque banque, Corporate corporate) {
		corporate.setBanque(banque);
		banque.getCorporates().add(corporate);
		em.merge(corporate);
		em.merge(banque);
		
	}

	
	

}
