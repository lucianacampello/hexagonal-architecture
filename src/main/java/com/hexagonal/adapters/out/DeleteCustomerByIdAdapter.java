package com.hexagonal.adapters.out;

import com.hexagonal.adapters.out.repository.CustomerRepository;
import com.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {
    private final  CustomerRepository repository;

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
