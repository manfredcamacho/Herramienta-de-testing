package metricas;

import java.util.List;

import entidades.Clase;

public class FanOut implements Metrica {

	private List<Clase> proyecto;
	private Integer fanOut;
	
	public FanOut (List<Clase> proyecto){
		this.proyecto = proyecto;
	}
	
	public String getNombre() {
		return "Fan Out";
	}

	public void calcular(List<String> metodo) {
		// TODO Auto-generated method stub

	}

	public String obtenerResultado() {
		return String.format("%s : %s", this.getNombre(), this.fanOut);
	}

}
