package org.myownstock.user.roles;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")

public class RoleController {
    @Autowired
    RoleService roleService;

    @PostMapping
    public ResponseEntity<Role> add(@RequestBody Role role){
        return this.roleService.add(role);
    }

    @PutMapping
    public ResponseEntity<Role> update(@RequestBody Role role){
        return this.roleService.update(role);
    }

    @GetMapping
    public List<Role> findAll(){ return this.roleService.findAll(); }

    @DeleteMapping("{id}")
    public ResponseEntity<Role> remove(@PathVariable Long id) {
        return this.roleService.remove(id);
    }
}

