package br.com.magalu.referenciaprojetofinal.service;

import br.com.magalu.referenciaprojetofinal.domain.entity.Carro;
import br.com.magalu.referenciaprojetofinal.domain.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroService {


    @Autowired
    private CarroRepository carroRepository;

    public Carro adicionarCarro(){
        return carroRepository.save(new Carro("Uno", "XP1234", "2012", "branco"));
    }
}
