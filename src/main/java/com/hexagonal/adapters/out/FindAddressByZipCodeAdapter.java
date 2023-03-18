package com.hexagonal.adapters.out;

import com.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.hexagonal.application.core.domain.Address;
import com.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    private final FindAddressByZipCodeClient client;
    private final AddressResponseMapper mapper;

    @Override
    public Address find(String zipcode) {
        var addressResponse = client.find(zipcode);
        return mapper.toAddress(addressResponse);
    }
}
