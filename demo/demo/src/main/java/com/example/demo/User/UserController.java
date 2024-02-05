package com.example.demo.User;

import com.example.demo.EntityResponse.EntityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;
@PostMapping("/add")
    public EntityResponse add(@RequestBody User user){
        return userService.add(user);
    }
    @GetMapping("/findById")
    public EntityResponse findById(@RequestParam Long id){
    return userService.findById(id);}
    @DeleteMapping("/delete")
            public EntityResponse deleteById(@RequestParam Long id){
        return userService.deleteById(id);
        }
        }

