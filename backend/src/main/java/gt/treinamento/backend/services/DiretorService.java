package gt.treinamento.backend.services;

import gt.treinamento.backend.models.Diretor;
import gt.treinamento.backend.repositories.DiretorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiretorService {

    private final DiretorRepository diretorRepository;

    @Autowired
    public DiretorService(DiretorRepository diretorRepository) {
        this.diretorRepository = diretorRepository;
    }

    public Diretor salvarDiretor(Diretor diretor) {
        return diretorRepository.save(diretor);
    }
}
