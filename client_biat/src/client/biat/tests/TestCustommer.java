package client.biat.tests;

import static org.junit.Assert.*;

import javax.naming.InitialContext;

import org.junit.Before;
import org.junit.Test;

import biat.domain.Banque;
import biat.domain.BanqueCentrale;
import biat.domain.Corporate;
import biat.domain.Custommer;
import biat.services.CusommerServiceRemote;

public class TestCustommer {
	CusommerServiceRemote remote;
	@Before
	
	public void setUp() throws Exception {
		InitialContext ctx= new InitialContext();
		remote=(CusommerServiceRemote) ctx.lookup("ejb:/biat/CusommerService!biat.services.CusommerServiceRemote");
	}

	@Test
	public void test() {
Custommer a=  remote.CustommerAuthentification("cor", "cor");
if(a==null){System.out.println("erreur");
}
 if(a  instanceof Banque) {
	
	System.out.println("Connexion banque réussite");
}
 else  if(a  instanceof BanqueCentrale) {
		
	System.out.println("Connexion banque centrale  réussite");
}
 else  if(a  instanceof Corporate) {
		
	System.out.println("Connexion corporate réussite");
}
 else
{
	System.out.println("erreur");
}
	}

}
