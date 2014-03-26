package biat.domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Trader
 * 
 */
@Entity
@Table(name = "t_trader")
public class Trader implements Serializable {

	@Override
	public String toString() {
		return "Trader [banque=" + banque + ", id=" + id + ", nom=" + nom + "]";
	}

	private int id;
	private Banque banque;
	private String nom;

	private static final long serialVersionUID = 1L;

	public Trader() {

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

	@ManyToOne()
	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

}
