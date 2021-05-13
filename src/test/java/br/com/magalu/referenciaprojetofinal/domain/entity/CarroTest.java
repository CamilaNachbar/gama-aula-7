package br.com.magalu.referenciaprojetofinal.domain.entity;


import br.com.magalu.referenciaprojetofinal.domain.repository.CarroRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import static org.assertj.core.api.Assertions.assertThat;
@Profile("local")
@SpringBootTest
public class CarroTest {

    @Autowired
    private CarroRepository carroRepository;

    @Test
    public void criandoInstancia(){
        Carro carro = new CarroBuilder().defaultValues();
        assertThat(carro).isNotNull();
    }

    @Test
    public void comparandoAtributos(){
        Carro carro = new CarroBuilder().defaultValues();
        assertThat(carro.getAno()).isEqualTo(DefaultValues.ANO);
    }
}
