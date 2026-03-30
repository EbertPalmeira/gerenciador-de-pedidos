package gerenciador_pedidos;

import gerenciador_pedidos.model.Categoria;
import gerenciador_pedidos.model.Pedido;
import gerenciador_pedidos.model.Produto;
import gerenciador_pedidos.repository.CategoriaRepository;
import gerenciador_pedidos.repository.PedidoRepository;
import gerenciador_pedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

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
		Scanner scanner = new Scanner(System.in);


		salvarDadosIniciais();


//		System.out.print("Informe o nome do produto: ");
//		String nomeProduto = scanner.nextLine();
//
//		buscarProdutoPorNome(nomeProduto);

//		System.out.println("Informe a categoria");
//		String nomeCategoria = scanner.nextLine();
//
//		buscarCategoria(nomeCategoria);

		System.out.println("Informe o valor");
		Double valorProduto = Double.valueOf(scanner.nextLine());
		buscarProdutoPorPreco(valorProduto);

		scanner.close();
	}


	private void salvarDadosIniciais() {
		System.out.println("\n=== SALVANDO DADOS INICIAIS ===");


//		Categoria categoria = new Categoria("blusas");
//		categoriaRepository.save(categoria);
//
//
//		Produto produto = new Produto();
//		produto.setNome("camisa verde");
//		produto.setPreco(150.00);
//		produto.setCategoria(categoria);
//		produtoRepository.save(produto);
//
//		// Criar pedido
//		Pedido pedido = new Pedido(LocalDate.now());
//		pedidoRepository.save(pedido);
//
//		System.out.println("✅ Dados salvos com sucesso!");
	}


	private void buscarProdutoPorNome(String nome) {
		System.out.println("\n=== RESULTADO DA BUSCA ===");

		List<Produto> produtosEncontrados = produtoRepository.findByNomeContaining(nome);

		if (produtosEncontrados.isEmpty()) {
			System.out.println(" Nenhum produto encontrado com o nome: " + nome);
		} else {
			System.out.println(" Produtos encontrados:");
			for (Produto produto : produtosEncontrados) {
				System.out.println("  ID: " + produto.getId() +
						" | Nome: " + produto.getNome() +
						" | Preço: R$ " + produto.getPreco() +
						" | Categoria: " + (produto.getCategoria() != null ?
						produto.getCategoria().getNome() : "Sem categoria"));
			}
			System.out.println("Total encontrado: " + produtosEncontrados.size());
		}
	}

	private void buscarCategoria(String categoria){
		List<Categoria> categoriasEncontradas = categoriaRepository.findByNome(categoria);

		for (Categoria cat : categoriasEncontradas) {
			System.out.println("id :" + cat.getId() + "Nome : " + cat.getNome());
		}

	}

	private void buscarProdutoPorPreco(Double valor){
		List<Produto> valorMaiorEncontrado = produtoRepository.findByPrecoGreaterThan(valor);
		List<Produto> valorMenorEncontrado = produtoRepository.findByPrecoLessThan(valor);


//		for (Produto p : valorMaiorEncontrado){
//			System.out.println("Id : "+ p.getId() + "Nome : " + p.getNome());
//		}

		for (Produto p : valorMenorEncontrado){
			System.out.println("Id : "+ p.getId() + "Nome : " + p.getNome());
		}

	}


}