package com.white.service;

import com.white.entity.Address;

import java.util.List;

public interface AddressService {

    void saveAddress(Address address);

    Address getAddress(Integer id);

    List<Address> getAllAddresses();

    void deleteAddress(Integer id);
}
