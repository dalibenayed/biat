package biat.domain;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Banque
 *
 */
@Entity
@Table(name="t_banque")
public class Banque extends Custommer implements Serializable   {

	
	private String nom;
	private float capital;
	private List<Corporate>corporates;
	private List<Trader> traders;
	private BanqueCentrale banqueCentrale;
	private int nbpoints;
	private static final long serialVersionUID = 1L;

	public Banque() {
		super();
	}   

	public String getNom() {
		return this.nom;
	}

	@Override
	public String toString() {
		return "Banque [nom=" + nom + ", capital=" + capital + "]";
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
   
	public float getCapital() {
		return this.capital;
	}

	public void setCapital(float capital) {
		this.capital = capital;
	}
    @OneToMany(mappedBy="banque")
	public List<Trader> getTraders() {
    	if(traders==null)
    		traders= new ArrayList<Trader>();
		return traders;
	}

	public void setTraders(List<Trader> traders) {
		this.traders = traders;
	}
	
@ManyToOne
@JoinColumn(name="FK_centralbank")
	public BanqueCentrale getBanqueCentrale() {
		return banqueCentrale;
	}

	public void setBanqueCentrale(BanqueCentrale banqueCentrale) {
		this.banqueCentrale = banqueCentrale;
	}
@OneToMany(mappedBy="banque")
	public List<Corporate> getCorporates() {
	if(corporates==null)
	{
		corporates=new ArrayList<Corporate>();
	}
		return corporates;
	}

	public void setCorporates(List<Corporate> corporates) {
		this.corporates = corporates;
	}

	public int getNbpoints() {
		return nbpoints;
	}

	public void setNbpoints(int nbpoints) {
		this.nbpoints = nbpoints;
	}

   
}
