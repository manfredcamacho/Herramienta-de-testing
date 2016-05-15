package metricas;

import java.util.List;

import entidades.Clase;

public class FanIn implements Metrica {

	private List<Clase> proyecto;
	private Integer fanIn;
	
	public FanIn (List<Clase> proyecto){
		this.proyecto = proyecto;
	}
	
	public String getNombre() {
		return "Fan In";
	}

	public void calcular(List<String> metodo) {
		// TODO Auto-generated method stub

	}

	public String obtenerResultado() {
		return String.format("%s : %s", this.getNombre(), this.fanIn);
	}

}
