package biat.services;

import javax.ejb.Remote;

import biat.domain.Custommer;

@Remote
public interface CusommerServiceRemote {
public Custommer CustommerAuthentification(String log,String pwd);
}
