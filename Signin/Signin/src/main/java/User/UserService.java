package User;

import Signin.Signin.EntityResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public EntityResponse add(User user){
        EntityResponse entityResponse = new EntityResponse<>();
        try {
            User saveduser = userRepository.save(user);
            entityResponse.setMessage("User added successfully");
            entityResponse.setEntity(saveduser);
            entityResponse.setStatusCode(HttpStatus.CREATED.value());

        }catch (Exception e){
            log.error("Error {e}",e);
        }
        return entityResponse;

    }
}
