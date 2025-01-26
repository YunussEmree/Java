package com.yunussemree.security.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {

    private final CustomerRepository customerRepository;

    public void createCustomer(Customer customer) {
        Optional<Customer> customerRepositoryById = customerRepository.findById(customer.getId());
        if (Objects.equals(customerRepositoryById, customer.getId()) || customerRepositoryById.get().getId() == customer.getId()) {
            throw new DuplicateKeyException("MULTIPLE CUSTOMERS AVAILABLE ");
        }

        customerRepository.save(customer);
    }

    public List<Customer> findCustomerAll() {
        return customerRepository.findAll();
    }

    public void updateCustomer(Customer customer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customer.getId());
        if (optionalCustomer.isEmpty()){
            throw  new NullPointerException();
        }
        customerRepository.save(customer);
    }

    public void deleteCustomer(long customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isEmpty()){
            throw  new NullPointerException();
        }
        customerRepository.deleteById(customerId);
    }


}
