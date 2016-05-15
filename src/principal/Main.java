package principal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import metricas.Archivo;
import metricas.ComplejidadCiclomatica;
import metricas.Halstead;

public class Main {
	public static void main(String[] args) {
		leerArchivoYMostrar("src/metodo.txt");
	}
	
	public static void leerArchivoYMostrar(final String rutaArchivo){
		try {
			List<String> metodo = Files.readAllLines(Paths.get(rutaArchivo));
			Halstead halstead = new Halstead(metodo);
			Archivo archivo = new Archivo();
			
			ComplejidadCiclomatica.leerArchivoYMostrar(rutaArchivo);
			System.out.println("---------------------------------");
			System.out.println("Lognitud: " + halstead.getLongitud());
			System.out.println("Volumen: " + halstead.getVolumen());
			System.out.println("n1: " + halstead.getCantidadOperadoresUnicos());
			System.out.println("N1: " + halstead.getCantidadOperadores());
			System.out.println("n2: " + halstead.getCantidadOperandosUnicos());
			System.out.println("N2: " + halstead.getCantidadOperandos());
			System.out.println("---------------------------------");
			System.out.println("Lineas Codigo: " + archivo.contarLineasCodigo(metodo));
			System.out.println("Lineas Comentario: " + archivo.contarLineasComentario(metodo));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
