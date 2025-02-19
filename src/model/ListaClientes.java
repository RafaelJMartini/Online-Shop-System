package model;

import java.io.Serializable;
import java.util.ArrayList;

import excecoes.ExcecaoDeClienteJaExistente;
import excecoes.ExcecaoDeClienteNaoEncontrado;

/**
 * Classe que implementa uma lista de clientes.
 *
 * @author Rafael Martini
 * @version 16/06/2024
 */
public class ListaClientes implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

public Cliente getClienteCpf(String cpf) throws ExcecaoDeClienteNaoEncontrado{
	if(clientes.isEmpty()) {
		throw new ExcecaoDeClienteNaoEncontrado();
	}
	
	if(clientes.get(0).getCpf() == null) {
		throw new ExcecaoDeClienteNaoEncontrado();
	}

	for(Cliente c : clientes) {
		if(c.equals(cpf)) {
			return c;
		}
	}
	throw new ExcecaoDeClienteNaoEncontrado();
}

public void inserirCliente(String nome,String cpf) throws ExcecaoDeClienteJaExistente{
	for(Cliente c : clientes) {
		if(c.equals(cpf)) {
			throw new ExcecaoDeClienteJaExistente();
		}
	}
	Cliente adicional = new Cliente(nome,cpf);
	this.clientes.add(adicional);
}

public int tamanho() {
	return clientes.size();
}

public Cliente get(int indice) {
	return clientes.get(indice);
}



public void apresentarListaDeClientes() {
	
}





}
