package org.myownstock.user.communities.Impl;

import org.apache.coyote.Response;
import org.myownstock.user.communities.*;
import org.myownstock.user.communities.exception.ResourceNotFoundException;
import org.myownstock.user.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserToCommunityServiceImpl implements UserToCommunityService {
    @Autowired
    IUserToCommunity repository;

    /**
     * Methods designated to add a User to a community
     * @param UserToCommunity userToCommunity
     * @return ResponseEntity<UserToCommunity>
     */
    @Override
    public ResponseEntity<UserToCommunity> add(UserToCommunity userToCommunity) {
        repository.save(userToCommunity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * @param UserToCommunity userToCommunity
     * @return ResponseEntity
     */
    @Override
    public ResponseEntity<UserToCommunity> update(UserToCommunity userToCommunity) {
        return repository.findById(userToCommunity.getId())
                .map(existingCommunity -> {
                    return ResponseEntity.ok(repository.save(userToCommunity));
                })
                .orElseThrow(() -> new ResourceNotFoundException("User to community not exist with the ID provided: " + userToCommunity.getId()));
    }

    /**
     * @param UserToCommunity userToCommunity
     * @return List UserToCommunity
     */
    @Override
    public List<UserToCommunity> findAll() {
        return repository.findAll();
    }

    /**
     * @param UserToCommunity userToCommunity
     * @return ResponseEntity
     */
    @Override
    public ResponseEntity<UserToCommunity> remove(Long id) {
        UserToCommunity existingUserToCommunity = repository.findById(id)
                .orElseThrow(() -> new org.myownstock.user.communities.exception.ResourceNotFoundException("User to community not exist with the ID provided: " + id));

        repository.delete(existingUserToCommunity);
        return ResponseEntity.ok().build();
    }
}
