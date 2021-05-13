package br.com.magalu.referenciaprojetofinal.service;

import br.com.magalu.referenciaprojetofinal.domain.entity.Carro;
import br.com.magalu.referenciaprojetofinal.domain.entity.Concessionária;
import br.com.magalu.referenciaprojetofinal.domain.repository.CarroRepository;
import br.com.magalu.referenciaprojetofinal.domain.repository.ConcessionariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private ConcessionariaRepository concessionariaRepository;

    public Carro salvarCarro(Carro carro){
        //vai ter que buscar a concessionaria e salvar ou adicionar a mesma
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
            retorno.setConcessionarias(carro.getConcessionarias());
            carroRepository.save(retorno);
        }
        return carroRepository.save(carro);
    }

    public void deletarCarro(Long id){
        Carro retorno = carroRepository.getOne(id);
        retorno.getConcessionarias().removeAll(retorno.getConcessionarias());

        if(retorno != null){
            carroRepository.deleteById(id);
        }

    }

    public Carro inserirNaListaDeCarroAConcessionaria(Long id_carro, Long id_concessionaria){
        Carro retorno = carroRepository.getOne(id_carro);
        Concessionária concessionária = concessionariaRepository.getOne(id_concessionaria);

        retorno.getConcessionarias().add(concessionária);
        return carroRepository.save(retorno);

    }

    public List<Concessionária> buscarCarroEmConcessionaria(Long id){
        Carro retorno = carroRepository.getOne(id);
        return retorno.getConcessionarias();
    }

}
