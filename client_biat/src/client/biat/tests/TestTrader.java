package client.biat.tests;

import static org.junit.Assert.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import biat.domain.Banque;
import biat.domain.News;
import biat.domain.Trader;
import biat.services.BanqueServiceRemote;
import biat.services.TraderServiceRemote;

public class TestTrader {
	/**
	 * 
	 */
	TraderServiceRemote remote;
	BanqueServiceRemote remote1;

	@Before
	public void setUp() throws Exception {
		InitialContext ctx = new InitialContext();
		remote1 = (BanqueServiceRemote) ctx
				.lookup("ejb:/biat/BanqueService!biat.services.BanqueServiceRemote");
		remote = (TraderServiceRemote) ctx
				.lookup("ejb:/biat/TraderService!biat.services.TraderServiceRemote");
	}

	@Test
	public void testcreat() {

		Trader trader = new Trader();
		trader.setId(150);
		trader.setNom("dali");
		remote.addTrader(trader);

		Banque banque = new Banque();
		banque.setId(150);
		banque.setNom("BIAT");
		remote1.addBanque(banque);
		remote1.aadTraderToBank(banque, trader);
	}

	@Ignore
	public void TestAddTradertobank() {
		Banque banque = new Banque();
		Trader trader = new Trader();
		banque.setId(89);
		banque.setCapital(5);
		banque.setNom("uib");
		remote1.addBanque(banque);
		trader.setId(71);
		trader.setNom("dali1");
		remote.addTrader(trader);
		remote1.aadTraderToBank(banque, trader);
		// remote1.removeTraderFromBank(banque, trader);
	}

	@Ignore
	public void TestRemoveTarderFromBank() {
		Banque banque = remote1.findBanquebyId(150);
		Trader trader = remote.findTraderbyId(150);
		remote1.removeTraderFromBank(banque, trader);
	}

	@Ignore
	public void testafficher() {

		List<Trader> corporates = new ArrayList<>();
		corporates = remote.displayalltrader();
		System.out.println("la liste est" + corporates);
	}
	@Ignore
	
	public void testupdatetrader()
	{
		Trader trader=remote.findTraderbyId(70);
		trader.setNom("dali3");
		remote.updateBanque(trader);
	}

}
