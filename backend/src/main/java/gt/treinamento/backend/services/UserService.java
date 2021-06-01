package gt.treinamento.backend.services;

import gt.treinamento.backend.DTO.UserUpdatesDTO;
import gt.treinamento.backend.models.Usuario;
import gt.treinamento.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.Valid;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Usuario save(@Valid Usuario usuario) {
        return userRepository.save(usuario);
    }

    public Usuario update(UserUpdatesDTO updates, Long id) {

        if(userRepository.findById(id).isPresent()) {

            Usuario usuario = userRepository.findById(id).get();

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
            return userRepository.save(usuario);
        }
        return null;
    }

    public List<Usuario> findAll() {
        return userRepository.findAll();
    }

    public Usuario findById(Long id) {
        return userRepository.findById(id).get();
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
