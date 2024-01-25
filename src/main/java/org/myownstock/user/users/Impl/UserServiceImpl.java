package org.myownstock.user.users.Impl;

import org.myownstock.user.users.exception.ResourceNotFoundException;
import org.myownstock.user.users.IUser;
import org.myownstock.user.users.User;
import org.myownstock.user.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    IUser repository;

    /**
     * @param User user
     * @return user
     */
    @Override
    public ResponseEntity<User> add(User user) {
        repository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * @param user
     * @return
     */
    @Override
    public ResponseEntity<User> update(User user) {
        return repository.findById(user.getId())
                .map(existingUser -> {
                    return ResponseEntity.ok(repository.save(user));
                })
                .orElseThrow(() -> new ResourceNotFoundException("User not exist with the ID provided: " + user.getId()));
    }

    /**
     * @return List User
     */
    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    /**
     * @param Long id
     * @return ResponseEntity
     */
    public ResponseEntity<User> remove(Long id) {
        User existingUser = repository.findById(id)
                .orElseThrow(() -> new org.myownstock.user.users.exception.ResourceNotFoundException("User not exist with the ID provided: " + id));

        repository.delete(existingUser);
        return ResponseEntity.ok().build();
    }

}
