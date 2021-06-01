package gt.treinamento.backend.services;

import gt.treinamento.backend.models.Filme;
import gt.treinamento.backend.repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;

    @Autowired
    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public Filme salvarFilme(Filme filme) {
        return filmeRepository.save(filme);
    }

    public Filme atualizarFilme(Long id, Filme dadosAtualizados) {
        if(filmeRepository.findById(id).isPresent()) {

            Filme filme = filmeRepository.findById(id).get();

            if(dadosAtualizados.getDiretor() != null) {
                filme.setDiretor(dadosAtualizados.getDiretor());
            }
            if(dadosAtualizados.getGenero() != null) {
                filme.setGenero(dadosAtualizados.getGenero());
            }
            if(dadosAtualizados.getNome() != null) {
                filme.setNome(dadosAtualizados.getNome());
            }
            if(dadosAtualizados.getLancamento() != null) {
                filme.setLancamento(dadosAtualizados.getLancamento());
            }
            return filmeRepository.save(filme);
        }
        return null;
    }

    public List<Filme> listarFilmes() {
        return filmeRepository.findAll();
    }

    public Filme procurarPorId(Long id) {
        return filmeRepository.findById(id).get();
    }

    public void deletarFilme(Long id) {
        filmeRepository.deleteById(id);
    }
}
