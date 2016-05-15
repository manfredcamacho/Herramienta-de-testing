package principal;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import entidades.Clase;
import entidades.Metodo;
import lector.LectorJavaParser;
import metricas.CantidadComentarios;
import metricas.CantidadLineas;
import metricas.ComplejidadCiclomatica;
import metricas.FanIn;
import metricas.FanOut;
import metricas.Halstead;
import metricas.Metrica;

public class HerramientaTesting {

	private List<Clase> proyecto;
	
	public static void main(String[] args) {
		
		HerramientaTesting herramienta = new HerramientaTesting();
		
		File proyecto = new File("/home/nicolass/dev/unlam/analisissoftware/workspace/Triangulo");
		herramienta.leerProyecto(proyecto);
		
		new GUIConsola(herramienta).ejecutar();;
	}
	
	public void leerProyecto(File rutaProyecto){
		this.proyecto = new LectorJavaParser().leerProyecto(rutaProyecto);
	}
	
	public void calcularMetricas(Metodo metodo){
		
		List<Metrica> metricas = new ArrayList<Metrica>();
		metricas.add(new CantidadLineas());
		metricas.add(new CantidadComentarios());
		metricas.add(new Halstead());
		metricas.add(new ComplejidadCiclomatica());
		metricas.add(new FanIn(this.proyecto));
		metricas.add(new FanOut(this.proyecto));
		
		for(Metrica metrica : metricas){
			metrica.calcular(metodo);
			System.out.println(metrica.obtenerResultado());
		}
	}

	public List<Clase> getProyecto() {
		return proyecto;
	}
	
	
}
