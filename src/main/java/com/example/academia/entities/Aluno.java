package com.example.academia.entities;

import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Node
public class Aluno {

    @Id
    @GeneratedValue
    private long cpf;

    private String nome;
    private String email;
    private String telefone;
    private Date dataDeNascimento;
    private String cep;
    private String rua;
    private String numeroDaCasa;
    private String bairro;

    @Relationship(type = "TEM_PLANO")
    private Plano plano;

    @Relationship(type = "ASSISTE_TREINO")
    private List<Treino> treinos = new ArrayList<>();

    // Construtor sem argumentos
    public Aluno() {
    }

    // Construtor com quatro argumentos
    public Aluno(Long cpf, String nome, String email, String telefone, Plano plano) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.plano = plano;
    }

    public Aluno(String number, String joaquimBrasil, String mail, String number1, Plano p1) {
    }

    // Getters e Setters

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = Long.parseLong(String.valueOf(cpf));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumeroDaCasa() {
        return numeroDaCasa;
    }

    public void setNumeroDaCasa(String numeroDaCasa) {
        this.numeroDaCasa = numeroDaCasa;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public List<Treino> getTreinos() {
        return treinos;
    }

    public void setTreinos(List<Treino> treinos) {
        this.treinos = treinos;
    }

    public void addTreinos(List<Treino> list) {
        // Implementação do método addTreinos
    }
}
