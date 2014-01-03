package com.racket.commons.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.baldy.commons.security.models.Account;



/**
 * User
 * @author mbmartinez
 */
@Entity
@Table(name = Racketeer.table)
public class Racketeer {

    public static final String table = "racketeer";
    
    @Column
    private Account account;

    @OneToOne(cascade=CascadeType.ALL)
    private AccountInfo accountInfo;

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

}
