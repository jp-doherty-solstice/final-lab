package com.doherty.accountservice.controllers;

import com.doherty.accountservice.entities.Address;
import com.doherty.accountservice.services.AccountService;
import com.doherty.accountservice.services.AddressService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.DataInput;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

    private Address address;

    private ObjectMapper mapper;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        address = createDummyAddress();
        mapper = new ObjectMapper();
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

    @Test
    public void addAddressForAccount_ReturnsValidAddress() throws Exception {
        when(accountController.addAddressForAccount(any(Long.class), any(Address.class)))
                .thenReturn(address);
        MvcResult result = mockMvc.perform(post("/accounts/5/address")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(address)))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Address responseAddress = mapper.readValue(content, Address.class);
        assertEquals(responseAddress.getStreet(), "20 Grace Road");
    }

    @Test
    public void addAddressForAccount_WithoutRequestBody_ReturnsStatus400() throws Exception {
        mockMvc.perform(post("/accounts/5/address"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getAddresses_ReturnsListOfAddresses() throws Exception {
        List<Address> addressList = new ArrayList<>();
        addressList.add(address);
        when(accountController.getAddresses(any(Long.class))).thenReturn(addressList);
        mockMvc.perform(get("/accounts/5/addresses"))
                .andExpect(status().isOk())
                .andReturn();
    }



}
