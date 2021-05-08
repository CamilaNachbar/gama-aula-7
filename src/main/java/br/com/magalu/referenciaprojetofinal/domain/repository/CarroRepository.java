package br.com.magalu.referenciaprojetofinal.domain.repository;

import br.com.magalu.referenciaprojetofinal.domain.entity.Carro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarroRepository extends CrudRepository<Carro, Long> {

    public List<Carro> findByAno(String ano);
}
