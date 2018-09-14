package com.doherty.accountservice.controllers;

import com.doherty.accountservice.entity.Account;
import com.doherty.accountservice.entity.Address;
import com.doherty.accountservice.repository.AccountRepository;
import com.doherty.accountservice.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AddressRepository addressRepository;

    @PostMapping("/accounts/{id}/address")
    public void addAddressForAccount(@PathVariable long id, @RequestBody Address address) {
        addNewAddress(id, address);
    }

    private void addNewAddress(@PathVariable long id, @RequestBody Address address) {
        Account account = accountRepository.getOne(id);
        address.setAccount(account);
        addressRepository.save(address);
    }

    @GetMapping("/accounts/{id}/addresses")
    public List<Address> getAddresses(@PathVariable Long id) {
        return addressRepository.findAddressesForAccount(id);
    }

}
