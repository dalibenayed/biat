package biat.services;

import java.util.List;

import javax.ejb.Local;

import biat.domain.Banque;
import biat.domain.Corporate;
import biat.domain.Trader;

@Local
public interface BanqueServiceLocal {
	public void addBanque(Banque banque);
	public void updateBanque(Banque banque);
	public void removeBanque(Banque banque);
	public Banque findBanquebyId(int id);
	public void aadTraderToBank(Banque banque,Trader trader);
	public void removeTraderFromBank(Banque banque,Trader trader);
	public List<Banque> findAllBanque();
	public List<Corporate> findCorporatebyBank(Banque banque);
	public List<Banque> TriBankbynbpoints();
}
