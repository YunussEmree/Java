package com.yunussemree.security.customer;

import java.util.List;

public interface ICustomerService {
    void createCustomer(Customer customer);

    List<Customer> findCustomerAll();

    void updateCustomer(Customer customer);

    void deleteCustomer(long customerId);
}
