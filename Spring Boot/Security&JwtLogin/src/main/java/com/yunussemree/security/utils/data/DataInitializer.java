package com.yunussemree.security.utils.data;


import com.yunussemree.security.customer.Customer;
import com.yunussemree.security.customer.CustomerRepository;
import com.yunussemree.security.role.Role;
import com.yunussemree.security.role.RoleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Transactional
@Component
@RequiredArgsConstructor
public class DataInitializer implements ApplicationListener<ApplicationReadyEvent> {
    private final CustomerRepository customerRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Set<String> defaultRoles = Set.of("ROLE_USER", "ROLE_ADMIN");
        createDefaultRoleIfNotExits(defaultRoles);
        createDefaultUserIfNotExits();
        createDefaultAdminIfNotExits();
    }


    private void createDefaultUserIfNotExits(){
        Role userRole = roleRepository.findByName("ROLE_USER").get();
        for (int i = 1; i<=5; i++){
            String defaultEmail = "customer"+i+"@email.com";
            if (customerRepository.existsByEmail(defaultEmail)){
                continue;
            }
            Customer customer = new Customer();
            customer.setFirstName("The User");
            customer.setLastName("User" + i);
            customer.setEmail(defaultEmail);
            customer.setPassword(passwordEncoder.encode("123456"));
            customer.setRoles(Set.of(userRole));
            customerRepository.save(customer);
            System.out.println("Default vet customer " + i + " created successfully.");
        }
    }


    private void createDefaultAdminIfNotExits(){
        Role userRole = roleRepository.findByName("ROLE_ADMIN").get();
        for (int i = 1; i<=5; i++){
            String defaultEmail = "customer"+i+"@email.com";
            if (customerRepository.existsByEmail(defaultEmail)){
                continue;
            }
            Customer customer = new Customer();
            customer.setFirstName("The Admin");
            customer.setLastName("Admin" + i);
            customer.setEmail(defaultEmail);
            customer.setPassword(passwordEncoder.encode("123456"));
            customer.setRoles(Set.of(userRole));
            customerRepository.save(customer);
            System.out.println("Default admin " + i + " created successfully.");
        }
    }




    private void createDefaultRoleIfNotExits(Set<String> roles){
        roles.stream()
                .filter(role -> roleRepository.findByName(role).isEmpty())
                .map(Role:: new).forEach(roleRepository::save);

    }


}
