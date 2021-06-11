package gt.treinamento.backend.services;

import gt.treinamento.backend.DTO.UsuarioAtualizacoesDTO;
import gt.treinamento.backend.models.Usuario;
import gt.treinamento.backend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.Valid;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario save(@Valid Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario update(UsuarioAtualizacoesDTO updates, Long id) {

        if(usuarioRepository.findById(id).isPresent()) {

            Usuario usuario = usuarioRepository.findById(id).get();

            if(updates.getDataNascimento() != null) {
                usuario.setDataNascimento(updates.getDataNascimento());
            }
            if(updates.getSexo() != null) {
                usuario.setSexo(updates.getSexo());
            }
            if(updates.getNome() != null) {
                usuario.setNome(updates.getNome());
            }
            if(updates.getSobrenome() != null) {
                usuario.setSobrenome(updates.getSobrenome());
            }
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).get();
    }

    public void delete(Long id){
        usuarioRepository.deleteById(id);
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
