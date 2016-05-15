package metricas;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class FanSearchMethod {

	public static Integer cantOcur(String name, List<String> metodo){
		Integer cant = 0;
		for(String linea : metodo){
			cant += StringUtils.countMatches(linea, name);
		}
		return cant;
	}
}
