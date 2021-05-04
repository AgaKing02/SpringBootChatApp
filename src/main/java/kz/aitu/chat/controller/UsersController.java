package kz.aitu.chat.controller;

import kz.aitu.chat.model.Users;
import kz.aitu.chat.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UsersController {
    @Autowired
    private final UsersRepository usersRepository;

    public UsersController(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(usersRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody Users user) {
        return ResponseEntity.ok(usersRepository.save(user));
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody Users user) {
        return ResponseEntity.ok(usersRepository.save(user));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteUser(@RequestParam(name = "id") Long id) {
        try {
            usersRepository.deleteById(id);
        } catch (Exception e) {
            return ResponseEntity.ok("User not found or deleted " + id);
        }
        return ResponseEntity.ok("User successfully Deleted:");
    }


}
