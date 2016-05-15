package lector;

import java.io.File;
import java.util.List;

import entidades.Clase;
import entidades.Metodo;

public class MainPruebaLector {

	public static void main(String[] args) {
		LectorJavaParser lector = new LectorJavaParser();
		List<Clase> clasesProyecto = lector.leerProyecto(
				new File("/home/nicolass/dev/unlam/analisissoftware/workspace/Triangulo")
			);
		for(Clase claseProyecto : clasesProyecto){
			System.out.println("\nClase "+claseProyecto.getNombre());
			
			for(Metodo metodoClaseProyecto : claseProyecto.getMetodos()){
				System.out.println(
						"\nMetodo "
						+ metodoClaseProyecto.getNombre()
						+" de clase "
						+ metodoClaseProyecto.getClase().getNombre()
						+" - Cantidad de lineas: "
						+ metodoClaseProyecto.getCodigo().size());
				System.out.println("Codigo:");
				for(String linea : metodoClaseProyecto.getCodigo()){
					System.out.println(linea);
				}
			}
		}
	}

}
