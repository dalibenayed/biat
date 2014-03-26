package client.biat.tests;

import static org.junit.Assert.*;

import javax.naming.InitialContext;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import biat.domain.Currency;
import biat.domain.Currencypairs;
import biat.services.CurrencyPairsServiceRemote;
import biat.services.CurrencyServiceRemote;

public class TestCurrencypairs {
CurrencyPairsServiceRemote remote;
CurrencyServiceRemote remote1;
	@Before
	public void setUp() throws Exception {
		InitialContext ctx = new InitialContext();
		                         remote1=   (CurrencyServiceRemote) ctx.lookup("ejb:/biat/CurrencyService!biat.services.CurrencyServiceRemote");
			remote=	(CurrencyPairsServiceRemote) ctx.lookup("ejb:/biat/CurrencyPairsService!biat.services.CurrencyPairsServiceRemote");
	}


	@Ignore
	public void createcurrencypairs() {
	Currency currency1= new Currency();
    Currency currency2= new Currency();
    Currencypairs currencypairs=new Currencypairs();
    
    currency1.setId(105);
    currency1.setNom("TNUISIEN");
    currency2.setId(200);
    currency2.setNom("dolaaar");
    remote1.addcurrency(currency1);
    remote1.addcurrency(currency2);
    
    currencypairs.setCurrency1(currency1);
    currencypairs.setCurrency2(currency2);
    currencypairs.init();
    remote.addcurrencypairs(currencypairs);
    
	}
@Test
public void testcreationautomatiquedepairsdedevise()
{
	remote.createcurencypairs();
	
}
@Ignore
public void testratio()
{
	Currencypairs currencypairs=new Currencypairs();
	currencypairs.setAsk(10);
	currencypairs.setBid(8);
	remote.addcurrencypairs(currencypairs);
	remote.controleBIDASK(currencypairs,3);
	
}
}
