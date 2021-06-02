package gt.treinamento.backend.enums;

import lombok.Getter;

@Getter
public enum Genero {

    INDEFINIDO("Não Especificado"),
    INFANTIL("Infantil"),
    FICCAO("Ficção"),
    ACAO("Ação"),
    ROMANCE("Romance"),
    DRAMA("Drama"),
    COMEDIA("Comédia"),
    TERROR("Terror"),
    GUERRA("Guerra"),
    AVENTURA("Aventura");

    private String state;

    Genero(String state) {
        this.state = state;
    }
}
