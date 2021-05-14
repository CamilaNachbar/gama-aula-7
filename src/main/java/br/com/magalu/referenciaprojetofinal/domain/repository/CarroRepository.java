package br.com.magalu.referenciaprojetofinal.domain.repository;

import br.com.magalu.referenciaprojetofinal.domain.entity.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
    public List<Carro> findByAno(String ano);

    public void deleteById(Long id);

    @Query(value = "select produto.*, cliente.nome_fantasia " +
            "from Produto as produto inner join  " +
            "Wishlist  as wishlist on " +
            "(produto.id_produto = wishlist.id_produto)" +
            "inner join Cliente  as cliente  on" +
            "(cliente.id_cliente = wishlist.id_cliente) " +
            "where cliente.id_cliente = :id" +
            "group by carro.id_carro, cliente.id_cliente", nativeQuery = true)
    public List<Object> retornaProdutoNaWishlist(@Param("id") Long id);

    @Query(value = "select cliente.nome_fantasia from Produto as produto inner join  Wishlist  as wishlist on " +
            "(produto.id_produto = wishlist.id_produto)" +
            "inner join Cliente  as cliente  on " +
            "(cliente.id_cliente = wishlist.id_cliente) where cliente.id_cliente = :id_cliente " +
            "and produto.id_produto = :id_produto" +
            " group by carro.id_carro, cliente.id_cliente", nativeQuery = true)
    public List<Object> retornaDeterminadoProdutoNaWishlist(@Param("id_cliente") Long idCliente, @Param("id_produto") Long idProduto);

}
