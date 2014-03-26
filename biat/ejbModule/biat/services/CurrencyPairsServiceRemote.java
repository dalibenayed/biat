package biat.services;

import java.util.List;

import javax.ejb.Remote;

import biat.domain.Currencypairs;

@Remote
public interface CurrencyPairsServiceRemote {
public void addcurrencypairs(Currencypairs currencypairs);
public void removecurrencypairs(Currencypairs currencypairs);
public void updatecurrencypairs(Currencypairs currencypairs);
public Currencypairs findcurrencypairsbyId(int id);
public List <Currencypairs>displayallcurrencypairs();
public void createcurencypairs();
public void controleBIDASK(Currencypairs currencypairs ,float a);
}
