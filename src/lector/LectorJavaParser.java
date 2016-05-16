package lector;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import entidades.Clase;
import entidades.Metodo;

public class LectorJavaParser extends LectorProyecto {

	@Override
	protected Clase leerClase(File archivo) {
		Clase clase = new Clase(archivo.getName().replace(".java", ""), new ArrayList<Metodo>());
		
		try {
			CompilationUnit compilationUnit = JavaParser.parse(archivo);
			
			VoidVisitorAdapter<Clase> visitadorMetodos = new VoidVisitorAdapter<Clase>() {
				@Override
				public void visit(MethodDeclaration metodo, Clase clase) {
					
					clase.getMetodos().add(
							new Metodo(
									metodo.getName(),
									clase,
									Arrays.asList(
											metodo.getBody()==null ? 
													new String[0] : metodo.getBody().toString().split("\n")
									)
							)
					);
				}
			};
			
			visitadorMetodos.visit(compilationUnit, clase);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clase;
	}
	
}
