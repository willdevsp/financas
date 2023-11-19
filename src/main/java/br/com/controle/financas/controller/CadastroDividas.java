package br.com.controle.financas.controller;

import br.com.controle.financas.domain.Divida;
import br.com.controle.financas.usecase.CadastrarDivida;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/dividas")
public class CadastroDividas {

    @Autowired
    private CadastrarDivida cadastrarDivida;
    @PostMapping
    public ResponseEntity<Divida> salvar(@RequestBody @Valid Divida divida){

        return ResponseEntity.ok(cadastrarDivida.salvar(divida));
    }
}
