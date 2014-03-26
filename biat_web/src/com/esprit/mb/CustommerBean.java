package com.esprit.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.convert.FacesConverter;
import javax.faces.model.SelectItem;

import biat.domain.Banque;
import biat.domain.BanqueCentrale;
import biat.domain.Custommer;
import biat.services.BanqueCentraleServiceLocal;
import biat.services.BanqueServiceLocal;

@FacesConverter(forClass=CustommerBean.class)

@ManagedBean
@RequestScoped
public class CustommerBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Banque banque = new Banque();
	private BanqueCentrale banqueCentrale ;
	private List<BanqueCentrale> banqueCentrales ;
	private List<SelectItem>selectItems;
	private List<Banque> banques;
	@EJB
	private BanqueServiceLocal service;
	private BanqueCentraleServiceLocal service1;

	public String createbanque() {
		service.addBanque(banque);
		return "/index";
	}
public List<BanqueCentrale> displayAldlBC()
{
	return banqueCentrales=service1.DisplayAllCentrallBank();
	
}
public void onerowselect(){
	
}
public List<Banque> displayAldlB()
{
	return banques=service.findAllBanque();
	
}
public List<Banque> displayBanksTriee()
{
	return banques=service.TriBankbynbpoints();
	
}
	public CustommerBean() {
		 banqueCentrales= new ArrayList<BanqueCentrale>();
	     banqueCentrale = new BanqueCentrale();
		
		  
}
	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	public List<BanqueCentrale> getBanqueCentrales() {
		return banqueCentrales;
	}

	public void setBanqueCentrales(List<BanqueCentrale> banqueCentrales) {
		this.banqueCentrales = banqueCentrales;
	}
	public BanqueCentrale getBanqueCentrale() {
		return banqueCentrale;
	}
	public void setBanqueCentrale(BanqueCentrale banqueCentrale) {
		this.banqueCentrale = banqueCentrale;
	}
	public List<SelectItem> getSelectItems() {
		return selectItems;
	}
	public void setSelectItems(List<SelectItem> selectItems) {
		this.selectItems = selectItems;
	}
	public List<Banque> getBanques() {
		return banques;
	}
	public void setBanques(List<Banque> banques) {
		this.banques = banques;
	}

}
