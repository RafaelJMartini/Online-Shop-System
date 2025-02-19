package persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.ListaClientes;
import model.ListaPedidos;
import model.ListaProdutos;

public class Serializavel implements Persistencia{

	@Override
	public void gravaListaProdutos(ListaProdutos listap) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("objetosProduto"));
			oos.writeObject(listap);
			oos.close();
		}
		catch(IOException e) {
			System.out.println("Erro de IO!");
		}
		
	}

	@Override
	public ListaProdutos recuperaListaProdutos() {
		ListaProdutos listap = new ListaProdutos(100);
		
		try {
			ObjectInputStream oos = new ObjectInputStream(new FileInputStream("objetosProduto"));
			Object t = oos.readObject();
			listap = (ListaProdutos) t ;
			oos.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Iniciando com um novo arquivo de produtos!");
		}
		catch(IOException e) {
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listap ;
	}

	@Override
	public void gravaListaClientes(ListaClientes listac) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("objetosClientes"));
			oos.writeObject(listac);
			oos.close();
		}
		catch(IOException e) {
			System.out.println("Erro de IO!");
		}
		
	}

	@Override
	public ListaClientes recuperaListaClientes() {
		ListaClientes listac = new ListaClientes();
		
		try {
			ObjectInputStream oos = new ObjectInputStream(new FileInputStream("objetosClientes"));
			Object t = oos.readObject();
			listac = (ListaClientes) t ;
			oos.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Iniciando com um novo arquivo de clientes!");
		}
		catch(IOException e) {
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listac ;
	}

	@Override
	public void gravaListaPedidos(ListaPedidos listapedidos) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("objetosPedidos"));
			oos.writeObject(listapedidos);
			oos.close();
		}
		catch(IOException e) {
			System.out.println("Erro de IO!");
		}
		
	}

	@Override
	public ListaPedidos recuperaListaPedidos() {
		ListaPedidos listapedidos = new ListaPedidos(100);
		
		try {
			ObjectInputStream oos = new ObjectInputStream(new FileInputStream("objetosPedidos"));
			Object t = oos.readObject();
			listapedidos = (ListaPedidos) t ;
			oos.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("Iniciando com um novo arquivo de pedidos!");
		}
		catch(IOException e) {
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listapedidos ;
	}

}
