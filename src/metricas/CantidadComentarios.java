package metricas;

import java.util.List;

public class CantidadComentarios implements Metrica {
	
	private Integer nroComentarios;
	
	public String getNombre() {
		return "Cantidad de comentarios";
	}

	public void calcular(List<String> metodo) {
		String aux = null;
		this.nroComentarios = 0;
		Boolean buscandoFB = false;//indica si se esta buscando el fin de bloque
		
		for(String linea : metodo){			
		
			linea = linea.trim();
	    	if (linea.length() > 0) {
	    		if(linea.length() == 1){
	    			if(linea.equals("*"))
	    				nroComentarios++;
	    		}else{
		    		aux = linea.substring(0, 2);
		    		if (aux.equals("//")) { //Si la linea comienza con // es un comentario de linea
		    			nroComentarios++;
					}else if(buscandoFB || aux.equals("/*") ){ //Comienza bloque de codigo o estoy buscando el final del bloque
						nroComentarios++;
						buscandoFB = -1 == linea.indexOf("*/"); //Si encuentra el final del bloque pongo el flag en false
					}
	    		}
			}
		}
	}

	public String obtenerResultado() {
		return String.format("%s: %s", this.getNombre(), this.nroComentarios);
	}

}
