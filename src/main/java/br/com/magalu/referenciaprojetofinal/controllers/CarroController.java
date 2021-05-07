package br.com.magalu.referenciaprojetofinal.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarroController {

    @GetMapping
    public String helloWebWorld(){
        return "Hello World";
    }
}
