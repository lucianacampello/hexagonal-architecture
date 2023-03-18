package com.hexagonal.adapters.out;

import com.hexagonal.adapters.out.repository.CustomerRepository;
import com.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.hexagonal.application.core.domain.Customer;
import com.hexagonal.application.ports.out.InsertCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InsertCustomerAdapter implements InsertCustomerOutputPort {
    private final CustomerRepository repository;
    private final CustomerEntityMapper mapper;

    @Override
    public void insert(Customer customer) {
        var customerEntity = mapper.toCustomerEntity(customer);
        repository.save(customerEntity);
    }
}
