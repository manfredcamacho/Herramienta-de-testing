package metricas;

import java.util.List;

public interface Metrica {

	public String getNombre();
	public void calcular(List<String> metodo);
	public String obtenerResultado();
	
}
