package com.racket.commons.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.core.style.ToStringCreator;

import com.baldy.commons.security.models.Account;


/**
 * User
 * @author mbmartinez
 */
@Entity
@Table(name = Racketeer.table)
public class Racketeer {

    public static final String table = "racketeer";

    @Id @GeneratedValue
    private long id;

    @OneToOne(optional = false)
    private Account account;

    @OneToOne(cascade=CascadeType.ALL)
    private AccountInfo accountInfo;

    public String toString() {
    	return new ToStringCreator(this)
    		.append("id", id)
    		.append("account", account)
    		.append("accountInfo", accountInfo)
    		.toString();
    }
    
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(AccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
