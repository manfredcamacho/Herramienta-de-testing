package metricas;

import java.util.List;

import entidades.Clase;
import entidades.Metodo;

public class FanOut implements Metrica {

	private List<Clase> proyecto;
	private Integer fanOut;
	
	public FanOut (List<Clase> proyecto){
		this.proyecto = proyecto;
	}
	
	public String getNombre() {
		return "Fan Out";
	}

	public void calcular(Metodo metodo) {
		List<String> codigo = metodo.getCodigo();
		this.fanOut = 0;
		
//		Entrada: codigo del metodo a buscar
//
//		Iterar Clases
//		-> Iterar Metodos Proyecto
//			   -> Iterar lineas de codigo del metodo a buscar
//			   		-> Guardar cantidad de veces que contiene cada linea del codigo del metodo a buscar al nombre del metodo proyecto
		
		
	}

	public String obtenerResultado() {
		return String.format("%s : %s", this.getNombre(), this.fanOut);
	}

}
