package biat.domain;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.persistence.*;

import sun.org.mozilla.javascript.internal.regexp.SubString;

/**
 * Entity implementation class for Entity: Currencypairs
 *
 */
@Entity
@Table(name="t_currencypairs")

public class Currencypairs implements Serializable {

	
	private int id;
	private float ask;
	private float bid;
	private Currency currency1;
	private Currency currency2;
	private  String name;
	private static final long serialVersionUID = 1L;
	
	public Currencypairs() {
		
	} 
	@PostConstruct
	public void init()
	{
	
		this.name=((currency1.getNom().substring(0, 3).concat("/")).concat(currency2.getNom().substring(0, 3)).toUpperCase());
	}

  
	@Id  
	@GeneratedValue
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public float getAsk() {
		return this.ask;
	}

	public void setAsk(float ask) {
		this.ask = ask;
	}   
	public float getBid() {
		return this.bid;
	}

	public void setBid(float bid) {
		this.bid = bid;
	}
	@ManyToOne(cascade = CascadeType.MERGE)
	public Currency getCurrency1() {
		return currency1;
	}
	public void setCurrency1(Currency currency1) {
		this.currency1 = currency1;
	}
	@ManyToOne(cascade = CascadeType.MERGE)
	public Currency getCurrency2() {
		return currency2;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Currencypairs other = (Currencypairs) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public void setCurrency2(Currency currency2) {
		this.currency2 = currency2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
   
}
