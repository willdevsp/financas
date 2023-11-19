package br.com.controle.financas.controller;

import br.com.controle.financas.domain.Divida;
import br.com.controle.financas.usecase.CadastrarDivida;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
class CadastroDividasTest {


    @InjectMocks
    CadastroDividas cadastroDividas;

    @Mock
    CadastrarDivida usecase;

    @Test
    void cadastrarDividaComSucesso(){

        Divida divida = Divida.builder().nomeDivida("Cartao")
                .valorDivida(new BigDecimal("19.0"))
                .build();
        Divida dividaSalva = divida;

        divida.setId(1);


        Mockito.when(usecase.salvar(any()))
                .thenReturn(dividaSalva);

        ResponseEntity<Divida> response = cadastroDividas.salvar(divida);

        Divida resultado = response.getBody();

        assertEquals(response.getStatusCode(), HttpStatus.OK);

        assertEquals(dividaSalva.getId(), resultado.getId());
        assertEquals(dividaSalva.getNomeDivida(), resultado.getNomeDivida());
        assertEquals(dividaSalva.getValorDivida(), resultado.getValorDivida());

    }
}