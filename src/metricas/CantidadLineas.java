package metricas;

import java.util.List;

public class CantidadLineas implements Metrica {
	
	private Integer cantidadLineas;
	
	public String getNombre() {
		return "Cantidad de lineas";
	}

	public void calcular(List<String> metodo) {
		this.cantidadLineas = metodo.size();
	}

	public String obtenerResultado() {
		return String.format("%s: %s", this.getNombre(), this.cantidadLineas);
	}
}
