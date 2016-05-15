package principal;

import java.util.List;
import java.util.Scanner;

import entidades.Clase;
import entidades.Metodo;

public class GUIConsola {
	
	private static Scanner teclado = new Scanner(System.in);
	private HerramientaTesting herramienta;
	
	public GUIConsola(HerramientaTesting herramienta) {
		this.herramienta = herramienta;
	}

	public void ejecutar(){
		Boolean continuar = true;
		while (continuar){
			Integer indice;
			List<Clase> clasesProyecto = herramienta.getProyecto();
			for(indice = 0; indice<clasesProyecto.size(); indice++){
				System.out.println(
						String.format(
								"%d - %s", 
								indice, clasesProyecto.get(indice).getNombre()
						)
					);
			}
			
			String input = teclado.nextLine();
			Clase claseElegida = clasesProyecto.get(Integer.valueOf(input));
			
			List<Metodo> metodosClaseElegida = claseElegida.getMetodos();
			for(indice = 0; indice<metodosClaseElegida.size(); indice++){
				System.out.println(
						String.format(
								"%d - %s", 
								indice, metodosClaseElegida.get(indice).getNombre()
						)
					);
			}
			
			input = teclado.nextLine();
			Metodo metodoElegido = metodosClaseElegida.get(Integer.valueOf(input));
			
			herramienta.calcularMetricas(metodoElegido);
			
			System.out.println("Continuar? Y/N: ");
			input = teclado.nextLine();
			continuar = input.toLowerCase().equals("y");
		}
		teclado.close();
	}
}
