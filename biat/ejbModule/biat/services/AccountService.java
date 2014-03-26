package biat.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import biat.domain.Account;
import biat.domain.Banque;

/**
 * Session Bean implementation class AccountService
 */
@Stateless
public class AccountService implements AccountServiceRemote, AccountServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
    public AccountService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void createAcount(Account account) {
		em.persist(account);
		
	}

	@Override
	public void removeAccount(Account account) {
	em.remove(em.merge(account));
		
	}

	@Override
	public Account findAcountbyid(int id) {
		return em.find(Account.class, id);
	}

	@Override
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Account> displayallaccount() {
		List<Account> found = null;
		
String jpql = "select u from Account u  ";
		
		Query query =em.createQuery(jpql);
		
		try{
			found =  query.getResultList();
		}
		catch(Exception ex){
		}
		return found;
	}
	}
    
    


