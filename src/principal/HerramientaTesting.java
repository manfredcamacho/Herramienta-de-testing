package principal;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import entidades.Clase;
import entidades.Metodo;
import interfaz.Consola;
import lector.LectorJavaParser;
import metricas.Metrica;
import metricas.ResultadoMetrica;
import metricas.impl.CantidadComentarios;
import metricas.impl.CantidadLineas;
import metricas.impl.ComplejidadCiclomatica;
import metricas.impl.FanIn;
import metricas.impl.FanOut;
import metricas.impl.Halstead;

public class HerramientaTesting {

	private List<Clase> proyecto;
	
	public static void main(String[] args) {
		
		try {
			File proyecto;
			
			if(args.length>0){
				proyecto = new File(args[0]);
			} else {
				//Evaluar mismo proyecto
				proyecto = new File(new File(".").getCanonicalPath());
			}
			
			HerramientaTesting herramienta = new HerramientaTesting(proyecto);
			
			new Consola(herramienta).ejecutar();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public HerramientaTesting (File rutaProyecto){
		this.proyecto = new LectorJavaParser().leerProyecto(rutaProyecto);
	}
	
	public List<ResultadoMetrica> calcularMetricas(Metodo metodo){
		List<ResultadoMetrica> resultados = new ArrayList<ResultadoMetrica>();
		
		List<Metrica> metricas = new ArrayList<Metrica>();
		metricas.add(new CantidadLineas());
		metricas.add(new CantidadComentarios());
		metricas.add(new Halstead());
		metricas.add(new ComplejidadCiclomatica());
		metricas.add(new FanIn(this.proyecto));
		metricas.add(new FanOut(this.proyecto));
		
		for(Metrica metrica : metricas){
			metrica.calcular(metodo);
			resultados.add(metrica.obtenerResultado());
		}
		return resultados;
	}

	public List<Clase> getProyecto() {
		return proyecto;
	}
	
	
}
