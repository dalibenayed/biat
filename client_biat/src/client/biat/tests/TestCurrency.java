package client.biat.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import biat.domain.Corporate;
import biat.domain.Currency;
import biat.services.CurrencyServiceRemote;



public class TestCurrency {
CurrencyServiceRemote remote;
	@Before
	public void setUp() throws Exception {
		InitialContext ctx = new InitialContext();
	remote=	(CurrencyServiceRemote) ctx.lookup("ejb:/biat/CurrencyService!biat.services.CurrencyServiceRemote");
	}

	@Test
	public void testcreatCurrency() {
		Currency currency= new Currency();
		currency.setId(12);
		currency.setNom("yan");
		remote.addcurrency(currency);
	}
	@Ignore
	public void testdeletecurrency()
	{
		Currency currency=remote.findcurrencybyid(2);
		remote.removecurrency(currency);
	}
	@Ignore
	public void testeraffichage()
	{
		List<Currency>corporates= new ArrayList<>();
		corporates=remote.displayallCurrency();
		System.out.println("la liste est"+corporates);
	}
	@Ignore
	public void updatecurrency()
	{
		Currency currency=remote.findcurrencybyid(3);
		currency.setNom("yan");
		remote.updatecurrency(currency);
	}
	
	
	

}
