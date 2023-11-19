package br.com.controle.financas.gateway;

import br.com.controle.financas.domain.Divida;
import br.com.controle.financas.gateway.entity.DividaEntity;
import br.com.controle.financas.gateway.repository.DividaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class DividasGatewayImpl implements DividasGateway {

    @Autowired
    private DividaRepository repository;

    @Override
    public Divida salvarDividas(Divida divida) {

        DividaEntity dadoSalvo = repository.save(DividaEntity.builder()
                .nomeDivida(divida.getNomeDivida())
                .valorDivida(divida.getValorDivida())
                .build());

        return Divida.builder()
                .id(dadoSalvo.getId())
                .nomeDivida(dadoSalvo.getNomeDivida())
                .valorDivida(dadoSalvo.getValorDivida())
                .build();
    }
}
