package br.com.controle.financas.usecase;

import br.com.controle.financas.domain.Divida;
import br.com.controle.financas.gateway.DividasGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarDivida {


    @Autowired
    private DividasGateway gateway;
    public Divida salvar(Divida divida){
        return gateway.salvarDividas(divida);
    }
}
