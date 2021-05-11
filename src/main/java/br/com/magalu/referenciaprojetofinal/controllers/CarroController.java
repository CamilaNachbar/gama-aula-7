package br.com.magalu.referenciaprojetofinal.controllers;

import br.com.magalu.referenciaprojetofinal.domain.entity.Carro;
import br.com.magalu.referenciaprojetofinal.service.CarroService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController(value = "carro")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @ApiOperation(value = "List all Produtos")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloWorldWeb(){
        return "HELLO WORLD WEB";
    }

    //Salvar
    @RequestMapping(value = "/carro", method = RequestMethod.POST)
    public void saveProduto(@RequestBody Carro carro){
        carroService.salvarCarro(carro);
    }

    //Listar
    @RequestMapping(value = "/carro", method = RequestMethod.GET)
    public List<Carro> listar(){
        return carroService.list();
    }

    //Alterar
    @RequestMapping(value = "/carro", method = RequestMethod.PUT)
    public void updateProduto(@RequestBody Carro carro){
        carroService.updateCarro(carro);
    }

    //deletar
    @RequestMapping(value = "/carro", method = RequestMethod.DELETE)
    public void deletarProduto(@RequestBody Long id){
        carroService.deletarCarro(id);
    }
}
