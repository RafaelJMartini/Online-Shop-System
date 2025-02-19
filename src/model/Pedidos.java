package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedidos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cliente cliente;
	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	private ArrayList<Integer> quantidade = new ArrayList<Integer>();
	private int codpedido;
	private double precofinal;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Pedidos(Cliente cliente, ArrayList<Produto> produto, ArrayList<Integer> quantidade,int codpedido,double precofinal) {
		super();
		this.cliente = cliente;
		for(int i = 0;i<produto.size() ;i++) {
		this.produtos.add(produto.get(i));
		this.quantidade.add(quantidade.get(i));
		}
		this.precofinal = precofinal;
		
	}
	
	public boolean equals(int codigo) {
		if(this.codpedido == codigo) {
			return true;
		}
		else
			return false;
	}
	
	
	
	
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	public ArrayList<Integer> getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(ArrayList<Integer> quantidade) {
		this.quantidade = quantidade;
	}
	public double getPrecofinal() {
		return precofinal;
	}
	public void setPrecofinal(double precofinal) {
		this.precofinal = precofinal;
	}
	
	
	
}
