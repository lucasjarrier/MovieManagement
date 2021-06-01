package gt.treinamento.backend.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(schema = "treinamento")
public class Diretor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "diretor_id_seq")
    @SequenceGenerator(name = "diretor_id_seq", sequenceName = "treinamento.diretor_id_seq", allocationSize = 1)
    private Long id;

    @Column(name="nome")
    private String nome;

    @Column(name="sobrenome")
    private String sobrenome;

}
