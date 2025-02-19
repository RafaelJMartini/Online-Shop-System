package model;

import java.io.Serializable;

public abstract class Produto implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private double preco;
private String nome;
private String marca;
private int cod;





public boolean equals(int codigo) {
	if(this.cod == codigo) {
		return true;
	}
	else
		return false;
}

public Produto(double preco, String nome, String marca, int cod) {
	super();
	this.preco = preco;
	this.nome = nome;
	this.marca = marca;
	this.cod = cod;
}







public int getCod() {
	return cod;
}

public void setCod(int cod) {
	this.cod = cod;
}

public double getPreco() {
	return preco;
}

public void setPreco(double preco) {
	this.preco = preco;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getMarca() {
	return marca;
}

public void setMarca(String marca) {
	this.marca = marca;
}





public abstract double precoComDesconto();

public abstract String apresenta();

public abstract String guarda();
}
