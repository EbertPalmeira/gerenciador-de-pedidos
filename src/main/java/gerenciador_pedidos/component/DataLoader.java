package gerenciador_pedidos.component;

import gerenciador_pedidos.repository.CategoriaRepository;
import gerenciador_pedidos.repository.PedidoRepository;
import gerenciador_pedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

@Component
public class DataLoader {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @PostConstruct
    public void salvarDados() {

    }
}