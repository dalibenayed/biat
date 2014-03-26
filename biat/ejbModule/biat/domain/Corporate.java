package biat.domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Corporate
 *
 */
@Entity
@Table(name="t_corporate")

public class Corporate extends Custommer implements Serializable {
  
    @Override
	public String toString() {
		return "Corporate [id=" + id + ", nom=" + nom + "]";
	}


	private int id;
	private String nom;
	private int capital;
	private Banque banque;
	private static final long serialVersionUID = 1L;

	public Corporate() {
		super();
	}   
   
  
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	 
	public int getCapital() {
		return this.capital;
	}

	public void setCapital(int i) {
		this.capital = i;
	}

@ManyToOne
	public Banque getBanque() {
		return banque;
	}


	public void setBanque(Banque banque) {
		this.banque = banque;
	}
   
}
