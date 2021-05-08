package br.com.magalu.referenciaprojetofinal.controllers;

import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController(value = "carro")
public class CarroController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloWebWorld(){
        return "Hello World";
    }
}
