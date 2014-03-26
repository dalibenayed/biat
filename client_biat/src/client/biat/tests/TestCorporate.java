package client.biat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import biat.domain.Banque;
import biat.domain.Corporate;
import biat.domain.News;
import biat.services.BanqueServiceRemote;
import biat.services.CorporateServiceRemote;

public class TestCorporate {
	CorporateServiceRemote remote;
	BanqueServiceRemote remote1;

	@Before
	public void setUp() throws Exception {
		InitialContext ctx = new InitialContext();
		remote = (CorporateServiceRemote) ctx
				.lookup("ejb:/biat/CorporateService!biat.services.CorporateServiceRemote");
		remote1 = (BanqueServiceRemote) ctx
				.lookup("ejb:/biat/BanqueService!biat.services.BanqueServiceRemote");
	}

	@Ignore
	public void testaddcorporatetobank() {
		Corporate corporate = new Corporate();
		Banque banque = new Banque();
		banque.setId(50);
		remote1.addBanque(banque);
		corporate.setId(25);
		corporate.setCapital(150);
		corporate.setNom("polina");
		corporate.setBanque(banque);
		remote.addCorporate(corporate);
		remote.addcorporatetobank(banque, corporate);

	}

	@Test
	public void creatcorporate() {
		Corporate corporate = new Corporate();
		corporate.setId(22);
		corporate.setLogin("cor");
		corporate.setPwd("cor");
		remote.addCorporate(corporate);
	}

	@Test
	public void testAfficher() {
		List<Corporate> corporates = new ArrayList<>();
		corporates = remote.findAllCorporates();
		System.out.println("la liste est" + corporates);
	}
}
