package gt.treinamento.backend.DTO;

import gt.treinamento.backend.enums.Sexo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UsuarioAtualizacoesDTO {

    private String nome;
    private String sobrenome;
    private Sexo sexo;
    private Date dataNascimento;

}
