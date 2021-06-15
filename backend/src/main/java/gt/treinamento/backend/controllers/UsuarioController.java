package gt.treinamento.backend.controllers;

import gt.treinamento.backend.DTO.UsuarioAtualizacoesDTO;
import gt.treinamento.backend.models.Usuario;
import gt.treinamento.backend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService service;

    @Autowired
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario) {
        return new ResponseEntity(service.save(usuario), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return new ResponseEntity(service.findAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> listarUsuarioPorID(@PathVariable Long id) {
        return new ResponseEntity(service.findById(id), HttpStatus.ACCEPTED);
    }

    @PutMapping
    public ResponseEntity<Usuario> atualizarUsuario(@RequestBody Usuario usuario) {
        return new ResponseEntity(service.salvar(usuario), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarUsuario(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @PostMapping("{id_usuario}/{id_filme}")
    public void adicionarFilme(@PathVariable(value = "id_usuario") Long idUsuario, @PathVariable(value = "id_filme") Long idFilme) {
        service.addFilme(idUsuario,idFilme);
    }
}
