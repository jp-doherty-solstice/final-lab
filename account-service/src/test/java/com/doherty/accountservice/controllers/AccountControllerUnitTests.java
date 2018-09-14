package com.doherty.accountservice.controllers;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerUnitTests {

    @Autowired
    private MockMvc mockMvc;

//    @Mock
//    AccountRepository accountRepository;
//
//    @Mock
//    AddressRepository addressRepository;

    @InjectMocks
    AccountController accountController;

//    public Address address;
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//        address = new Address();
//        address.setStreet("Mystic");
//        address.setApt("1B");
//        address.setCity("Bedford");
//        address.setState("IL");
//        address.setZipcode("76859");
//        address.setCountry("USA");
//    }





}
