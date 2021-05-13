package br.com.magalu.referenciaprojetofinal.domain.repository;

import br.com.magalu.referenciaprojetofinal.domain.entity.Concessionária;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcessionariaRepository extends JpaRepository<Concessionária, Long> {
}
