package com.doherty.accountservice.services;

import com.doherty.accountservice.entities.Account;
import com.doherty.accountservice.entities.Address;
import com.doherty.accountservice.repository.AccountRepository;
import com.doherty.accountservice.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AddressRepository addressRepository;

    public Address addAddressForAccount(Long accountId, Address address) {
        Account account = accountRepository.getOne(accountId);
        address.setAccount(account);
        return addressRepository.save(address);
    }

}
