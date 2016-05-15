package metricas;

import java.util.List;

import entidades.Metodo;

public class CantidadLineas implements Metrica {
	
	private Integer cantidadLineas;
	
	public String getNombre() {
		return "Cantidad de lineas";
	}

	public void calcular(Metodo metodo) {
		List<String> codigo = metodo.getCodigo();
		this.cantidadLineas = codigo.size();
	}

	public String obtenerResultado() {
		return String.format("%s: %s", this.getNombre(), this.cantidadLineas);
	}
}
