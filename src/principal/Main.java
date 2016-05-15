package principal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import entidades.Metodo;
import metricas.CantidadComentarios;
import metricas.CantidadLineas;
import metricas.ComplejidadCiclomatica;
import metricas.Halstead;
import metricas.Metrica;

public class Main {
	public static void main(String[] args) {
		leerArchivoYMostrar();
	}
	
	public static void leerArchivoYMostrar(){
		try {
			List<String> codigoMetodo = Files.readAllLines(Paths.get("src/metodo.txt"));
			Metodo metodo = new Metodo("Prueba", null, codigoMetodo);
			
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
