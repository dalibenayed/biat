package client.biat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import biat.domain.Banque;
import biat.domain.Banque;
import biat.domain.BanqueCentrale;
import biat.domain.Custommer;
import biat.domain.Trader;
import biat.services.BanqueCentraleServiceRemote;
import biat.services.BanqueServiceRemote;

public class TestBanque {

	BanqueServiceRemote remote;
	BanqueCentraleServiceRemote remote1;

	@Before
	public void setUp() throws Exception {
		InitialContext ctx = new InitialContext();
		remote = (BanqueServiceRemote) ctx.lookup("/biat/BanqueService!biat.services.BanqueServiceRemote");

	}

	@Ignore
	public void testcreat() {
		Banque banque = new Banque();

		banque.setId(8);
		banque.setCapital(1);
		banque.setNom("AMEN");
		banque.setLogin("da");
		banque.setPwd("da");
		remote.addBanque(banque);

	} 

	@Ignore
	public void testupdate() {
		Banque banque = new Banque();
		banque = remote.findBanquebyId(50);
		banque.setNom("BIAT");
	    remote.updateBanque(banque);
		}

	@Ignore
	public void testRemove() {
		Banque Banque = new Banque();
		Banque = remote.findBanquebyId(15);
		remote.removeBanque(Banque);
	}
	@Test
	public void TestDisplay()
	{
    List< Banque>banques=new ArrayList<Banque>();
    banques=remote.TriBankbynbpoints();
    
    
	System.out.println("la liste est"+banques);
	
	}
	@Ignore
	public void testipdate()
	{
		Banque banque=remote.findBanquebyId(150);
		banque.setNom("UIB");
		remote.updateBanque(banque);
	}
	/*public void TestAlltraders()
	{
    List< Trader>traders=new ArrayList<Trader>();
    
	System.out.println("la liste est"+banques);
	}*/
}
