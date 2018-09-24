package com.doherty.accountservice.controllers;

import com.doherty.accountservice.entities.Address;
import com.doherty.accountservice.services.AddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AddressController.class)
public class AddressControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    AddressService addressService;

    @InjectMocks
    AddressController addressController;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAddressById_ReturnsAddress() throws Exception {
        Address address = createDummyAddress();
        ObjectMapper mapper = new ObjectMapper();
        when(addressController.getAddressById(any(Long.class))).thenReturn(address);
        MvcResult result = mockMvc.perform(get("/address/5"))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        Address responseAddress = mapper.readValue(content, Address.class);
        assertEquals(responseAddress.getStreet(), "33 Bird Street");
    }

    private Address createDummyAddress() {
        Address address = new Address();
        address.setStreet("33 Bird Street");
        address.setApt("1C");
        address.setCity("Glenbard");
        address.setState("OK");
        address.setZipcode("02543");
        address.setCountry("USA");
        return address;
    }

}