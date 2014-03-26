package client.biat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import biat.domain.Banque;
import biat.domain.BanqueCentrale;
import biat.domain.Corporate;
import biat.domain.News;
import biat.services.BanqueCentraleServiceRemote;
import biat.services.NewsServiceRemoteRemote;

public class TestBanqueCentrale {
   BanqueCentraleServiceRemote remote;
   NewsServiceRemoteRemote remote1;
	@Before
	public void setUp() throws Exception {
		InitialContext ctx = new InitialContext();
		remote=(BanqueCentraleServiceRemote) ctx.lookup("ejb:/biat/BanqueCentraleService!biat.services.BanqueCentraleServiceRemote");
		remote1=(NewsServiceRemoteRemote) ctx.lookup("ejb:/biat/NewsServiceRemote!biat.services.NewsServiceRemoteRemote");
	}

	@Test
	public void addcentralBank() {
		BanqueCentrale banqueCentrale = new BanqueCentrale();
		banqueCentrale.setId(80);
		banqueCentrale.setMon_loc("euro");
		remote.createBanqueCentrale(banqueCentrale);

	}
	@Ignore
	public void testRemove() {
	BanqueCentrale banqueCentrale = new BanqueCentrale();
		banqueCentrale = remote.findBanqueCentralebyid(1200);
		remote.removeBanqueCentrale(banqueCentrale);
	}
	@Ignore
	public void tetsterPublication()
	{
		BanqueCentrale banqueCentrale =new BanqueCentrale();
		banqueCentrale.setId(100);
		banqueCentrale.setLogin("hhh");
		remote.createBanqueCentrale(banqueCentrale);
		News news=new News();
		news.setId(100);
		news.setContenu("dali");
		remote1.createNews(news);
		remote.publishInformation(banqueCentrale, news);
		
		
	}
	@Ignore
	public void testAfficher()
	{
		List<BanqueCentrale>corporates= new ArrayList<>();
		corporates=remote.DisplayAllCentrallBank();
		System.out.println("la liste est"+corporates);
	}
	@Ignore
	public void removebebankcentral()
	{
		BanqueCentrale banqueCentrale=remote.findBanqueCentralebyid(100);
		remote.removeBanqueCentrale(banqueCentrale);
	}
	

}
