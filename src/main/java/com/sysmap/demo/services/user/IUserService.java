package com.sysmap.demo.services.user;

public interface IUserService {
    String createUser(CreateUserRequest request);
    FindUserResponse findUserByEmail(String email);
}
