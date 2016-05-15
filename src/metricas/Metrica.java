package metricas;

import entidades.Metodo;

public interface Metrica {

	public String getNombre();
	public void calcular(Metodo metodo);
	public String obtenerResultado();
	
}
