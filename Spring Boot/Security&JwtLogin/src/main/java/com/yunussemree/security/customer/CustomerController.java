package com.yunussemree.security.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/createCustomer")
    public ResponseEntity<Void> createCustomer(@RequestBody Customer customer) {

        if (Objects.isNull(customer)) {
            throw new NullPointerException("Customer cannot be null");
        }
        customerService.createCustomer(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/customerAll")
    public ResponseEntity<List<Customer>> findCustomerAll() {
        List<Customer> customerAll = customerService.findCustomerAll();
        return new ResponseEntity<>(customerAll, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/updateCustomer")
    public ResponseEntity<Void> updateCustomer(@RequestBody Customer customer) {
        if (Objects.isNull(customer)) {
            throw new NullPointerException("Customer cannot be null");
        }
        customerService.updateCustomer(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/deleteCustomer/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable long customerId) {
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
