package com.sysmap.demo.services.user;

import com.sysmap.demo.data.UserRepository;
import com.sysmap.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository _userRepository;

    @Async
    public String createUser(CreateUserRequest request) {

        var user = new User(request.name, request.email, request.password);

        _userRepository.save(user);

        return user.getId().toString();
    }
}
