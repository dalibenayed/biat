package biat.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import biat.domain.Banque;
import biat.domain.Currency;
import biat.domain.Currencypairs;

/**
 * Session Bean implementation class CurrencyPairsService
 */
@Stateless
public class CurrencyPairsService implements CurrencyPairsServiceRemote,
		CurrencyPairsServiceLocal {

	@EJB
	CurrencyServiceLocal currencyServiceLocal;

	/**
	 * Default constructor.
	 */

	@PersistenceContext
	EntityManager em;

	public CurrencyPairsService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addcurrencypairs(Currencypairs currencypairs) {
		em.persist(currencypairs);

	}

	@Override
	public void removecurrencypairs(Currencypairs currencypairs) {
		em.remove(em.merge(currencypairs));

	}

	@Override
	public Currencypairs findcurrencypairsbyId(int id) {
		return em.find(Currencypairs.class, id);

	}

	@SuppressWarnings("unchecked")
	public List<Currencypairs> displayallcurrencypairs() {
		List<Currencypairs> found = null;

		String jpql = "select u from Currencypairs u  ";

		Query query = em.createQuery(jpql);

		try {
			found = query.getResultList();
		} catch (Exception ex) {
		}
		return found;

	}

	@Override
	public void updatecurrencypairs(Currencypairs currencypairs) {
		em.merge(currencypairs);

	}

	@Override
	public void createcurencypairs() {

		Currencypairs currencypairs;

		List<Currency> currencies = currencyServiceLocal.displayallCurrency();
		List<Currency> currencies1 = currencyServiceLocal.displayallCurrency();

		for (Currency currency : currencies) {
			Iterator<Currency> t = currencies.iterator();
			for (Currency currency1 : currencies1) {
				Currency currency2 = t.next();
				if (!currency1.equals(currency2)) {

					currencypairs = new Currencypairs();

					currencypairs.setCurrency1(currency1);
					currencypairs.setCurrency2(currency2);
					currencypairs.init();

					addcurrencypairs(currencypairs);
				}
			}
			boolean a = currencies1.remove(currency);
			System.out.println("le resultat est" + a);
		}

	}

	@Override
	public void controleBIDASK(Currencypairs currencypairs,float a ) {
	if (currencypairs.getAsk()-currencypairs.getBid()>a)
	{
		System.out.println("dépassement du ratio");
	}
	
	}
}
