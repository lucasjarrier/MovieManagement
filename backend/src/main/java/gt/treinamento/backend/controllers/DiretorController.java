package gt.treinamento.backend.controllers;

import gt.treinamento.backend.models.Diretor;
import gt.treinamento.backend.services.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
