package com.example.dto.repos;

import com.example.dto.model.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DataRepo {
    private List<User> users;

    @PostConstruct
    public void init() {
        users = new ArrayList<>();
        users.add(new User(1,"Rahmonali","916774162"));
        users.add(new User(2, "Test", "910007788"));
        users.add(new User(3, "Test2", "907778899"));
    }

    public List<User> findAll() {
        return users;
    }
    public boolean save(User user) {
        return users.add(user);
    }
}
