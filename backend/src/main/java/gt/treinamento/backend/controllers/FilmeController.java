package gt.treinamento.backend.controllers;

import gt.treinamento.backend.models.Filme;
import gt.treinamento.backend.services.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService service;

    @Autowired
    public FilmeController(FilmeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Filme> salvarFilme(@RequestBody Filme filme) {
        return new ResponseEntity(service.salvarFilme(filme), HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<Filme>> listarFilmes() {
        return new ResponseEntity(service.listarFilmes(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> listarFilmePorID(@PathVariable Long id) {
        return new ResponseEntity(service.procurarPorId(id),HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filme> atualizarFilme(@PathVariable Long id, @RequestBody Filme filme) {
        return new ResponseEntity(service.atualizarFilme(id,filme),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarFilme(@PathVariable Long id) {
        service.deletarFilme(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);}
}

