package principal;

import entradaSalida.Entrada;

public class Archivo {
	private String ruta;
	
	public Archivo(String file){
		this.ruta = file;
	}
	
	//Devuelve el numero total de lineas de codigo
	public long contarLineasCodigo(){
		Entrada entrada = new Entrada(ruta);
		String linea;
		long nroLineas = 0;	
		
		linea = entrada.leer();
		
	    while (linea != null){
	      nroLineas++;	
	      linea = entrada.leer();
	    }
	    
	    entrada.cerrar();//Archivo cerrado
	    return nroLineas;
	}
	
	//Devuelve el numero de lineas de comentario 
	public long contarLineasComentario(){
		Entrada entrada = new Entrada(ruta);
		String linea;
		String aux;
		long nroComentarios = 0;
		boolean buscandoFB = false;//indica si se esta buscando el fin de bloque
   		     
	    while ((linea = entrada.leer())!=null){
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
	    entrada.cerrar();//Cierro archivo
	    return nroComentarios;
	}
	
}
