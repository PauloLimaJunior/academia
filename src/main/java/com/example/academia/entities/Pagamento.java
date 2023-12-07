package com.example.academia.entities;

import org.springframework.data.neo4j.core.schema.*;

import java.util.Date;

@Node
public class Pagamento {

    @Id
    @GeneratedValue
    private Long id;

    private Date dataDoPagamento;

    private Double valorDoPagamento;

    @Relationship(type = "REFERENCIA_PLANO")
    private Plano plano;

    public Pagamento() {
    }

    public Pagamento(Date dataDoPagamento, Double valorDoPagamento, Plano plano) {
        this.dataDoPagamento = dataDoPagamento;
        this.valorDoPagamento = valorDoPagamento;
        this.plano = plano;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataDoPagamento() {
        return dataDoPagamento;
    }

    public void setDataDoPagamento(Date dataDoPagamento) {
        this.dataDoPagamento = dataDoPagamento;
    }

    public Double getValorDoPagamento() {
        return valorDoPagamento;
    }

    public void setValorDoPagamento(Double valorDoPagamento) {
        this.valorDoPagamento = valorDoPagamento;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }
}
