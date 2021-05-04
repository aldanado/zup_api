package com.simple.demo.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.simple.demo.model.Address;
import com.simple.demo.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/address")
@RestController
public class AddressController {
    
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @PostMapping
    public void insertUser(@Valid  @NotNull @RequestBody Address address){
        addressService.addUser(address);
    }

    @GetMapping
    public List<Address> getAllAddresses(){
        return addressService.getAllAddresses();
    }

    @GetMapping(path = "{cpf}")
    public List<Address> getAllAddresses(@PathVariable("cpf") String cpf){
        return addressService.getAllAddresses(cpf);
    }

    @DeleteMapping(path = "{cpf}")
    public void deleteAddress(@PathVariable("cpf") String cpf, @Valid  @NotNull @RequestBody Address address){
        addressService.deleteAddress(cpf, address);
    }

    @PutMapping(path = "{cpf}")
    public int updatUser(@PathVariable("cpf") String cpf, @Valid @NotNull @RequestBody Address address){
        return addressService.updateAddress(cpf, address);
    } 

}
