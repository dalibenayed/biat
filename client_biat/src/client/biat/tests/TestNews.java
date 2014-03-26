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
import biat.domain.Trader;
import biat.services.BanqueCentraleServiceRemote;
import biat.services.NewsServiceRemoteRemote;

public class TestNews {
NewsServiceRemoteRemote remote;
BanqueCentraleServiceRemote remote1;
	@Before
	public void setUp() throws Exception {
		InitialContext ctx =new InitialContext();
		remote1=(BanqueCentraleServiceRemote) ctx.lookup("ejb:/biat/BanqueCentraleService!biat.services.BanqueCentraleServiceRemote");
		remote=(NewsServiceRemoteRemote) ctx.lookup("ejb:/biat/NewsServiceRemote!biat.services.NewsServiceRemoteRemote");
	}

	@Test
	public void test() {
News news=new News();
news.setId(20);
news.setContenu("dddd");
remote.createNews(news);
	}
	@Ignore
	public  void testajout()
	{
		BanqueCentrale banque = new BanqueCentrale() ;
		News news=new News();
		banque.setId(10);
		banque.setCapital(2);
		//banque.getNews().add();
	/*	remote1.createBanqueCentrale(banque);
		news.setId(50);
		news.setContenu("hhhhhh");
		remote.createNews(news);
		remote1.publishInformation(banque, news);*/
		
	}
	@Test
	public void testAfficher()
	{
		List<News>corporates= new ArrayList<>();
		corporates=remote.DisplayAllNews();
		System.out.println("la liste est"+corporates);
	}

}
