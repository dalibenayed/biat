package biat.domain;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Custommer
 * 
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "t_Custommer")
public class Custommer implements Serializable {

	private int id;
	private String login;
	private String pwd;
	private Account account;
	private static final long serialVersionUID = 1L;

	public Custommer() {
		super();
	}

	@Id
	@GeneratedValue
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@OneToOne
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
