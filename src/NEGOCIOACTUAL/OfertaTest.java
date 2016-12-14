package NEGOCIOACTUAL;

import static org.junit.Assert.*;

import org.junit.Test;

public class OfertaTest {

	@Test
	public void testOferta() {
		Oferta oferta = new Oferta("The Beatle", 1000, 2,5);
		
		assertEquals(oferta.getNombre(),"The Beatle");
		assertTrue(oferta.getDinero() == 1000);
		assertTrue(oferta.getHoraEntrada() == 2);
		assertTrue(oferta.getHoraSalida()== 5);
		
		
	}
}
