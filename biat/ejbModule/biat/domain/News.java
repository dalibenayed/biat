package biat.domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: News
 *
 */
@Entity
@Table(name="t_news")

public class News implements Serializable {

	
	private int id;
	private String contenu;
	private String date;
	private BanqueCentrale banqueCentrale;
	private static final long serialVersionUID = 1L;

	public News() {
		super();
	}   
	@Id    
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getContenu() {
		return this.contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}   
	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	@ManyToOne
	public BanqueCentrale getBanqueCentrale() {
		return banqueCentrale;
	}
	public void setBanqueCentrale(BanqueCentrale banqueCentrale) {
		this.banqueCentrale = banqueCentrale;
	}
   
}
