package br.com.controle.financas.gateway.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Builder
@Table(name = "Divida")
public class DividaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nomeDivida;
    private BigDecimal valorDivida;

}
