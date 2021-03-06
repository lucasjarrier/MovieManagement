package gt.treinamento.backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gt.treinamento.backend.enums.Genero;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @JsonIgnore
    @ManyToMany(mappedBy = "filmes", cascade = CascadeType.MERGE)
    private List<Usuario> usuarios;

    @ManyToOne
    @JoinColumn(name = "id_diretor", referencedColumnName = "id")
    private Diretor diretor;

}
