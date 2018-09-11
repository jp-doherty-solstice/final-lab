package com.doherty.accountservice.controller;

import com.doherty.accountservice.controller.AccountController;
import com.doherty.accountservice.entity.Address;
import com.doherty.accountservice.repository.AccountRepository;
import com.doherty.accountservice.repository.AddressRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    AccountRepository accountRepository;

    @Mock
    AddressRepository addressRepository;

    @InjectMocks
    AccountController accountController;

    public Address address;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        address = new Address();
        address.setStreet("Mystic");
        address.setApt("1B");
        address.setCity("Bedford");
        address.setState("IL");
        address.setZipcode("76859");
        address.setCountry("USA");
    }

    @Test
    public void testRead() throws Exception {

    }

}
