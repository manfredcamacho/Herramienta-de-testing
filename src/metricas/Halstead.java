package metricas;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Halstead implements Metrica {
	
    private Integer longitud;
	private Double volumen;
    
	private Integer cantidadOperadoresUnicos = 0;
    private Integer cantidadOperadores = 0;
    private Integer cantidadOperandosUnicos = 0;
    private Integer cantidadOperandos = 0;

    private final String operadores [] = {"if", "else", "case", "default", "for", "while", "catch", "throw",
			"+", "-", "*", "/", "==", "!=", "=", "<=", ">=", "<", ">",
			"&&", "||", "and", "or", "equal to"};

    //Set que contendra los operadores del codigo fuente
	private Set<String> setOperadores = new HashSet<String>();
	//Set que contendra los operandos del codigo fuente
	private Set<String> setOperandos = new HashSet<String>();

	public String getNombre() {
		return "Halsted";
	}
	
	public void calcular(List<String> metodo) {
    	this.longitud = 0;
    	this.volumen = 0.0;
    	    	
        for (String linea : metodo) {            
            this.buscarOperadores(linea);
            this.buscarOperandos(linea);
        }
        
        this.cantidadOperadoresUnicos = this.setOperadores.size();
        this.cantidadOperandosUnicos = this.setOperandos.size();
        
        this.longitud = this.cantidadOperadores + this.cantidadOperandos;
        this.volumen = (this.longitud * (Math.log(this.cantidadOperadoresUnicos.doubleValue() + 
        							  Math.log(this.cantidadOperandosUnicos.doubleValue())) / Math.log(2)));
    }
    
    private void buscarOperadores(String linea) {
    	for(int i = 0; i < this.operadores.length - 1; i++){
    		if(linea.contains(this.operadores[i])) {
    			this.cantidadOperadores += 1;
    			this.setOperadores.add(this.operadores[i]);
    		}
    	}
    }
    
    private void buscarOperandos(String linea) {
    	String operandos[] = linea.split("^.*(if|else|case|default|for|while|catch|throw|\\+|-|\\*|\\/"
    									 + "|={1}?|!=|={2}?|<=|>=|<{1}?|>{1}?|&&|\\|{2}?|and|or|equal to).*");
    	
    	for(int i = 0; i < operandos.length ; i++) {
    		this.cantidadOperandos += 1;
    		this.setOperandos.add(operandos[i]);
    	}
    }

	public String obtenerResultado() {
		return String.format("%s : Longitud %s - Volumen %s", 
				this.getNombre(), this.longitud, this.volumen);
	}
}