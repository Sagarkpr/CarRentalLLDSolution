package com.lld.models;

import com.lld.models.enums.AccountType;

import java.util.UUID;

public class Account {
    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void setId(String id) {
        this.id = id;
    }

    String name;
    String number;
    AccountType accountType;
    String id;

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public String getId() {
        return id;
    }


    public Account(String name, String number,AccountType accountType, String id) {
        this.name = name;
        this.number = number;
        this.accountType = accountType;
        this.id = id;
    }

}
