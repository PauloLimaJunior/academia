package com.example.academia.entities;

import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Node
public class Treino {

    @Id
    @GeneratedValue
    private Long id;

    private String nomeDoTreino;

    private String descricao;

    private Date dataDoTreino;

    private int duracaoEmMinutos;

    @Relationship(type = "INSTRUI_TREINO", direction = Relationship.Direction.INCOMING)
    private List<Instrutor> instrutores = new ArrayList<>();

    @Relationship(type = "REALIZA_TREINO", direction = Relationship.Direction.INCOMING)
    private List<Aluno> alunos = new ArrayList<>();

    public Treino() {
    }

    public Treino(String nomeDoTreino, String descricao, int duracaoEmMinutos, Date dataDoTreino) {
        this.nomeDoTreino = nomeDoTreino;
        this.descricao = descricao;
        this.duracaoEmMinutos = duracaoEmMinutos;
        this.dataDoTreino = dataDoTreino;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDoTreino() {
        return nomeDoTreino;
    }

    public void setNomeDoTreino(String nomeDoTreino) {
        this.nomeDoTreino = nomeDoTreino;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataDoTreino() {
        return dataDoTreino;
    }

    public void setDataDoTreino(Date dataDoTreino) {
        this.dataDoTreino = dataDoTreino;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public List<Instrutor> getInstrutores() {
        return instrutores;
    }

    public void setInstrutores(List<Instrutor> instrutores) {
        this.instrutores = instrutores;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public void addInstrutor(Instrutor instrutor) {
        this.instrutores.add(instrutor);
    }

    public void addAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public Object getIdTreino() {
        return null;
    }
}
