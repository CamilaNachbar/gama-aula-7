package br.com.magalu.referenciaprojetofinal.domain.repository;

import br.com.magalu.referenciaprojetofinal.domain.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
    public List<Carro> findByAno(String ano);

    public void deleteById(Long id);

}
