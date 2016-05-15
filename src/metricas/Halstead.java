package metricas;

import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Halstead {
	
    private Integer longitud;
	private Double volumen;
    
	private Integer cantidadOperadoresUnicos = 0;
    private Integer cantidadOperadores = 0;
    private Integer cantidadOperandosUnicos = 0;
    private Integer cantidadOperandos = 0;
	

    String operadores [] = {"if", "else", "case", "default", "for", "while", "catch", "throw",
			"+", "-", "*", "/", "==", "!=", "=", "<=", ">=", "<", ">",
			"&&", "||", "and", "or", "equal to"};

    //Set que contendrá los operadores del código fuente
	private Set<String> setOperadores = new HashSet<String>();
	
	//Set que contendrá los operandos del código fuente
	private Set<String> setOperandos = new HashSet<String>();

	public Halstead(List<String> metodo){
		this.procesar(metodo);
	}
	
    private void procesar(List<String> metodo) {
    	
    	this.longitud = 0;
    	this.volumen = 0.0;
    	    	
        for (String linea : metodo) {            
            buscarOperadores(linea);
            buscarOperandos(linea);
        }
        
        this.cantidadOperadoresUnicos = this.setOperadores.size();
        this.cantidadOperandosUnicos = this.setOperandos.size();
        
        this.longitud = this.cantidadOperadores + this.cantidadOperandos;
        this.volumen = (this.longitud * (Math.log(this.cantidadOperadoresUnicos.doubleValue() + 
        							  Math.log(this.cantidadOperandosUnicos.doubleValue())) / Math.log(2)));
    }
    
    private void buscarOperadores(String linea) {
    	for(int i = 0; i < this.operadores.length - 1; i++)
    		if(linea.contains(this.operadores[i])) {
    			this.cantidadOperadores += 1;
    			this.setOperadores.add(this.operadores[i]);
    		}
    }
    
    private void buscarOperandos(String linea) {
    	String operandos[] = linea.split("^.*(if|else|case|default|for|while|catch|throw|\\+|-|\\*|\\/"
    									 + "|={1}?|!=|={2}?|<=|>=|<{1}?|>{1}?|&&|\\|{2}?|and|or|equal to).*");
    	for(int i = 0; i < operandos.length ; i++)
    	{
    		this.cantidadOperandos += 1;
    		this.setOperandos.add(operandos[i]);
    	}
    }
    
    public Integer getLongitud() {
		return longitud;
	}

	public Double getVolumen() {
		return volumen;
	}
	
	 public Integer getCantidadOperadoresUnicos() {
			return cantidadOperadoresUnicos;
	}

	public Integer getCantidadOperadores() {
		return cantidadOperadores;
	}

	public Integer getCantidadOperandosUnicos() {
		return cantidadOperandosUnicos;
	}

	public Integer getCantidadOperandos() {
		return cantidadOperandos;
	}
}