package operaciones;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import static org.junit.Assert.*;

public class DivisionTest {

	@Test
	public void pruebaObtenerPrimeraParte() {
		assertEquals(Arrays.asList(1,1), Division.obtenerPrimeraParte(Arrays.asList(1,1,1), Arrays.asList(1,1)));
		assertEquals(Arrays.asList(1,5), Division.obtenerPrimeraParte(Arrays.asList(1,5,1), Arrays.asList(1,1)));
		assertEquals(Arrays.asList(1,0,1), Division.obtenerPrimeraParte(Arrays.asList(1,0,1), Arrays.asList(1,1)));
	}
	
	@Test
	public void pruebaDividirParte() {
		assertEquals(1, Division.dividirParte(Arrays.asList(1), Arrays.asList(1)));
		assertEquals(2, Division.dividirParte(Arrays.asList(2), Arrays.asList(1)));

		assertEquals(1, Division.dividirParte(Arrays.asList(5), Arrays.asList(5)));
		assertEquals(2, Division.dividirParte(Arrays.asList(1,0), Arrays.asList(5)));
		assertEquals(3, Division.dividirParte(Arrays.asList(1,5), Arrays.asList(5)));
		assertEquals(4, Division.dividirParte(Arrays.asList(2,0), Arrays.asList(5)));
		assertEquals(5, Division.dividirParte(Arrays.asList(2,5), Arrays.asList(5)));	
	}	
	
	@Test
	public void pruebaDividir() {
		
		assertEquals(Arrays.asList(1), Division.dividir(Arrays.asList(1), Arrays.asList(1)));
		assertEquals(Arrays.asList(2), Division.dividir(Arrays.asList(2), Arrays.asList(1)));

		assertEquals(Arrays.asList(1), Division.dividir(Arrays.asList(5), Arrays.asList(5)));
		assertEquals(Arrays.asList(2), Division.dividir(Arrays.asList(1,0), Arrays.asList(5)));
		assertEquals(Arrays.asList(3), Division.dividir(Arrays.asList(1,5), Arrays.asList(5)));
		assertEquals(Arrays.asList(4), Division.dividir(Arrays.asList(2,0), Arrays.asList(5)));
		assertEquals(Arrays.asList(5), Division.dividir(Arrays.asList(2,5), Arrays.asList(5)));		
		
		assertEquals(Arrays.asList(1,1), Division.dividir(Arrays.asList(5,5), Arrays.asList(5)));
		assertEquals(Arrays.asList(2,0), Division.dividir(Arrays.asList(1,0,0), Arrays.asList(5)));
		assertEquals(Arrays.asList(3,0), Division.dividir(Arrays.asList(1,5,0), Arrays.asList(5)));
		assertEquals(Arrays.asList(4,0), Division.dividir(Arrays.asList(2,0,0), Arrays.asList(5)));
		assertEquals(Arrays.asList(5,0), Division.dividir(Arrays.asList(2,5,0), Arrays.asList(5)));		

		assertEquals(Arrays.asList(1,3,1), Division.dividir(Arrays.asList(1,3,1), Arrays.asList(1)));
		assertEquals(Arrays.asList(1,0), Division.dividir(Arrays.asList(1,3,1), Arrays.asList(1,3)));	
		assertEquals(Arrays.asList(8), Division.dividir(Arrays.asList(1,3,1), Arrays.asList(1,5)));	
	}
	
	@Test
	public void dividiendoValoresAleatorios() {
		
		// hace 1000 multiplicaciones
		for (int times = 0; times < 1000; ++times) {

			// genera dos números aleatorios
			List<Integer> s1, s2;
			
			// genera nuevos números hasta que s2 != 0
			do {
                s1 = Utils.randArray(5);
                s2 = Utils.randArray(5);                
			} while(Utils.iguales(s2, Arrays.asList(0)));
	
			// multiplica usando el algoritmo
			System.out.println("dividiendo");
			List<Integer> temp1 = new ArrayList<>(s1), temp2 = new ArrayList<>(s2);
			System.out.println(String.format("%s / %s ", Utils.listToString(s1), Utils.listToString(s2)));
			
			List<Integer> res = Division.dividir(temp1, temp2);
			System.out.println("respuesta = " + Utils.listToString(res));
	
			// multiplica usando BigInteger en Java
			System.out.println("dividiendo usando el BigInteger de Java");
			BigInteger result = new BigInteger(Utils.listToString(s1)).divide(new BigInteger(Utils.listToString(s2)));
			System.out.println("respuesta = " + result.toString());
			System.out.println();
			
			assert (Utils.listToString(res).equals(result.toString()));
		}
	}

	
}
