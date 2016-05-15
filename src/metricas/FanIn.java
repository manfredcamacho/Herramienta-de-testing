package metricas;

import java.util.List;

import entidades.Clase;
import entidades.Metodo;

public class FanIn implements Metrica {

	private List<Clase> proyecto;
	private Integer fanIn;
	
	public FanIn (List<Clase> proyecto){
		this.proyecto = proyecto;
	}
	
	public String getNombre() {
		return "Fan In";
	}

	public void calcular(Metodo metodo) {
		this.fanIn = 0;
		
		for(Clase claseProyecto : this.proyecto){
			for(Metodo metodoClaseProyecto : claseProyecto.getMetodos()){
				this.fanIn += StringAyuda.cantidadOcurrenciasMetodo(metodo.getNombre(), metodoClaseProyecto.getCodigo());
			}
		}
		
//		Entrada: nombre del metodo a buscar
//
//		Iterar Clases
//		-> Iterar Metodo Proyecto
//			   -> Iterar Lineas de Codigo Metodo Proyecto
//			   		-> Guardar cantidad de veces que contiene la linea de metodo proyecto al nombre del metodo a buscar
		
	}

	public String obtenerResultado() {
		return String.format("%s : %s", this.getNombre(), this.fanIn);
	}

}
