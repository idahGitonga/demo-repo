package com.example.demo.User;

import com.example.demo.EntityResponse.EntityResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepo userRepo;
    public EntityResponse add(User user) {
        EntityResponse entityResponse = new EntityResponse<>();
        try {
            User saveduser = userRepo.save(user);
            entityResponse.setMessage("User saved successfully");
            entityResponse.setEntity(saveduser);
            entityResponse.setStatusCode(HttpStatus.CREATED.value());
        }catch (Exception e){
            log.error("Error {}",e);
            entityResponse.setMessage("An error has occurred while creating the user");
            entityResponse.setEntity(null);
            entityResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return entityResponse;
    }

    public EntityResponse findById(Long id) {
        EntityResponse entityResponse = new EntityResponse<>();
        Optional<User> existingCustomer = userRepo.findById(id);
        try {
            if (existingCustomer.isPresent()){
                entityResponse.setStatusCode(HttpStatus.FOUND.value());
                entityResponse.setMessage("user found successfully");
                entityResponse.setEntity(existingCustomer);
            }else {
                entityResponse.setMessage("user not found");
                entityResponse.setEntity(null);
                entityResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
            }
        }catch (Exception e){
            entityResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            entityResponse.setMessage("An error has occured while trying to find the customer" + id);
        }
        return entityResponse;
    }

    public EntityResponse deleteById(Long id) {
        EntityResponse entityResponse = new EntityResponse<>();
        Optional<User> UserToDelete = userRepo.findById(id);
        try {
            if (UserToDelete.isPresent()) {
                userRepo.deleteById(id);
                entityResponse.setMessage("User deleted successfully");
                entityResponse.setEntity(UserToDelete);
                entityResponse.setStatusCode(HttpStatus.FOUND.value());
            }else
            {
                entityResponse.setMessage("user not found");
                entityResponse.setEntity(null);
                entityResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
            }
        } catch (Exception e) {
            entityResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            entityResponse.setMessage("An error occurred while trying to delete user");
        }
        return entityResponse;
    }
};

