package gt.treinamento.backend.services;

import gt.treinamento.backend.models.Diretor;
import gt.treinamento.backend.repositories.DiretorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Diretor> listarDiretores() {
        return diretorRepository.findAll();
    }

    public Diretor alterarDados(Long id, Diretor dadosAtualizados) {
        if(diretorRepository.findById(id).isPresent()) {

            Diretor diretor = diretorRepository.findById(id).get();

            if(dadosAtualizados.getNome() != null) {
                diretor.setNome(dadosAtualizados.getNome());
            }
            if(dadosAtualizados.getSobrenome() != null) {
                diretor.setSobrenome(dadosAtualizados.getSobrenome());
            }
            return diretorRepository.save(diretor);
        }
        return null;
    }

    public Diretor acharPorID(Long id) {
        return diretorRepository.findById(id).get();
    }

    public void deletarPorID(Long id) {
        diretorRepository.deleteById(id);
    }
}