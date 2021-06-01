package gt.treinamento.backend.repositories;

import gt.treinamento.backend.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends  JpaRepository<Usuario, Long> {

}
