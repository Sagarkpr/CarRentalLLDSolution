package com.lld.models;

import com.lld.models.enums.AccountType;

public class CustomerAccount extends Account{
    public CustomerAccount(String name, String number, String id) {
        super(name, number, AccountType.CUSTOMER,id);
    }
}
