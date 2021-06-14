package gt.treinamento.backend.models;

import gt.treinamento.backend.enums.Sexo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "usuario", schema = "treinamento")
public class Usuario {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_id_seq")
    @SequenceGenerator(name = "usuario_id_seq", sequenceName = "treinamento.usuario_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sobrenome")
    private String sobrenome;

    @Column(name = "sexo")
    private Sexo sexo;

    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @Email
    @Column(name = "email", unique = true)
    private String email;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}   )
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(schema = "treinamento", name = "rel_usuario_filme",
            joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_filme", referencedColumnName = "id"))
    private List<Filme> filmes;

}

