package com.hexagonal.adapters.out;

import com.hexagonal.adapters.out.repository.CustomerRepository;
import com.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.hexagonal.application.core.domain.Customer;
import com.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {
    private final CustomerRepository repository;
    private final CustomerEntityMapper mapper;

    @Override
    public Optional<Customer> find(String id) {
        return  repository.findById(id)
                .map(mapper::toCustomer);
    }
}
