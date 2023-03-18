package com.hexagonal.application.ports.in;

import com.hexagonal.application.core.domain.Customer;

import java.util.UUID;

public interface FindCustomerByIdInputPort {
    Customer find(UUID id);
}
