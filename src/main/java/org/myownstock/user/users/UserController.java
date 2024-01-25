package org.myownstock.user.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")

public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user){
        return this.userService.add(user);
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody User user){
        return this.userService.update(user);
    }

    @GetMapping
    public List<User> findAll(){
        return this.userService.findAll();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<User> remove (@PathVariable Long id){
        return this.userService.remove(id);
    }
}
