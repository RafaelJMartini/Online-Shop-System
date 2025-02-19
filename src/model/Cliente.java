package model;

import java.io.Serializable;

public class Cliente implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String nome;
private String cpf;

public Cliente(String nome,String cpf) {
this.cpf = cpf;
this.nome = nome;
}

public Cliente(Cliente c) {
	this.cpf = c.getCpf();
	this.nome = c.getNome();
}


public boolean equals(String cpf) {
	for(int i=0;i<11;i++) {
		if(cpf.charAt(i) != this.cpf.charAt(i)) {
			return false;
		}
	}
	return true;
}

public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getCpf() {
	return cpf;
}
public void setCpf(String cpf) {
	this.cpf = cpf;
}

}
