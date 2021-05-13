package br.com.magalu.referenciaprojetofinal.domain.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class Concessionária {

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
    //DE CONCESSIONARIA PARA CARROS
    private List<Carro> carros;

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
}
