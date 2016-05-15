package metricas;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ComplejidadCiclomatica  implements Metrica {
	
	private Integer complejidad;
	
	public String getNombre() {
		return "Complejidad ciclomática";
	}

	public void calcular(List<String> metodo) {
		this.complejidad = 0;
		
		for(String linea : metodo){
			
			linea = normalizar(linea);
			
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
	
	private static String normalizar(String linea){
		String lineaNormalizada = linea;
		
		//borrar comentarios
		if(linea.contains("//")){
			lineaNormalizada = lineaNormalizada.substring( 0, lineaNormalizada.indexOf("//") );
		}
		
		return lineaNormalizada
			.trim()
			.toLowerCase()
			.replaceAll("\\t", "")
			.replaceAll("\\n", "")
			//borrar todo entre comillas
			.replaceAll("\".*?\"", "\"\"")
			//aseguramos al menos un espacio antes y después de los siguientes caracteres
			.replaceAll("\\(", " ( ")
			.replaceAll("\\)", " ) ")
			.replaceAll("\\{", " { ")
			.replaceAll("\\}", " } ")
			.replaceAll("\\,", " , ")
			.replaceAll("\\;", " ; ")
			.replaceAll("\\&\\&", " && ")
			.replaceAll("\\|\\|", " || ")
			.replaceAll("\\?", " ? ")
			//unificar multiples espacios
			.replaceAll("( )+", " ");
	}

	public String obtenerResultado() {
		return String.format("%s: %s", this.getNombre(), this.complejidad);
	}

}
