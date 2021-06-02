package gt.treinamento.backend.enums;

import lombok.Getter;

@Getter
public enum Genero {

    Indefinido("Não Especificado"),
    Infantil("Infantil"),
    Ficcao("Ficção"),
    Acao("Ação"),
    Romance("Romance"),
    Drama("Drama"),
    Comedia("Comédia"),
    Terror("Terror"),
    Guerra("Guerra"),
    Aventura("Aventura");

    private String state;

    Genero(String state) {
        this.state = state;
    }
}
