package metricas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ComplejidadCiclomatica {

	public static void leerArchivoYMostrar(final String rutaArchivo){
		try {
			List<String> metodo = Files.readAllLines(Paths.get(rutaArchivo));
			Integer cc = ComplejidadCiclomatica.calcular(metodo);
			System.out.println("Complejidad ciclomatica: "+cc.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Integer calcular(List<String> metodo){
		Integer complejidad = 0;
		
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
		
		return complejidad + 1;
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

}
