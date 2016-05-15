package principal;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import entidades.Clase;
import entidades.Metodo;
import lector.LectorJavaParser;
import metricas.CantidadComentarios;
import metricas.CantidadLineas;
import metricas.ComplejidadCiclomatica;
import metricas.Halstead;
import metricas.Metrica;

public class HerramientaTesting {

	private List<Clase> leerProyecto;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void leerProyecto(File rutaProyecto){
		this.leerProyecto = new LectorJavaParser().leerProyecto(rutaProyecto);
	}
	
	public void calcularMetricas(Metodo metodo){
		List<Metrica> metricas = new ArrayList<Metrica>();
		metricas.add(new CantidadLineas());
		metricas.add(new CantidadComentarios());
		metricas.add(new Halstead());
		metricas.add(new ComplejidadCiclomatica());
		
		for(Metrica metrica : metricas){
			metrica.calcular(metodo);
			System.out.println(metrica.obtenerResultado());
		}
	}
}
