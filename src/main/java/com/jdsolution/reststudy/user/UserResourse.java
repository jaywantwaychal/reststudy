package com.jdsolution.reststudy.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResourse {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping()
    public List<User> getAllUsers() {
        return userDaoService.getUserList();
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Integer id) {
        return userDaoService.getUser(id);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User savedUser = userDaoService.addUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{userId}")
                        .build(savedUser.getId());
        return ResponseEntity.created(location).build();
    }


}
