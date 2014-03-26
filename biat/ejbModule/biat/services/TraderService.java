package biat.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import biat.domain.Banque;
import biat.domain.Trader;

/**
 * Session Bean implementation class TraderService
 */
@Stateless
@LocalBean
public class TraderService implements TraderServiceRemote, TraderServiceLocal {
	@PersistenceContext
    EntityManager em;
    public TraderService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addTrader(Trader trader) {
		em.persist(trader);
		
	}

	@Override
	public void updateBanque(Trader trader) {
		em.merge(trader);
		
	}

	@Override
	public void removeBanque(Trader trader) {
		em.remove(em.merge(trader));
		
	}

	@Override
	public Trader findTraderbyId(int id) {
		return em.find(Trader.class, id);
	}

	@Override
	public List<Trader> displayalltrader() {
		List<Trader> found = null;
		
String jpql = "select u from Trader u  ";
		
		Query query =em.createQuery(jpql);
		
		try{
			found =  query.getResultList();
		}
		catch(Exception ex){
		}
		return found;
	}
	



}
