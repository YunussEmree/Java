package com.YunussEmree.ConstructionsLayers.service.impl;

import com.YunussEmree.ConstructionsLayers.dto.User;
import com.YunussEmree.ConstructionsLayers.service.UserService;
import org.springframework.stereotype.Service;

@Service // This annotation is used to indicate that the class is a service class.
// When the application is started, the classes with the @Service annotation are scanned and the objects are created.
public class UserServiceImpl implements UserService {

    @Override
    public User getUserbyId(Long UserId) {
        return null;
    }
}
