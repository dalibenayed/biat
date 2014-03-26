package biat.services;

import java.util.List;

import javax.ejb.Local;

import biat.domain.Currency;

@Local
public interface CurrencyServiceLocal {
	
		public void addcurrency(Currency currency);
		public void removecurrency(Currency currency);
		public Currency findcurrencybyid(int id);
		public void updatecurrency(Currency currency);
		public List<Currency>displayallCurrency();
		
}
