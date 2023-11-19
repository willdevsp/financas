package br.com.controle.financas.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Divida {
    private Integer id;

    @NotEmpty(message = "A descricao da divida não pode ser nula")
    private String nomeDivida;

    @NotNull(message = "É necessário informar um valor para a divida")
    private BigDecimal valorDivida;
}
