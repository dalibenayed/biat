package biat.services;

import java.util.List;

import javax.ejb.Remote;

import biat.domain.Currency;

@Remote
public interface CurrencyServiceRemote {
public void addcurrency(Currency currency);
public void removecurrency(Currency currency);
public Currency findcurrencybyid(int id);
public void updatecurrency(Currency currency);
public List<Currency>displayallCurrency();
}
