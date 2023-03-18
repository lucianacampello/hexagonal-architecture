package com.hexagonal.adapters.out;

import com.hexagonal.adapters.out.repository.CustomerRepository;
import com.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.hexagonal.application.core.domain.Customer;
import com.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {
    private final CustomerRepository repository;
    private final CustomerEntityMapper mapper;

    @Override
    public void update(Customer customer) {
        var customerEntity = mapper.toCustomerEntity(customer);
        repository.save(customerEntity);
    }
}
