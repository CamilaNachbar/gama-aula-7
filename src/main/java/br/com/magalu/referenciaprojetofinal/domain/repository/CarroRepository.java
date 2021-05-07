package br.com.magalu.referenciaprojetofinal.domain.repository;

import br.com.magalu.referenciaprojetofinal.domain.entity.Carro;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarroRepository extends CrudRepository<Carro, Long> {

    public List<Carro> findByAno(String ano);
}
