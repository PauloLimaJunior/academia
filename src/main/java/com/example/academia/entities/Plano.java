package com.example.academia.entities;

import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;
import java.util.List;

@Node
public class Plano {



    @Id
        @GeneratedValue
    private Long id;

    private String nomeDoPlano;

    private String descricao;

    @Relationship(type = "INCLUI_ALUNO", direction = Relationship.Direction.INCOMING)
    private List<Aluno> alunos = new ArrayList<>();

    @Relationship(type = "REFERENCIA_PLANO", direction = Relationship.Direction.INCOMING)
    private List<Pagamento> pagamentos = new ArrayList<>();

    public Plano() {
    }

    public Plano(String nomeDoPlano, String descricao) {
        this.nomeDoPlano = nomeDoPlano;
        this.descricao = descricao;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDoPlano() {
        return nomeDoPlano;
    }

    public void setNomeDoPlano(String nomeDoPlano) {
        this.nomeDoPlano = nomeDoPlano;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public void addAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public void addPagamento(Pagamento pagamento) {
        this.pagamentos.add(pagamento);
    }

    public Object getIdPlano() {
        return null;
    }
}
