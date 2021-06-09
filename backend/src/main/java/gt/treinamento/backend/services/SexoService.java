package gt.treinamento.backend.services;

import gt.treinamento.backend.enums.Sexo;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class SexoService {

    public Object[] listarSexo() {
        return Arrays.stream(Sexo.values()).toArray();
    }

}
