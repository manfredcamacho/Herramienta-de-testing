package entradaSalida;

import java.io.*;

public class Entrada {

	private File fp = null;
	private FileReader fr = null;
	private BufferedReader br = null;
	
	public Entrada( String ruta ){
		try {
			fp = new File(ruta);
			fr = new FileReader(fp);
			br = new BufferedReader(fr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cerrar(){
		try {
			if( fr != null )
				fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String leer(){
		String linea = null;
		try {
			linea = br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return linea;
	}
}