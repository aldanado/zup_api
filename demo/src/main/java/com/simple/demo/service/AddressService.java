package com.simple.demo.service;

import java.util.List;
import java.util.Optional;

import com.simple.demo.dao.AddressDao;
import com.simple.demo.model.Address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private final AddressDao addressDAO;

    @Autowired
    public AddressService(@Qualifier("addressTest") AddressDao addressDAO){
        this.addressDAO = addressDAO;
    }

    public int addUser(Address address){
        return addressDAO.insertAddress(address);
    }

    public List<Address> getAllAddresses(String cpf){
        return addressDAO.selectAllAddresses(cpf);
    }

    public List<Address> getAllAddresses(){
        return addressDAO.selectAllAddresses();
    }

    public Optional<Address> getUser(String cpf, String cep){
        return addressDAO.selectAddressAndCEP(cpf, cep);
    }

    public int deleteAddress(String cpf, Address address){
        return addressDAO.deleteAddress(cpf, address);
    }

    public int updateAddress(String cpf, Address address){
        return addressDAO.updateAddress(cpf, address);
    }
}
