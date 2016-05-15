package metricas;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import entidades.Metodo;

public class ComplejidadCiclomatica  implements Metrica {
	
	private Integer complejidad;
	
	public String getNombre() {
		return "Complejidad ciclomática";
	}

	public void calcular(Metodo metodo) {
		List<String> codigo = metodo.getCodigo();
		this.complejidad = 0;
		
		for(String linea : codigo){
			
			linea = StringAyuda.normalizar(linea);
			
			complejidad += StringUtils.countMatches(linea, "if (")
						 + StringUtils.countMatches(linea, "while (")
						 + StringUtils.countMatches(linea, "for (")
						 + StringUtils.countMatches(linea, " && ")
						 + StringUtils.countMatches(linea, " || ")
						 + StringUtils.countMatches(linea, " ? ")
						 + StringUtils.countMatches(linea, "case ")
						 + StringUtils.countMatches(linea, "catch (");
		}
		
		this.complejidad += 1;
	}
	
	public String obtenerResultado() {
		return String.format("%s: %s", this.getNombre(), this.complejidad);
	}

}
