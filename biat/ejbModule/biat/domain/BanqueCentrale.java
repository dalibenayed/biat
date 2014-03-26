package biat.domain;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: BanqueCentrale
 *
 */
@Entity
@Table(name="t_banque_centrale")

public class BanqueCentrale extends Custommer implements Serializable  {

	
	@Override
	public String toString() {
		return "BanqueCentrale [name=" + name + ", pays=" + pays + ", mon_loc="
				+ mon_loc + "]";
	}



	private String name;
	private String pays;
	private String mon_loc;
	private float capital;
	private List<Banque> banques;
	private List <News>news;
	private static final long serialVersionUID = 1L;

	public BanqueCentrale() {
		super();
	}   
  


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getPays() {
		return this.pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}   
	public String getMon_loc() {
		return this.mon_loc;
	}

	public void setMon_loc(String mon_loc) {
		this.mon_loc = mon_loc;
	}   
	public float getCapital() {
		return this.capital;
	}

	public void setCapital(float capital) {
		this.capital = capital;
	}


@OneToMany(mappedBy="banqueCentrale")
	public List<Banque> getBanques() {
		return banques;
	}



	public void setBanques(List<Banque> banques) {
		this.banques = banques;
	}


	@OneToMany(mappedBy="banqueCentrale")
	public List <News> getNews() {
		if(news==null)
		{
			news=new ArrayList<News>();
		}
		
		return news;
	}



	public void setNews(List <News> news) {
		this.news = news;
	}

	

}
