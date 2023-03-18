package com.hexagonal.application.core.usecase;

import com.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInputPort {
    private final FindCustomerByIdInputPort findCustomerByIdInputPort;
    private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

    @Override
    public void delete(final UUID id) {
        findCustomerByIdInputPort.find(id);
        deleteCustomerByIdOutputPort.delete(id);
    }
}
