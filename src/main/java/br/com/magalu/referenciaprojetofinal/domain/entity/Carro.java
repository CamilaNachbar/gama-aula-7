package br.com.magalu.referenciaprojetofinal.domain.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "carro")
public class Carro{

    public Carro(){

    }
    public Carro(String nome, String modelo, String ano, String cor) {
        this.nome = nome;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_carro;

    private String nome;
    private String modelo;
    private String ano;
    private String cor;

    //nome da lista em concessionaria
    @ManyToMany(mappedBy = "carros")
    private List<Concessionária> concessionarias;

    @ManyToOne
    private Concessionária concessionária;

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

    public Long getId() {
        return id_carro;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "id=" + id_carro +
                ", nome='" + nome + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano='" + ano + '\'' +
                ", cor='" + cor + '\'' +
                '}';
    }

    public void setId(Long id) {
        this.id_carro = id;
    }


}