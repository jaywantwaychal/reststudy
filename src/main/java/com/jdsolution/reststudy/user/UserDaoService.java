package com.jdsolution.reststudy.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class UserDaoService {

    private static int idCounter = 0;
    private static final List<User> userList =
            Stream.of(new User(++idCounter, "T1", LocalDate.now().minusYears(30)),
                      new User(++idCounter, "T2", LocalDate.now().minusYears(20)),
                      new User(++idCounter, "T3", LocalDate.now().minusYears(10)))
                    .collect(Collectors.toList());

    public List<User> getUserList() {
        return userList;
    }

    public User getUser(Integer id) {
        return userList.stream()
            .filter(user -> user.getId() == id)
            .findFirst()
            .get();
    }

    public void addUser(User user) {
        user.setId(++idCounter);
        userList.add(user);
    }

    public User updateUser(Integer id, User userNew) {
        return userList.stream()
            .filter(user -> user.getId() == id)
            .findFirst()
            .map(user -> {
                user.setBirtDate(userNew.getBirtDate());
                user.setName(userNew.getName());
                return user;
            })
            .get();
        
    }
}
