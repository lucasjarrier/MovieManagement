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
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "diretor_id_seq")
    @SequenceGenerator(name = "diretor_id_seq", sequenceName = "diretor_id_seq")
    private Long id;

    @NotNull
    @Column(name="nome")
    private String nome;

    @NotNull
    @Column(name="sobrenome")
    private String sobrenome;

}
