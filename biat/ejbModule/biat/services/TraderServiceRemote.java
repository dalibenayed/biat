package biat.services;

import java.util.List;

import javax.ejb.Remote;

import biat.domain.Banque;
import biat.domain.Trader;

@Remote
public interface TraderServiceRemote {
	public void addTrader(Trader trader);
	public void updateBanque(Trader trader);
	public void removeBanque(Trader trader);
	public Trader findTraderbyId(int id);
	public List<Trader> displayalltrader();
	
}
