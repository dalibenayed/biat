package biat.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Temporal;

import biat.domain.Banque;
import biat.domain.BanqueCentrale;
import biat.domain.Corporate;
import biat.domain.Custommer;
import biat.domain.Trader;

/**
 * Session Bean implementation class BanqueService
 */
@Stateless
public class BanqueService implements BanqueServiceRemote, BanqueServiceLocal {
	
	

	@PersistenceContext
	EntityManager em;

	public BanqueService() {
		// TODO Auto-generated constructor stub
	}

	public void addBanque(Banque banque) {
		em.persist(banque);
	}

	public void updateBanque(Banque banque) {
		em.merge(banque);

	}

	public void removeBanque(Banque banque) {
		em.remove(em.merge(banque));

	}

	public Banque findBanquebyId(int id) {

		return em.find(Banque.class, id);
	}
	
	/**
	 * 
	 */

	public void aadTraderToBank(Banque banque, Trader trader) {
		trader.setBanque(banque);
		if(banque.getTraders().size()<=4)
		{
			banque.getTraders().add(trader);
			em.merge(trader);
			em.merge(banque);
		}
		else
		{
			System.out.println("impossible d'ajouter un autre trader");
		}
		

	}

	@Override
	public void removeTraderFromBank(Banque banque, Trader trader) {

		// banque= em.find(Banque.class ,banque.getId());
		System.out.println(banque.getId());
		List<Trader> traders = banque.getTraders();
		//System.out.println(traders.size());

		//for (Trader trader2 : traders) {
			//System.out.println(trader2.getNom());
		//}
	//	trader = em.find(Trader.class, 20);
	//	System.out.println("le trader est" + trader);
		traders.remove(trader);
		em.merge(trader);

	}

	@SuppressWarnings("unchecked")


	@Override
	public List<Corporate> findCorporatebyBank(Banque banque) {
List<Corporate>corporates = new ArrayList<Corporate>();
corporates=banque.getCorporates();

	return corporates;
	}

	@Override
	public List<Banque> findAllBanque() {
		List<Banque> found = null;
		
String jpql = "select u from Banque u  ";
		
		Query query =em.createQuery(jpql);
		
		try{
			found =  query.getResultList();
		}
		catch(Exception ex){
		}
		return found;
	}

	@Override
	public List<Banque> TriBankbynbpoints() {
		List<Banque> found = null;
		
String jpql = "select u from Banque u  ORDER  BY u.nbpoints DESC   ";
		
		Query query =em.createQuery(jpql);
		
		try{
			found =  query.getResultList();
		}
		catch(Exception ex){
		}
		return found;	
	}
	
}
