package principal;

import visualizacao.GUI;
import persistencia.Serializavel;

public class Iniciar {

	public static void main(String[] args) {
		Serializavel persist = new Serializavel();
		GUI inicia = new GUI(persist);
		inicia.menu();
	}
	
}
