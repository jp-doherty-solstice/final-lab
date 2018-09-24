package com.doherty.accountservice.controllers;

import com.doherty.accountservice.entities.Address;
import com.doherty.accountservice.repository.AddressRepository;
import com.doherty.accountservice.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
    public Address getAddressById(@PathVariable Long id) {
        return addressService.get(id);
    }

}
