package org.myownstock.user.communities.Impl;

import org.myownstock.user.communities.exception.ResourceNotFoundException;
import org.myownstock.user.communities.Community;
import org.myownstock.user.communities.CommunityService;
import org.myownstock.user.communities.ICommunity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityServiceImpl implements CommunityService {
    @Autowired
    private ICommunity repository;

    @Override
    public Community add(Community community) {
        return repository.save(community);
    }

    @Override
    public ResponseEntity<Community> update(Community community) {
        return repository.findById(community.getId())
                .map(existingCommunity -> {
                    return ResponseEntity.ok(repository.save(community));
                })
                .orElseThrow(() -> new ResourceNotFoundException("Community not exist with the ID provided: " + community.getId()));
    }

    @Override
    public List<Community> findAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<Community> remove(Long id) {
        Community existingCommunity = repository.findById(id)
                .orElseThrow(() -> new org.myownstock.user.communities.exception.ResourceNotFoundException("Community not exist with the ID provided: " + id));

        repository.delete(existingCommunity);
        return ResponseEntity.ok().build();
    }
}
