package br.com.magalu.referenciaprojetofinal.controllers;

import br.com.magalu.referenciaprojetofinal.domain.entity.Carro;
import br.com.magalu.referenciaprojetofinal.domain.entity.Concessionária;
import br.com.magalu.referenciaprojetofinal.service.CarroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController(value = "carro")
@Api("CRUD - CARROS")
public class CarroController {

    @Autowired
    private CarroService carroService;

    //Salvar
    @ApiOperation(value = "Salvar carro")
    @RequestMapping(value = "/carro", method = RequestMethod.POST)
    public ResponseEntity<Carro> saveProduto(@RequestBody Carro carro){
        return new ResponseEntity<Carro>(carroService.salvarCarro(carro), HttpStatus.CREATED);
    }



    //Listar
    @ApiOperation(value = "listar todos os carros")
    @RequestMapping(value = "/carro", method = RequestMethod.GET)
    public ResponseEntity<List<Carro>> listar(){
        return new ResponseEntity<>(carroService.list(), HttpStatus.ACCEPTED);
    }

    //Alterar
    @ApiOperation(value = "Alterar carro atraves do id")
    @RequestMapping(value = "/carro", method = RequestMethod.PUT)
    public ResponseEntity<Carro> updateProduto(@RequestBody Carro carro){
        return new ResponseEntity<Carro>(carroService.updateCarro(carro), HttpStatus.ACCEPTED);
    }

    //deletar
    @ApiOperation(value = "Deletar carro atraves do id")
    @RequestMapping(value = "/carro", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletarProduto(@RequestBody Long id){
        try {
            carroService.deletarCarro(id);
            return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Erro ao deletar carro", HttpStatus.BAD_REQUEST);
        }
    }

    //listar concessionarias
    @ApiOperation(value = "Trazer concessionaria atraves do id")
    @RequestMapping(value = "/carro/concessionaria", method = RequestMethod.GET)
    public List<Concessionária> buscaPorCarroEmConcessionaria(@RequestParam("id") Long id)
    {
      return  carroService.buscarCarroEmConcessionaria(id);
    }

    //inserir concessionarias
    @ApiOperation(value = "Salvar nova concessionaria para o carro")
    @RequestMapping(value = "/carro/concessionaria", method = RequestMethod.POST)
    public ResponseEntity<Carro>savaNovoItemWishLis(@RequestBody Long id_carro,
                                                    @RequestBody Long id_concessionaria)
    {
        return new ResponseEntity<Carro>(carroService.inserirNaListaDeCarroAConcessionaria(id_carro, id_concessionaria), HttpStatus.ACCEPTED);
    }
}
