package biat.domain;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Account
 *
 */
@Entity
@Table(name="t_account")

public class Account implements Serializable {


	private int id;
	private String nom;
   private List<Currency>currencies;
	private Custommer custommer;
	private static final long serialVersionUID = 1L;

	public Account() {
		super();
	}   
	@Id    
	public int getId() {
		return this.id;
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

	@OneToOne(mappedBy="account")
	public Custommer getCustommer() {
		return custommer;
	}
	public void setCustommer(Custommer custommer) {
		this.custommer = custommer;
	}
	@OneToMany(mappedBy="account")
	public List<Currency> getCurrencies() {
		if(currencies==null)
		{
			currencies=new ArrayList<Currency>();
		}
		return currencies;
	}
	public void setCurrencies(List<Currency> currencies) {
		this.currencies = currencies;
	}
   
}
