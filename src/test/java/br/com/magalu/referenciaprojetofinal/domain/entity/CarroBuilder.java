package br.com.magalu.referenciaprojetofinal.domain.entity;

public class CarroBuilder {

    public Carro defaultValues(){
        return new Carro(DefaultValues.NOME, DefaultValues.MODELO, DefaultValues.ANO, DefaultValues.COR );
    }

}
