package org.myownstock.user.communities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/communities")

public class CommunityController {
    @Autowired
    CommunityService communityService;

    @PostMapping
    public Community add(@RequestBody Community community) {
        return this.communityService.add(community);
    }

    @PutMapping
    public ResponseEntity<Community> update(@RequestBody Community community) {
        return this.communityService.update(community);
    }

    @GetMapping
    public List<Community> findAll(){
        return this.communityService.findAll();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Community> remote(@PathVariable Long id){
        return this.communityService.remove(id);
    }
}
