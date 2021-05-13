package br.com.magalu.referenciaprojetofinal;

import br.com.magalu.referenciaprojetofinal.domain.entity.Carro;
import br.com.magalu.referenciaprojetofinal.domain.entity.CarroBuilder;
import br.com.magalu.referenciaprojetofinal.domain.repository.CarroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.web.servlet.MockMvc;
@SpringBootTest
@AutoConfigureMockMvc
public abstract class BaseTest {

    @BeforeEach
    public void setup(){
        Carro carro = new CarroBuilder().defaultValues();
        carroRepository.save(carro);
    }

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected CarroRepository carroRepository;

}
