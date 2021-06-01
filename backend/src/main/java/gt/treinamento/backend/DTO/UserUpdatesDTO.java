package gt.treinamento.backend.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserUpdatesDTO {

    private String nome;
    private String sobrenome;
    private String sexo;
    private Date dataNascimento;

}
