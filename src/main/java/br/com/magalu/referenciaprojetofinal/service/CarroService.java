package br.com.magalu.referenciaprojetofinal.service;

import br.com.magalu.referenciaprojetofinal.domain.entity.Carro;
import br.com.magalu.referenciaprojetofinal.domain.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public Carro salvarCarro(Carro carro){
        // objeto.getnullo.equals(valor)
        //Const.equals(objeto.getnullo)
        //objeto.getnullo == null
        return carroRepository.save(carro);
    }

    public List<Carro> list(){
        return (List<Carro>) carroRepository.findAll();
    }

    public Carro updateCarro(Carro carro){
        Carro retorno = carroRepository.getOne(carro.getId());
        if(retorno != null){
            retorno.setNome(carro.getNome());
            retorno.setCor(carro.getCor());
            retorno.setAno(carro.getAno());
            carroRepository.save(retorno);
        }
        return carroRepository.save(carro);
    }

    public void deletarCarro(Long id){
        Carro retorno = carroRepository.getOne(id);
        if(retorno != null){
            carroRepository.deleteById(id);
        }
    }

}
