package com.doherty.accountservice.controllers;

import com.doherty.accountservice.entities.Address;
import com.doherty.accountservice.services.AccountService;
import com.doherty.accountservice.services.AddressService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerUnitTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    AccountService accountService;

    @MockBean
    AddressService addressService;

    @InjectMocks
    AccountController accountController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addAddressForAccount_ReturnsValidAddress() throws Exception {

        Address address = createDummyAddress();

        when(accountController.addAddressForAccount(any(Long.class), any(Address.class)))
                .thenReturn(address);

        mockMvc.perform(post("/accounts/5/address", address))
                .andExpect(status().isOk())
                .andExpect(model().attribute("state", "MA"))
                .andReturn();
    }

    private Address createDummyAddress() {
        Address address = new Address();
        address.setStreet("20 Grace Road");
        address.setApt("C4");
        address.setCity("Oak Brook");
        address.setState("MA");
        address.setZipcode("02543");
        address.setCountry("USA");
        return address;
    }



}
