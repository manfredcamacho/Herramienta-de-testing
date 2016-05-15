package metricas;

import java.util.List;
/*
 * Cambiar nombre clase
 * 
 */
public class Archivo {	
	
	//Devuelve el numero total de lineas de codigo
	public long contarLineasCodigo(List<String> metodo){
		return metodo.size();
	}
	
	//Devuelve el numero de lineas de comentario 
	public long contarLineasComentario(List<String> metodo){
		String aux = null;
		int nroComentarios = 0;
		boolean buscandoFB = false;//indica si se esta buscando el fin de bloque
		
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
	    return nroComentarios;
	}
	
	public double porcentajeComentarios(int numeroComentario, int numeroLineas){
		return (numeroComentario * 100) / numeroLineas;
	}

}
