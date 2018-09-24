package com.doherty.accountservice.services;

import com.doherty.accountservice.entities.Address;
import com.doherty.accountservice.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public List<Address> findAllAddressesForAccount(Long accountId) {
        return addressRepository.findAddressesForAccount(accountId);
    }

    public Address get(Long id) {
        return addressRepository.findById(id).get();
    }

}
