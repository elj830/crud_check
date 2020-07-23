package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository){
        this.repository = repository;
    }

    @GetMapping("/users")
    public Iterable<User> allUsers(){
        return this.repository.findAll();
    }
    @PostMapping("/save")
    public User create(@RequestBody User user){
        return this.repository.save(user);
    }

    @GetMapping("/by-id")
    public User byID(@RequestParam("id") long id){
        return this.repository.findById(id);
    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<?> updateData(
            @RequestBody User userUpdate,
            @PathVariable("id") String id
    ){
        this.repository.save(userUpdate, id);
    }

}
