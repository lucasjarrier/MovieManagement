package gt.treinamento.backend.controllers;

import gt.treinamento.backend.enums.Sexo;
import gt.treinamento.backend.services.SexoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sexo")
public class SexoController {

    private final SexoService sexoService;

    @Autowired
    public SexoController(SexoService sexoService) {
        this.sexoService = sexoService;
    }

    @GetMapping
    public ResponseEntity<List<Sexo>> listarSexos() {
        return new ResponseEntity(sexoService.listarSexo(), HttpStatus.ACCEPTED);
    }
}
