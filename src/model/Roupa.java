package model;

import java.io.Serializable;

public class Roupa extends Produto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Roupa(double preco, String nome, String marca, int cod, String tamanho) {
		super(preco, nome, marca, cod);
		this.tamanho = tamanho;
	}



	private String tamanho;
	
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}



	@Override
	public double precoComDesconto() {
		return this.getPreco()*0.8;
	}
	@Override
	public String apresenta() {
		return "Nome: "+this.getNome()+"\tCódigo: "+this.getCod()+"\tMarca: "+this.getMarca()+"\tTamanho: "+this.getTamanho()+"\tPreço: "+this.getPreco();
	}
	@Override
	public String guarda() {
		// TODO Auto-generated method stub
		return this.getPreco()+";"+this.getNome()+";"+this.getMarca()+";"+this.getCod()+";"+this.getTamanho();
	}

	
	
	
}
