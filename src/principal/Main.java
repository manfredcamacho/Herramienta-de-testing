package principal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import metricas.CantidadComentarios;
import metricas.CantidadLineas;
import metricas.ComplejidadCiclomatica;
import metricas.Halstead;
import metricas.Metrica;

public class Main {
	public static void main(String[] args) {
		leerArchivoYMostrar("src/metodo.txt");
	}
	
	public static void leerArchivoYMostrar(final String rutaArchivo){
		try {
			List<String> metodo = Files.readAllLines(Paths.get(rutaArchivo));
			
			List<Metrica> metricas = new ArrayList<Metrica>();
			metricas.add(new CantidadLineas());
			metricas.add(new CantidadComentarios());
			metricas.add(new Halstead());
			metricas.add(new ComplejidadCiclomatica());
			
			for(Metrica metrica : metricas){
				metrica.calcular(metodo);
				System.out.println(metrica.obtenerResultado());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
