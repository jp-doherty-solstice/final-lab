package com.doherty.accountservice.repository;

import com.doherty.accountservice.entities.Account;
import com.doherty.accountservice.entities.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AddressRepositoryIntegrationTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void whenFindAddressesForAccount_ForValidAccount_ThenReturnAddresses() {

        Account account = createDummyAccount();
        entityManager.persist(account);
        entityManager.flush();
        Long id = account.getAccountId();

        Address address = createDummyAddress();
        address.setAccount(account);
        entityManager.persist(address);
        entityManager.flush();

        List<Address> foundAddresses = addressRepository.findAddressesForAccount(id);

        assertThat(foundAddresses.get(0).getCity()).isEqualTo("Lombard");
    }

    private Address createDummyAddress() {
        Address address = new Address();
        address.setStreet("45 Mystic St");
        address.setApt("2C");
        address.setCity("Lombard");
        address.setState("IL");
        address.setZipcode("60543");
        address.setCountry("USA");
        return address;
    }

    private Account createDummyAccount() {
        Account account = new Account();
        account.setEmailAddress("test@account.com");
        account.setFirstName("Jim");
        account.setLastName("Smith");
        return account;
    }

}