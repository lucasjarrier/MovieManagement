package gt.treinamento.backend.enums;

import lombok.Getter;

@Getter
public enum Sexo {

    Masculino("Masculino"),
    Feminino("Feminino"),
    NãoInformado("Não Declarado");

    private String state;

    Sexo(String state) {
        this.state = state;
    }
}
