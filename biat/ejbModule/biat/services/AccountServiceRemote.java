package biat.services;

import java.util.List;

import javax.ejb.Remote;

import biat.domain.Account;

@Remote
public interface AccountServiceRemote {
public void createAcount(Account account);
public void removeAccount(Account account);
public Account findAcountbyid(int id);
public void updateAccount(Account account);
public List<Account> displayallaccount();
}
