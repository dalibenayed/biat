package com.esprit.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import biat.domain.Banque;
import biat.domain.BanqueCentrale;
import biat.services.BanqueCentraleServiceLocal;
import biat.services.BanqueServiceLocal;
@ManagedBean
public class BanqueCentraleBean implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private BanqueCentrale banqueCentrale=new BanqueCentrale();
	private List<Banque>banques=new ArrayList<Banque>();
	private Banque banque= new Banque();
	@EJB
	private BanqueCentraleServiceLocal service;
	private BanqueServiceLocal serice1;
	
	public String createbanque() {
		service.createBanqueCentrale(banqueCentrale);
		return "/index";
	}
	
	public List<Banque> BanksTriees()
	{
		return banques=serice1.TriBankbynbpoints();	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public BanqueCentrale getBanqueCentrale() {
		return banqueCentrale;
	}
	public void setBanqueCentrale(BanqueCentrale banqueCentrale) {
		this.banqueCentrale = banqueCentrale;
	}
















	public BanqueServiceLocal getSerice1() {
		return serice1;
	}
















	public void setSerice1(BanqueServiceLocal serice1) {
		this.serice1 = serice1;
	}
















	public List<Banque> getBanques() {
		return banques;
	}
















	public void setBanques(List<Banque> banques) {
		this.banques = banques;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

}
