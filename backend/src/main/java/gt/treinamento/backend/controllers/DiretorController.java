package gt.treinamento.backend.controllers;

import gt.treinamento.backend.models.Diretor;
import gt.treinamento.backend.services.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diretor")
public class DiretorController {

    private final DiretorService service;

    @Autowired
    public DiretorController(DiretorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Diretor> salvarDiretor(@RequestBody Diretor diretor) {
        return new ResponseEntity(service.salvarDiretor(diretor), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Diretor>> listarDiretores() {
        return new ResponseEntity(service.listarDiretores(), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Diretor> atualizarDadosDiretor(@PathVariable(value = "id") Long id, @RequestBody Diretor diretor) {
        return new ResponseEntity(service.alterarDados(id,diretor), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Diretor> encontrarDiretorPorID(@PathVariable(value = "id") Long id) {
        return new ResponseEntity(service.acharPorID(id),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Diretor> deletarDiretorPorID(@PathVariable(value = "id") Long id) {
        service.deletarPorID(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
