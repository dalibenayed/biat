package biat.services;

import java.util.List;

import javax.ejb.Remote;

import biat.domain.Banque;
import biat.domain.Corporate;
import biat.domain.Trader;

@Remote
public interface CorporateServiceRemote {
	public void addCorporate(Corporate corporate);
	public void updateBanque(Corporate corporate);
	public void removeBanque(Corporate corporate);
	public Corporate findCorporatebyId(int id);
	public List<Corporate> findAllCorporates();
	public void addcorporatetobank(Banque banque,Corporate corporate);
}
