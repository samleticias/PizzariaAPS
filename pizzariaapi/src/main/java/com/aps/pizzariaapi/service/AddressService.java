package com.aps.pizzariaapi.service;

import com.aps.pizzariaapi.entity.Address;
import com.aps.pizzariaapi.repository.AddressRepository;
import com.aps.pizzariaapi.service.exception.AddressNotFound;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address createAddress(Address address) {
        this.addressRepository.save(address);
        return address;
    }

    public Address findById(Long id) throws AddressNotFound {
        Optional<Address> optionalAddress = this.addressRepository.findById(id);
        return optionalAddress.orElseThrow(() -> new AddressNotFound("Address not found"));
    }
}
