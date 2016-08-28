package operaciones;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import static org.junit.Assert.*;

public class MultiplicationTest {

	@Test
	public void multiplicandoValoresAleatorios() {
		
		// hace 1000 multiplicaciones
		for (int times = 0; times < 1000; ++times) {

			// genera dos números aleatorios
			List<Integer> s1, s2;
			Random gen = new Random();
			s1 = Utils.randArray(gen.nextInt(20));
			s2 = Utils.randArray(gen.nextInt(20));
	
			// multiplica usando el algoritmo
			System.out.println("multiplicando");
			List<Integer> temp1 = new ArrayList<>(s1), temp2 = new ArrayList<>(s2);
			System.out.println(String.format("%s * %s ", Utils.listToString(s1), Utils.listToString(s2)));
			
			List<Integer> res = Multiplicacion.multiplicar(temp1, temp2);
			System.out.println("respuesta = " + Utils.listToString(res));
	
			// multiplica usando BigInteger en Java
			System.out.println("multiplicando usando el BigInteger de Java");
			BigInteger result = new BigInteger(Utils.listToString(s1)).multiply(new BigInteger(Utils.listToString(s2)));
			System.out.println("respuesta = " + result.toString());
			System.out.println();
			
			assert (Utils.listToString(res).equals(result.toString()));
		}
	}

	@Test	
	public void algunasMultiplicaciones() {		
		// 0 * 1000 = 0
		assertTrue (Multiplicacion.multiplicar(Arrays.asList(0), Arrays.asList(1, 0, 0, 0)).equals(Arrays.asList(0)));
		// 9 * 9 = 81
		assertTrue (Multiplicacion.multiplicar(Arrays.asList(9), Arrays.asList(9)).equals(Arrays.asList(8, 1)));
		// 9 * 9999 = 89991
		assertTrue (Multiplicacion.multiplicar(Arrays.asList(9), Arrays.asList(9, 9, 9, 9)).equals(Arrays.asList(8, 9, 9, 9, 1)));
	}

}
