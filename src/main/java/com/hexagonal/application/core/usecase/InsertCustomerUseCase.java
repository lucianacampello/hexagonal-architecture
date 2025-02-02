package com.hexagonal.application.core.usecase;

import com.hexagonal.application.core.domain.Customer;
import com.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.hexagonal.application.ports.out.SendCpfForValidationOutputPort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InsertCustomerUseCase implements InsertCustomerInputPort {
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerOutputPort insertCustomerOutputPort;
    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
        sendCpfForValidationOutputPort.send(customer.getCpf());
    }
}
