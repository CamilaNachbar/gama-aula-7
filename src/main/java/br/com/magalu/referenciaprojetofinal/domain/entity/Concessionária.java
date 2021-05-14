package br.com.magalu.referenciaprojetofinal.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Concessionária  implements Serializable {

    public Long getId_concessionaria() {
        return id_concessionaria;
    }

    public void setId_concessionaria(Long id_concessionaria) {
        this.id_concessionaria = id_concessionaria;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_concessionaria;

    private String nomeFantasia;

     //pensar sobre as 20 posicoes de wishlist
     public Concessionária() {
     }
    public Concessionária(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }
    //como apagar da wishlist


    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "concessionarias")
    private List<Carro> carros;

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    @JsonIgnore
    public List<Carro> getCarros() {
        return carros;
    }
    @JsonProperty
    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
}
