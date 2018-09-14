package com.doherty.accountservice.repository;

import com.doherty.accountservice.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query("select a from Address a where a.account.accountId = ?1")
    List<Address> findAddressesForAccount(Long id);

}