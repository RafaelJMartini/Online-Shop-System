package model;

import java.io.Serializable;

public class Eletronico extends Produto implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;




	public Eletronico(double preco, String nome, String marca, int cod) {
		super(preco, nome, marca, cod);
		// TODO Auto-generated constructor stub
	}




	@Override
	public double precoComDesconto() {
		return this.getPreco()*0.95;
	}

	@Override
	public String apresenta() {
		return "Nome: "+this.getNome()+"\tCódigo: "+this.getCod()+"\tMarca: "+this.getMarca()+"\tPreço: "+this.getPreco();
	}




	@Override
	public String guarda() {
		// TODO Auto-generated method stub
		return this.getPreco()+";"+this.getNome()+";"+this.getMarca()+";"+this.getCod();
	}

	
	
	
	
}
