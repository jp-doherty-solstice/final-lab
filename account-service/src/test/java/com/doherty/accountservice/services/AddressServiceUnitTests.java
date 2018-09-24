package com.doherty.accountservice.services;

import com.doherty.accountservice.entities.Address;
import com.doherty.accountservice.repository.AddressRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class AddressServiceUnitTests {

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressService addressService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAddressesForAccount_WithValidInput_ReturnsTheAddresses() {
        List<Address> addresses = createDummyAddressList();
        when(addressRepository.findAddressesForAccount(any(Long.class))).thenReturn(addresses);
        List<Address> foundAddressList = addressService.findAllAddressesForAccount(5L);
        assertEquals(foundAddressList.get(1).getCity(), "Nashville");
    }

    private List<Address> createDummyAddressList() {
        List<Address> addresses = new ArrayList<>();
        addresses.add(createDummyAddress("Chicago", "IL", "67547"));
        addresses.add(createDummyAddress("Nashville", "TN", "32547"));
        addresses.add(createDummyAddress("Las Vegas", "NV", "98547"));
        return addresses;
    }

    private Address createDummyAddress(String city, String state, String zip) {
        Address address = new Address();
        address.setCity(city);
        address.setState(state);
        address.setZipcode(zip);
        return address;
    }

}