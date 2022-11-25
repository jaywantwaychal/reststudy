package com.jdsolution.reststudy.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void addUser(@RequestBody User user) {
        userDaoService.addUser(user);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable("userId") Integer id,
                           @RequestBody User user) {
        return userDaoService.updateUser(id, user);
    }
}
