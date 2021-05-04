package com.simple.demo.dao;

import java.util.List;
import java.util.Optional;

import com.simple.demo.model.Address;

public interface AddressDao {
    
    int insertAddress(Address address); 

    Optional<Address> selectAddressAndCEP(String cpf, String cep);

    List<Address> selectAllAddresses(String cpf);
    
    List<Address> selectAllAddresses();

    int deleteAddress(String cpf, Address address);

    int updateAddress(String cpf, Address address);
}
