package br.com.magalu.referenciaprojetofinal.domain.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class Concessionária {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_concessionaria;

    private String nomeFantasia;

    @OneToMany
    private List<Carro> listaOneToManyCarros;

    //pensar sobre as 20 posicoes de wishlist
    //como apagar da wishlist

    @ManyToMany
    //concessionaria_carros nome da tabela gerada pelo ORM - HIBERNATE
    @JoinTable(name ="wishlist",
            joinColumns = @JoinColumn(name="id_concessionaria"),
            inverseJoinColumns = @JoinColumn(name = "id_carro"))
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
