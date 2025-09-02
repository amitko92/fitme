package com.fitme.repositories;

import com.fitme.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    private static final List<User> users = new ArrayList<>();

    public Optional<User> findByEmail(String email) {

        return users.stream().filter((user) -> user.getEmail() .equals(email)).findFirst();
    }

    public User save(User user) {

        Long newId = (long) (users.size() + 1);
        user.setId(newId); // Simulate setting an ID after saving
        users.add(user);
        return user;
    }

    public List<User> findAll() {

        return new ArrayList<>(users);
    }
}
