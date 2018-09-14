package com.doherty.accountservice.services;

import com.doherty.accountservice.entities.Account;
import com.doherty.accountservice.entities.Address;
import com.doherty.accountservice.repository.AccountRepository;
import com.doherty.accountservice.repository.AddressRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class AccountServiceUnitTests {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AccountService accountService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addAddressForAccount_WithValidData_AddsTheAddress() {
        Account account = createDummyAccount();
        when(accountRepository.getOne(any(Long.class))).thenReturn(account);
        Address address = createDummyAddress();
        when(addressRepository.save(any(Address.class))).thenReturn(address);
        Address newAddress = accountService.addAddressForAccount(5L, address);
        assertEquals(newAddress.getCity(), "Panhandle");
    }

    private Account createDummyAccount() {
        Account account = new Account();
        account.setEmailAddress("anothertest@account.com");
        account.setFirstName("John");
        account.setLastName("Stevens");
        account.setAccountId(5);
        return account;
    }

    private Address createDummyAddress() {
        Address address = new Address();
        address.setStreet("24 Target AVe");
        address.setApt("2F");
        address.setCity("Panhandle");
        address.setState("IL");
        address.setZipcode("60543");
        address.setCountry("USA");
        return address;
    }

}