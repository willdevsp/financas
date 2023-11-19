package br.com.controle.financas.config;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomMessageValidation {

    private String campo;
    private String descricao;
}
