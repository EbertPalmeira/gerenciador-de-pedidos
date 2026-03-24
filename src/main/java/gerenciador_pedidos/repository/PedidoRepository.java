package gerenciador_pedidos.repository;

import gerenciador_pedidos.model.Pedido;
import gerenciador_pedidos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
