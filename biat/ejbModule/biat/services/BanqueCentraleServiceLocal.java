package biat.services;

import java.util.List;

import javax.ejb.Local;

import biat.domain.BanqueCentrale;
import biat.domain.News;

@Local
public interface BanqueCentraleServiceLocal {
	public void createBanqueCentrale(BanqueCentrale banqueCentraleService);
	public void updateBanqueCentrale(BanqueCentrale banqueCentrale);
	public void removeBanqueCentrale(BanqueCentrale banqueCentrale); 
	public BanqueCentrale findBanqueCentralebyid(int id);
	public void publishInformation(BanqueCentrale banqueCentrale,News news);
	public List<BanqueCentrale>DisplayAllCentrallBank();
}
