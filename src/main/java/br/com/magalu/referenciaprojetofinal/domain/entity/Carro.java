package br.com.magalu.referenciaprojetofinal.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "carro")
public class Carro implements Serializable {

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

    @Column(name="nome")
    private String nome;
    @Column(name="modelo")
    private String modelo;
    @Column(name="ano")
    private String ano;
    @Column(name="cor")
    private String cor;

    //nome da lista em concessionaria

    @ManyToMany( fetch = FetchType.EAGER)
    //concessionaria_carros nome da tabela gerada pelo ORM - HIBERNATE
    @JoinTable(name ="wishlist",
            joinColumns = @JoinColumn(name="id_carro"),
            inverseJoinColumns = @JoinColumn(name = "id_concessionaria"))
    private List<Concessionária> concessionarias;

    public List<Concessionária> getConcessionarias() {
        return concessionarias;
    }

    public void setConcessionarias(List<Concessionária> concessionarias) {
        this.concessionarias = concessionarias;
    }

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