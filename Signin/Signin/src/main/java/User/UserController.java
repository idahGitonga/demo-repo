package User;

import Signin.Signin.EntityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin

public class UserController {
  @Autowired
    private UserService userService;

    @PostMapping("/addUser")
  public EntityResponse addUser(User user){
     return userService.add(user);

  }

}
