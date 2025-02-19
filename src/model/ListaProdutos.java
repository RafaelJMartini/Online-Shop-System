package model;

import java.io.Serializable;
import java.util.ArrayList;

import excecoes.ExcecaoDeNumeroMaximoDeProdutos;
import excecoes.ExcecaoDeProdutoJaExistente;
import excecoes.ExcecaoDeProdutoNaoEncontrado;


public class ListaProdutos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	private int capacidade;
	
	public ListaProdutos(int capacidade) {
		this.capacidade = capacidade;
	}
	
	public int tamanho() {
		return produtos.size();
	}
	
	public Produto get(int indice) {
		return produtos.get(indice);
	}
	
	public  void  inserirProduto(Produto produto)  // sobrecarga de método - method overloading
			throws ExcecaoDeNumeroMaximoDeProdutos, ExcecaoDeProdutoJaExistente
	{
		if(produtos.size() == this.capacidade) {
			throw new ExcecaoDeNumeroMaximoDeProdutos();
		}
		for(Produto p : produtos) {
			if(produto.getCod() == p.getCod()) {
				throw new ExcecaoDeProdutoJaExistente();
			}
				
		}
		this.produtos.add(produto);

	}
	
	
	
	public Produto getProdutoCod(int codigo) throws ExcecaoDeProdutoNaoEncontrado{
			for(Produto p : produtos) {
				if(p.equals(codigo)) {
					return p;
				}
			}
			throw new ExcecaoDeProdutoNaoEncontrado();
	}
	
	private boolean VerificaProduto(int codigo) {
		for(Produto p : produtos) {
			if(p.equals(codigo)) {
				return false;
			}
		}
		return true;
	}
	
	
	
	public void inserirProduto(int codigo,double preco,String nome,String marca, String tamanho) throws ExcecaoDeNumeroMaximoDeProdutos,ExcecaoDeProdutoJaExistente{
		if(produtos.size() == capacidade) {
			throw new ExcecaoDeNumeroMaximoDeProdutos();	
		}
		if(VerificaProduto(codigo)) {
			produtos.add(new Roupa(preco, nome, marca, codigo, tamanho));
		}
		else {
			throw new ExcecaoDeProdutoJaExistente();
		}
	}
	
	public void inserirProduto(int codigo,double preco,String nome,String marca) throws ExcecaoDeNumeroMaximoDeProdutos,ExcecaoDeProdutoJaExistente{
		if(produtos.size() == capacidade) {
			throw new ExcecaoDeNumeroMaximoDeProdutos();
		}
		
		if(VerificaProduto(codigo)) {
			produtos.add(new Eletronico(preco, nome, marca, codigo));
		}
		else {
			throw new ExcecaoDeProdutoJaExistente();
		}
	}
	
	
	
	
	
}
