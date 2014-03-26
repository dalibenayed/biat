package client.biat.tests;

import static org.junit.Assert.*;

import javax.naming.InitialContext;

import org.junit.Before;
import org.junit.Test;

import biat.domain.Account;
import biat.services.AccountServiceRemote;

public class TestAccount {
AccountServiceRemote remote;
	@Before
	public void setUp() throws Exception {
		InitialContext ctx = new InitialContext();
		remote=(AccountServiceRemote) ctx.lookup("ejb:/biat/AccountService!biat.services.AccountServiceRemote");
	}

	@Test
	public void testcreat() {
	Account account=new Account();
	account.setId(10);
	account.setNom("compte_biat");
	
	remote.createAcount(account);
	}

}
