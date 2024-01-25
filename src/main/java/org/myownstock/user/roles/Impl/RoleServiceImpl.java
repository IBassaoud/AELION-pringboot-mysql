package org.myownstock.user.roles.Impl;

import org.myownstock.user.communities.exception.ResourceNotFoundException;
import org.myownstock.user.roles.IRole;
import org.myownstock.user.roles.Role;
import org.myownstock.user.roles.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    IRole repository;

    /**
     * @param Role role
     * @return Role
     */
    @Override
    public ResponseEntity<Role> add(Role role) {
        repository.save(role);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * @param Role role
     * @return
     */
    @Override
    public ResponseEntity<Role> update(Role role) {
        return repository.findById(role.getId())
                .map(existingRole -> {
                    return ResponseEntity.ok(repository.save(role));
                })
                .orElseThrow(() -> new ResourceNotFoundException("Role not exist with the ID provided: " + role.getId()));
    }

    /**
     * @return List Role
     */
    @Override
    public List<Role> findAll() {
        return repository.findAll();
    }

    /**
     * @param Role role
     * @return ResponseEntity
     */
    @Override
    public ResponseEntity<Role> remove(Long id) {
        Role existingRole = repository.findById(id)
                .orElseThrow(() -> new org.myownstock.user.roles.exception.ResourceNotFoundException("Role not exist with the ID provided: " + id));

        repository.delete(existingRole);
        return ResponseEntity.ok().build();
    }
}
