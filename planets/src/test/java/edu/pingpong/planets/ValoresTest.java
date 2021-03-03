package edu.pingpong.planets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import edu.pingpong.planets.Valores;
import org.junit.BeforeClass;
import org.junit.Test;

public class ValoresTest {

	public static String[] planetas;
	
	
	@BeforeClass
	public static void CreacionArrayPlanetasSetup(){
		planetas = new String[8];
		int planetasIncluidos = 0;
		for(Valores planeta : Valores.values()){
			planetas[planeta.ordinal()] = planeta.name();
			planetasIncluidos++;
		}
		assertThat(planetasIncluidos).isEqualTo(Valores.values().length);
	}
	

	@Test
	public void PlanetaConstructorTest() {
		// voy a asegurarme de que los metodos de los Enum Types
		// se comportan como yo espero
		Valores planeta = Valores.MERCURY;
		assertThat(planeta).isInstanceOf(Valores.class);
		assertThat(planeta.ordinal()).isEqualTo(0); // Posicion dentro del archivo enum
		assertThat(planeta.name()).isEqualToIgnoringWhitespace("MERCURY");
		assertThat(Valores.valueOf(planeta.name())).isEqualTo(Valores.MERCURY);
		assertThat(planeta.compareTo(planeta.MERCURY)).isEqualTo(0);
		assertThat(planeta.toString()).isEqualToIgnoringWhitespace("MERCURY");
		assertThat(planeta.equals(planeta.MERCURY)).isEqualTo(true);
		assertThat(Valores.values()[0]).isEqualTo(planeta);
	}
	
	@Test
	public void PlanetaGetMasaTest(){		
		Valores planeta = Valores.MERCURY;
		assertThat(planeta.getMasa()).isEqualTo(3.303e+23);
	}
	
	@Test
	public void PlanetaGetRadioTest(){		
		Valores planeta = Valores.MERCURY;
		assertThat(planeta.getRadio()).isEqualTo(2.4397e+6);
	}	
	
	@Test
	public void PlanetaNamesIteratorTest(){
		for(Valores planeta : Valores.values()){
			assertThat(planeta.name()).isIn(planetas);
		}
	}
	
	@Test
	public void PesoSuperficieMercurioTest(){
		Valores planeta = Valores.MERCURY;
		double pesoHumano = 175;
		assertEquals(66.107583, planeta.MERCURY.pesoSuperficie(pesoHumano) , 0.001);
	}
	
	@Test
	public void ArrayPlanetasRocososTest(){

		String[] planetasRocosos = new String[4];
		int planetasIncluidos = 0;
		
		for(int i = Valores.MERCURY.ordinal(); i < Valores.JUPITER.ordinal(); i++){
			planetasRocosos[i] = Valores.values()[i].name();
			planetasIncluidos++;
		}
		assertThat(planetasIncluidos).isEqualTo(4);
		
		for(Valores planeta : Valores.getPlanetasRocosos()){
			assertThat(planeta.name()).isIn(planetasRocosos);
		}		
	}
	
	@Test
	public void ArrayGigantesGaseosos(){

		String[] gigantesGaseosos = new String[4];
		int planetasIncluidos = 0;
		
		byte index = 0;
		for(int i = Valores.JUPITER.ordinal(); i <= Valores.NEPTUNE.ordinal(); i++){
			gigantesGaseosos[index] = Valores.values()[i].name();
			planetasIncluidos++;
			index++;
		}
		assertThat(planetasIncluidos).isEqualTo(4);
		
		for(Valores planeta : Valores.getGigantesGaseosos()){
			assertThat(planeta.name()).isIn(gigantesGaseosos);
		}		
	}
	

}