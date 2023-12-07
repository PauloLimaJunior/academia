package com.example.academia.entities;

import org.springframework.data.neo4j.core.schema.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Node
public class Instrutor {

    @Id
    private Long matricula;

    private String nome;
    private String email;
    private String telefone;
    private Date dataDeNascimento;
    private String cep;
    private String rua;
    private String numeroDaCasa;
    private String bairro;
    private String cargo;
    private String especialidade;

    @Relationship(type = "ASSISTE_TREINO", direction = Relationship.Direction.INCOMING)
    private List<Treino> treinos = new ArrayList<>();

    public Instrutor() {
    }

    public Instrutor(String nome, String email, String telefone, String cargo, String especialidade) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cargo = cargo;
        this.especialidade = especialidade;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumeroDaCasa() {
        return numeroDaCasa;
    }

    public void setNumeroDaCasa(String numeroDaCasa) {
        this.numeroDaCasa = numeroDaCasa;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }




    public List<Treino> getTreinos() {
        return treinos;
    }

    public void setTreinos(List<Treino> treinos) {
        this.treinos = treinos;
    }
}
