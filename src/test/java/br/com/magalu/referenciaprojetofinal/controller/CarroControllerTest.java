package br.com.magalu.referenciaprojetofinal.controller;

import br.com.magalu.referenciaprojetofinal.BaseTest;
import br.com.magalu.referenciaprojetofinal.controllers.CarroController;
import br.com.magalu.referenciaprojetofinal.domain.entity.Carro;
import br.com.magalu.referenciaprojetofinal.domain.entity.CarroBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
public class CarroControllerTest extends BaseTest {

    @Autowired
    private CarroController carroController;

    @Test
    public void getProductsList() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/carro")
                .accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void postProduto() throws Exception {
        Carro produto = new CarroBuilder().defaultValues();
        mockMvc.perform(MockMvcRequestBuilders.post("/carro")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(asJsonString(produto)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void updateProduto() throws Exception {
        Carro produto = new CarroBuilder().defaultValues();
        Carro retorno = carroRepository.save(produto);

        retorno.setNome("fogao");
        mockMvc.perform(MockMvcRequestBuilders.put("/carro")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(asJsonString(retorno))
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void deleteProduto() throws Exception {
        Carro produto = new CarroBuilder().defaultValues();
        Carro retorno = carroRepository.save(produto);

        mockMvc.perform(MockMvcRequestBuilders.delete("/carro")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(String.valueOf(retorno.getId())))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
