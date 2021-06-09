package gt.treinamento.backend.enums;

import lombok.Getter;

@Getter
public enum Sexo {

    MASCULINO("Masculino"),
    FEMININO("Feminino"),
    NAO_INFORMADO("Não Declarado");

    private String state;

    Sexo(String state) {
        this.state = state;
    }



}
