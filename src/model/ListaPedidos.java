package model;

import java.io.Serializable;
import java.util.ArrayList;

import excecoes.ExcecaoDeNumeroMaximoDePedidos;

public class ListaPedidos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Pedidos> pedidos = new ArrayList<Pedidos>();
	private int capacidade;
	
	public ListaPedidos(int capacidade) {
		this.capacidade = capacidade;
	}
	
	public int tamanho() {
		return pedidos.size();
	}
	
	public Pedidos get(int indice) {
		return pedidos.get(indice);
	}
	
	
	public void inserirPedido(Cliente cliente, ArrayList<Produto> produto, ArrayList<Integer> quantidade, int codpedido,double precofinal) throws ExcecaoDeNumeroMaximoDePedidos{
		if(pedidos.size() == capacidade) {
			throw new ExcecaoDeNumeroMaximoDePedidos();
		}
		pedidos.add(new Pedidos(cliente,produto,quantidade,codpedido,precofinal));
	}
	
	
}
