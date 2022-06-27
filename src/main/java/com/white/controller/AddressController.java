package com.white.controller;

import com.white.entity.Address;
import com.white.entity.Patient;
import com.white.service.AddressService;
import com.white.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable("id") Integer id) {
        ResponseEntity response = null;
        Address address = addressService.getAddress(id);
        if (address != null) {
            response = new ResponseEntity(address, HttpStatus.OK);
        } else {
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    @PostMapping("/new")
    public ResponseEntity<Address> addAddress(@RequestBody Address address) {
        addressService.saveAddress(address);
        return new ResponseEntity(address, HttpStatus.CREATED);
    }
}
