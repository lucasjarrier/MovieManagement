package gt.treinamento.backend.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(schema = "treinamento")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_id_seq")
    @SequenceGenerator(name = "usuario_id_seq", sequenceName = "usuario_id_seq")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "nome")
    private String name;

    @NotNull
    @Column(name = "sobrenome")
    private String lastName;

    @NotNull
    private String gender;

    @NotNull
    private Date birthday;

    @NotNull
    private String email;

    @Transient
    private List<Movie> movies;

}
