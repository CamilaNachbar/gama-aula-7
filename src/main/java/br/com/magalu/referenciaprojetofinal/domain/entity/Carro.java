package br.com.magalu.referenciaprojetofinal.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "carro")
public class Carro{
    public Carro(String nome, String modelo, String ano, String cor) {
        this.nome = nome;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
    }

    @Id
    private long id;

    private String nome;
    private String modelo;
    private String ano;
    private String cor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}