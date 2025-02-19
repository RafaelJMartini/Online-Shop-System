package visualizacao;

import java.util.ArrayList;
import java.util.Scanner;

import excecoes.ExcecaoDeNumeroMaximoDeProdutos;
import model.Cliente;
import model.ListaClientes;
import model.ListaPedidos;
import model.ListaProdutos;
import model.Produto;
import persistencia.Persistencia;
import excecoes.ExcecaoDeClienteJaExistente;
import excecoes.ExcecaoDeClienteNaoEncontrado;
import excecoes.ExcecaoDeNumeroMaximoDePedidos;
import excecoes.ExcecaoDeProdutoJaExistente;
import excecoes.ExcecaoDeProdutoNaoEncontrado;


public class GUI {
	private Scanner entrada = new Scanner(System.in);
	private ListaClientes listac = new ListaClientes();
	private ListaProdutos listap = new ListaProdutos(100);
	private ListaPedidos listapedidos = new ListaPedidos(100);
	private int codigocontadorpedidos = 0;
	private Persistencia persistencia;
	public GUI(Persistencia persiste) {
		this.persistencia = persiste;
	}
	
	public void menu() {
		//variaveis locais
		int opcao,codigo;
		String nome,cpf,marca,tamanho;
		double preco;
		
		
		System.out.println("Iniciando a loja...");
		
		listap = persistencia.recuperaListaProdutos();
		listac = persistencia.recuperaListaClientes();
		listapedidos = persistencia.recuperaListaPedidos();
		
		
		System.out.println("0 - Sair");
		System.out.println("1 - Incluir clientes");
		System.out.println("2 - Incluir eletrônicos e roupas");
		System.out.println("3 - Fazer pedido");
		System.out.println("4 - Clientes cadastrados");
		System.out.println("5 - Produtos cadastrados");
		System.out.println("6 - Pedidos");
	
		opcao = entrada.nextInt();
		entrada.nextLine();
		while(opcao!=0) {
			switch(opcao) {
			case 1:
				System.out.println("Digite o nome do cliente:");
				nome = entrada.nextLine();
				System.out.println("Digite o CPF do cliente:");
				cpf = entrada.nextLine();
				try {
				listac.inserirCliente(nome, cpf);
				}
				catch(ExcecaoDeClienteJaExistente e){
					System.out.println("Cliente já está na lista!");
				}
				break;
			case 2:
				int escolha;
				System.out.println("Qual produto você deseja incluir?");
				System.out.println("0 - Voltar");
				System.out.println("1 - Eletrônico");
				System.out.println("2 - Roupa");
				escolha = entrada.nextInt();
				if(escolha == 1) {
					System.out.println("Código: ");
					codigo = entrada.nextInt();
					entrada.nextLine();
					System.out.println("Nome: ");
					nome = entrada.nextLine();
					System.out.println("Marca: ");
					marca = entrada.nextLine();
					System.out.println("Preço: ");
					preco = entrada.nextDouble();
					entrada.nextLine();
					try {
					listap.inserirProduto(codigo, preco, nome, marca);
					}
					catch(ExcecaoDeProdutoJaExistente e) {
						System.out.println("Há um produto cadastrado com o mesmo código!");
					}
					catch(ExcecaoDeNumeroMaximoDeProdutos e) {
						System.out.println("Não há mais espaço na lista!");
					}
				}
				else if(escolha == 2) {
					System.out.println("Código: ");
					codigo = entrada.nextInt();
					entrada.nextLine();
					System.out.println("Nome: ");
					nome = entrada.nextLine();
					System.out.println("Marca: ");
					marca = entrada.nextLine();
					System.out.println("Preço: ");
					preco = entrada.nextDouble();
					entrada.nextLine();
					System.out.println("Tamanho:");
					tamanho = entrada.nextLine();
					try {
						listap.inserirProduto(codigo, preco, nome, marca,tamanho);
					} catch (ExcecaoDeProdutoJaExistente e) {
						System.out.println("Há um produto cadastrado com o mesmo código!");
					}
					catch(ExcecaoDeNumeroMaximoDeProdutos e) {
						System.out.println("Não há mais espaço na lista!");
					}
				}
				break;
			case 3:
				
				double precofinal = 0;
				Cliente cliente = null;
				ArrayList<Produto> produto = new ArrayList<Produto>();
				ArrayList<Integer> quant = new ArrayList<Integer>();
				int quantidadeum;
				
				//adicionando o Cliente
				System.out.println("Digite o cpf: ");
				cpf = entrada.nextLine();
				
				
					try {
					cliente = new Cliente(listac.getClienteCpf(cpf));
					}
					catch(ExcecaoDeClienteNaoEncontrado e) {
						System.out.println("Não há nenhum cliente com esse CPF!");
						break;
					}
				
				//adicionando os produtos
					int aux = 1;
					while(aux != 0) {
					System.out.println("Digite o código do produto: ");
					codigo = entrada.nextInt();
					try {
					produto.add(listap.getProdutoCod(codigo));
					preco = listap.getProdutoCod(codigo).precoComDesconto();
					}
					catch(ExcecaoDeProdutoNaoEncontrado e){
						System.out.println("Não há nenhum produto com esse código!");
						break;
					}
					System.out.println("Digite a quantidade: ");
					quantidadeum = entrada.nextInt();
					precofinal = precofinal + (preco*quantidadeum);
					quant.add(quantidadeum);
					
					System.out.println("Deseja adicionar mais algum produto?");
					System.out.println("1 - Sim");
					System.out.println("0 - Não");
					aux = entrada.nextInt();
					}
					
					try {
						listapedidos.inserirPedido(cliente, produto, quant, codigocontadorpedidos++,precofinal);
					}
					catch(ExcecaoDeNumeroMaximoDePedidos e){
						System.out.println("O sistema atingiu o número máximo de pedidos!");
						break;
					}
					
				break;
			case 4:
				if(listac.tamanho() == 0) {
					System.out.println("Não há nenhum cliente cadastrado!");
				}
				else
				for(int i = 0;i<listac.tamanho();i++) {
					System.out.println("Cliente "+(i+1)+":");
					System.out.println(listac.get(i).getNome());
					System.out.println(listac.get(i).getCpf());
				}
			
				break;
			case 5:
				if(listap.tamanho() == 0) {
					System.out.println("Não há nenhum produto cadastrado!");
				}
				else
				for(int i = 0;i<listap.tamanho();i++) {
					System.out.println("Produto "+(i+1)+":");
					System.out.println(listap.get(i).apresenta());
				}
				break;
			case 6:
				if(listapedidos.tamanho() == 0) {
					System.out.println("Não há nenhum pedido cadastrado!");
				}
				else
					for(int i = 0;i<listapedidos.tamanho();i++) {
						System.out.println("Pedido "+(i+1)+":");
						System.out.println("Cliente: "+listapedidos.get(i).getCliente().getNome());
						for(int j = 0;j<listapedidos.get(i).getProdutos().size();j++) {
							System.out.println("Produto "+(j+1)+": "+listapedidos.get(i).getProdutos().get(j).apresenta());
							System.out.print("Quantidade: "+listapedidos.get(i).getQuantidade().get(j));
							System.out.print("\tPreço sem desconto: "+(listapedidos.get(i).getProdutos().get(j).getPreco()*listapedidos.get(i).getQuantidade().get(j)));
							System.out.println("Preço com desconto: "+(listapedidos.get(i).getProdutos().get(j).precoComDesconto()*listapedidos.get(i).getQuantidade().get(j)));
						}
						System.out.println();
						System.out.println("Preço final: "+listapedidos.get(i).getPrecofinal()+" reais");
					}
				break;
				
			default:
				System.out.println("Tente novamente!");
			}//fim do switch
			System.out.println("0 - Sair");
			System.out.println("1 - Incluir clientes");
			System.out.println("2 - Incluir eletrônicos e roupas");
			System.out.println("3 - Fazer pedido");
			System.out.println("4 - Clientes cadastrados");
			System.out.println("5 - Produtos cadastrados");
			System.out.println("6 - Pedidos");
			
			opcao = entrada.nextInt();
			entrada.nextLine();
		}//fim do while
		persistencia.gravaListaProdutos(listap);
		persistencia.gravaListaClientes(listac);
		persistencia.gravaListaPedidos(listapedidos);
	
	
	
	
	
	
	
	
	
	}
	
}