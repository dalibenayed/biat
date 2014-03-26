package biat.services;

import java.util.List;

import javax.ejb.Remote;

import biat.domain.BanqueCentrale;
import biat.domain.News;

@Remote
public interface BanqueCentraleServiceRemote {
public void createBanqueCentrale(BanqueCentrale banqueCentraleService);
public void updateBanqueCentrale(BanqueCentrale banqueCentrale);
public void removeBanqueCentrale(BanqueCentrale banqueCentrale); 
public BanqueCentrale findBanqueCentralebyid(int id);
public void publishInformation(BanqueCentrale banqueCentrale,News news);
public List<BanqueCentrale>DisplayAllCentrallBank();
}
