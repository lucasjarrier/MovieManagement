package gt.treinamento.backend.controllers;

import gt.treinamento.backend.DTO.UserUpdatesDTO;
import gt.treinamento.backend.models.Usuario;
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
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
        return new ResponseEntity(service.save(usuario), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        return new ResponseEntity(service.findAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable(value = "id") Long id) {
        return new ResponseEntity(service.findById(id), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable(value = "id") Long id, @RequestBody UserUpdatesDTO updates) {
        return new ResponseEntity(service.update(updates, id), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
