package com.sysmap.demo.services.user;

import com.sysmap.demo.data.UserRepository;
import com.sysmap.demo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository _userRepository;
    @Autowired
    private IEventService _eventService;

    @Async
    public String createUser(CreateUserRequest request) {
        var user = new User(request.name, request.email, request.password);

        _userRepository.save(user);

        return user.getId().toString();
    }

    public FindUserResponse findUserByEmail(String email) {
        var user = _userRepository.findUserByEmail(email).get();

        var response = new FindUserResponse() (user.getId(), user.getName(), user.getEmail());

        return response;
    }

    public User getUser(String email) {
    }
    return _userRepository.findUserByEmail(email).get();
}
}
