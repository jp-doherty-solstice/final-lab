package com.doherty.accountservice.controllers;

import com.doherty.accountservice.entity.Address;
import com.doherty.accountservice.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class AddressController {

    @Autowired
    AddressRepository addressRepository;

    @RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
    public Optional<Address> getAddressById(@PathVariable Long id) {
        return addressRepository.findById(id);
    }

}
