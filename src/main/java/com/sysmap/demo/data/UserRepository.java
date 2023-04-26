package com.sysmap.demo.data;

import com.sysmap.demo.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;
public interface UserRepository extends MongoRepository<User, UUID> {

}
