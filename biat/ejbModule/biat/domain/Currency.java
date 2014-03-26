package biat.domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Currency
 *
 */
@Entity
@Table(name="t_currency")

public class Currency implements Serializable {

	
	private int id;
	private String nom;
 private Account account;
	private static final long serialVersionUID = 1L;

	public Currency() {
		super();
	}   
	@Id    
	public int getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Currency [nom=" + nom + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	@ManyToOne
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}

   
}
