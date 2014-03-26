package biat.services;

import java.util.List;

import javax.ejb.Remote;

import biat.domain.Banque;
import biat.domain.Corporate;
import biat.domain.Trader;

@Remote
public interface BanqueServiceRemote {
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
