package org.myownstock.user.communities;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CommunityService {
    public Community add(Community community);
    public ResponseEntity<Community> update(Community community);
    public List<Community> findAll();
    public ResponseEntity<Community> remove(Long id);
}
