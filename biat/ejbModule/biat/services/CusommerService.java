package biat.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import biat.domain.Custommer;

/**
 * Session Bean implementation class CusommerService
 */
@Stateless
public class CusommerService implements CusommerServiceRemote, CusommerServiceLocal {

    /**
     * Default constructor. 
     */

	@PersistenceContext
	EntityManager em;
    public CusommerService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Custommer CustommerAuthentification(String login,String password) {
		String jpql = "select u from Custommer u where u.login=:login and u.pwd=:password";
		Custommer found = null;
		Query query = em.createQuery(jpql);
		query.setParameter("login", login);
		query.setParameter("password", password);
		try{
			found = (Custommer) query.getSingleResult();
		}catch(Exception ex){
		}
		return found;
}
}
