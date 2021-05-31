package gt.treinamento.backend.controllers;

import gt.treinamento.backend.DTO.UserUpdatesDTO;
import gt.treinamento.backend.models.User;
import gt.treinamento.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<User> save(User user) {
        return new ResponseEntity(service.save(user), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity(service.findAll(), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable(value = "id") Long id, UserUpdatesDTO updates) {
        return new ResponseEntity(service.update(updates, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
