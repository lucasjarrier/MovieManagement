package gt.treinamento.backend.models;

import gt.treinamento.backend.enums.Genero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(schema = "treinamento")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private Genero genero;

    @Column
    private Date lancamento;

    @ManyToOne
    @JoinColumn(name = "id_diretor", referencedColumnName = "id")
    private Diretor diretor;

}
