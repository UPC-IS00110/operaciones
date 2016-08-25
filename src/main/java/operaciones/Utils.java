package operaciones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Utilidades para la manipulaci�n de n�meros representados como 
 * una lista de enteros.
 */
public class Utils {

	/**
	 * Genera un n�mero aleatorio de tama�o n
	 * @param len cantidad de digitos del n�mero
	 * @return lista que representa un n�mero aleatorio
	 */
	public static List<Integer> randArray(int len) {
		// obtiene un generador de n�meros aleatorios
		Random r = new Random();
		
		// si el tama�o es cero
		if (len == 0) {
			// retorna un arreglo con un cero
			return Arrays.asList(0);
		}
		
		// de lo contrario, crea una lista
		List<Integer> ret = new ArrayList<>();
		// agrega digitos a la lista
		ret.add(r.nextInt(9) + 1);
		--len;
		while (len-- != 0) {
			ret.add(r.nextInt(10));
		}
		// retorna la lista
		return ret;
	}

	/**
	 * Convierte una lista a una cadena
	 * @param A lista de enteros que representa un n�mero
	 * @return Cadena que representa el n�mero 
	 */
	public static String listToString(List<Integer> A) {
		StringBuilder result = new StringBuilder();
		for (int a : A) {
			result.append(a);
		}
		return result.toString();
	}

}
