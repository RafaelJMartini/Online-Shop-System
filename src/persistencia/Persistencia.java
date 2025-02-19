package persistencia;
import model.ListaProdutos;
import model.ListaPedidos;
import model.ListaClientes;

public interface Persistencia {

	public void gravaListaProdutos(ListaProdutos listap);
	public ListaProdutos recuperaListaProdutos();
	public void gravaListaClientes(ListaClientes listac);
	public ListaClientes recuperaListaClientes();
	public void gravaListaPedidos(ListaPedidos listapedidos);
	public ListaPedidos recuperaListaPedidos();
	
}
