package com.lld.models;

import com.lld.models.enums.AccountType;
import com.lld.models.enums.VehicleType;
import com.lld.providers.CarRentalService;

public class AdminAccount extends Account{

    public AdminAccount(String name, String number,String id) {
        super(name, number, AccountType.ADMIN, id);
    }
}
