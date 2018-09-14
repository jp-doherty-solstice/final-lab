package com.doherty.accountservice.services;

import com.doherty.accountservice.repository.AddressRepository;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class AddressServiceUnitTests {

    @Mock
    private AddressRepository addressRepository;

}