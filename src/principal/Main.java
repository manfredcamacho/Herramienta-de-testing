package principal;

public class Main {
	public static void main(String[] args) {
		Archivo archivo = new Archivo("src/archivo.txt");
		System.out.println(archivo.contarLineasCodigo());
		System.out.println(archivo.contarLineasComentario());
	}
}
