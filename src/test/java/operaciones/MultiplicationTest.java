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
	public void MultiplicandoValoresAleatorios() {
		
		for (int times = 0; times < 1000; ++times) {
			List<Integer> s1, s2;
			Random gen = new Random();
			s1 = Utils.randArray(gen.nextInt(20));
			s2 = Utils.randArray(gen.nextInt(20));
	
			List<Integer> temp1 = new ArrayList<>(s1), temp2 = new ArrayList<>(s2);
			List<Integer> res = Multiplicacion.multiplicar(temp1, temp2);
			System.out.println(String.format("%s * %s = %s", Utils.listToString(s1), Utils.listToString(s2), Utils.listToString(res)));
	
			System.out.println("multiplying using Java's BigInteger...");
			BigInteger result = new BigInteger(Utils.listToString(s1)).multiply(new BigInteger(Utils.listToString(s2)));
			System.out.println("answer = " + result.toString());
	
			assert (Utils.listToString(res).equals(result.toString()));
		}
	}

	@Test	
	public void simpleTest() {
		assertTrue (Multiplicacion.multiplicar(Arrays.asList(0), Arrays.asList(-1, 0, 0, 0)).equals(Arrays.asList(0)));
		assertTrue (Multiplicacion.multiplicar(Arrays.asList(0), Arrays.asList(1, 0, 0, 0)).equals(Arrays.asList(0)));
		assertTrue (Multiplicacion.multiplicar(Arrays.asList(9), Arrays.asList(9)).equals(Arrays.asList(8, 1)));
		assertTrue (Multiplicacion.multiplicar(Arrays.asList(9), Arrays.asList(9, 9, 9, 9)).equals(Arrays.asList(8, 9, 9, 9, 1)));
	}

}
