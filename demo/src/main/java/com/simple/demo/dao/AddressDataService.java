package com.simple.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.simple.demo.model.Address;

import org.springframework.stereotype.Repository;

@Repository("addressTest")
public class AddressDataService implements AddressDao {
    
    private static List<Address> DB = new ArrayList<>();

    @Override
    public int insertAddress(Address address) {
        DB.add(address);
        return 1;
    }

    @Override
    public Optional<Address> selectAddressAndCEP(String cpf, String cep) {
        return DB.stream()
        .filter(address -> (address.getCPF().equals(cpf) && address.getCEP().equals(cep)))
        .findFirst();
    }
    
    @Override
    public List<Address> selectAllAddresses(String cpf) {
        return DB.stream()
        .filter(address -> address.getCPF().equals(cpf))
        .collect(Collectors.toList());
    }

    @Override
    public List<Address> selectAllAddresses() {
        return DB;
    }

    @Override
    public int deleteAddress(String cpf, Address address) {
        Optional<Address> addressToDelete = selectAddressAndCEP(cpf, address.getCEP());
        if (addressToDelete.isEmpty()){
            return 0;
        }
        DB.remove(addressToDelete.get());
        return 1;
    }

    @Override
    public int updateAddress(String cpf, Address address) {
        return selectAddressAndCEP(cpf, address.getCEP()).map(addressToUpdate -> {
            int addressIndexToUpdate = DB.indexOf(addressToUpdate);
            if (addressIndexToUpdate >= 0){
                DB.set(addressIndexToUpdate, new Address(address.getBairro(),
                                                         cpf, 
                                                         address.getCEP(),
                                                         address.getCidade(),
                                                         address.getComplemento(),
                                                         address.getEstado(),
                                                         address.getLogradouro(),
                                                         address.getNumero()
                                                         ));
                return 1;
            }
            return 0;
}).orElse(-1);
    }
}
