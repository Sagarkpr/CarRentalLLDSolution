package com.lld.providers;

import com.lld.models.Account;
import com.lld.models.AdminAccount;
import com.lld.models.CustomerAccount;
import com.lld.models.enums.AccountType;

import java.util.HashMap;
import java.util.UUID;

public class UserService {
    HashMap<String, Account> userAccounts;
    public UserService() {
        this.userAccounts = new HashMap<>();
    }
    public String addAccount(String name, String number, AccountType accountType) throws Exception {
        Account account;
        switch (accountType){
            case ADMIN:
                account=new AdminAccount(name, number, UUID.randomUUID().toString());
                userAccounts.put(account.getId(), account);
                return account.getId();
            case CUSTOMER:
                account=new CustomerAccount(name, number, UUID.randomUUID().toString());
                userAccounts.put(account.getId(), account);
                return account.getId();
            default:
                throw new Exception("Invalid AccountType");
        }

    }
}
