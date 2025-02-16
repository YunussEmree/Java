package com.yunussemree.security.security.user;

import com.yunussemree.security.customer.Customer;
import com.yunussemree.security.customer.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerDetailsService implements UserDetailsService {
    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = Optional.ofNullable(customerRepository.findByEmail(username))
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));
        return CustomerDetails.buildUserDetails(customer);
    }
}
