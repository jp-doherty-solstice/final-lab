package com.doherty.accountservice.controllers;

import com.doherty.accountservice.entities.Address;
import com.doherty.accountservice.services.AccountService;
import com.doherty.accountservice.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    AddressService addressService;

    @PostMapping("/accounts/{id}/address")
    public Address addAddressForAccount(@PathVariable long id, @RequestBody Address address) {
        return accountService.addAddressForAccount(id, address);
    }

    @GetMapping("/accounts/{id}/addresses")
    public List<Address> getAddresses(@PathVariable Long id) {
        return addressService.findAllAddressesForAccount(id);
    }

}
