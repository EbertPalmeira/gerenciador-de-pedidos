package gerenciador_pedidos.repository;

import gerenciador_pedidos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

    List<Produto> findByNomeContaining(String produto);
    List<Produto> findByPrecoGreaterThan(Double preco);
    List<Produto> findByPrecoLessThan(Double preco);

}
