package gt.treinamento.backend.services;

import gt.treinamento.backend.DTO.UserUpdatesDTO;
import gt.treinamento.backend.models.User;
import gt.treinamento.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(UserUpdatesDTO updates, Long id) {

        if(userRepository.findById(id).isPresent()) {

            User user = userRepository.findById(id).get();

            if(updates.getBirthday() != null) {
                user.setBirthday(updates.getBirthday());
            }
            if(updates.getGender() != null) {
                user.setGender(updates.getGender());
            }
            if(updates.getName() != null) {
                user.setName(updates.getName());
            }
            if(updates.getLastName() != null) {
                user.setLastName(updates.getLastName());
            }
            return userRepository.save(user);
        }
        return null;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }
}
