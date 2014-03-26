package biat.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import biat.domain.Banque;
import biat.domain.Currency;

/**
 * Session Bean implementation class CurrencyService
 */
@Stateless
public class CurrencyService implements CurrencyServiceRemote, CurrencyServiceLocal {
	@PersistenceContext
	EntityManager em;
    /**
     * Default constructor. 
     */
    public CurrencyService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addcurrency(Currency currency) {
	em.persist(currency);
		
	}

	@Override
	public void removecurrency(Currency currency) {
	em.remove(em.merge(currency));
		
	}

	@Override
	public Currency findcurrencybyid(int id) {

		return em.find(Currency.class, id);
		
	}

	@Override
	public void updatecurrency(Currency currency) {
em.merge(currency);
		
	}

	@SuppressWarnings("unchecked")
	public List<Currency> displayallCurrency() {
		List<Currency> found = null;
		
String jpql = "select u from Currency u  ";
		
		Query query =em.createQuery(jpql);
		
		try{
			found =  query.getResultList();
		}
		catch(Exception ex){
		}
		return found;
	}
	

}
