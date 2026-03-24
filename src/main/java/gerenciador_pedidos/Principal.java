package gerenciador_pedidos;

import gerenciador_pedidos.model.Categoria;
import gerenciador_pedidos.model.Pedido;
import gerenciador_pedidos.model.Produto;
import gerenciador_pedidos.repository.PedidoRepository;
import gerenciador_pedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import gerenciador_pedidos.repository.CategoriaRepository;
@SpringBootApplication
@EnableJpaRepositories(basePackages = "gerenciador_pedidos.repository")
public class Principal implements CommandLineRunner {


	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Principal.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		List<Produto> produtos = new ArrayList<>();

		Produto p1 = new Produto();
		p1.setNome("camisa verde");
		p1.setPreco(150.00);
		produtos.add(p1);
		produtoRepository.save(p1);

		List<Pedido> pedidos = new ArrayList<>();

		Pedido p2 = new Pedido(LocalDate.of(2026, 3, 20));
		pedidoRepository.save(p2);


		List<Categoria> categorias = new ArrayList<>();

		Categoria c1 = new Categoria();
		c1.setNome("blusas");
		categoriaRepository.save(c1);

	}
}
