package br.com.magalu.referenciaprojetofinal.domain.entity;

import java.util.ArrayList;
import java.util.List;

public class CarroBuilder {

    public Carro defaultValues(){
        return new Carro(DefaultValues.NOME, DefaultValues.MODELO, DefaultValues.ANO, DefaultValues.COR );
    }

    public Carro defaultValuesAndConcessionaria(){
        Carro carro = new Carro(DefaultValues.NOME, DefaultValues.MODELO, DefaultValues.ANO, DefaultValues.COR );
        List<Concessionária> concessionariaList = new ArrayList<>();
        concessionariaList.add(new ConcessionariaBuilder().defaultValues());
        carro.setConcessionarias(concessionariaList);
        return carro;
    }
}
