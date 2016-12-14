package NEGOCIOACTUAL;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SolucionTest {

	@Test
	public void TESTaceptarOferta() {
		
		Oferta oferta1 = new Oferta("The Beatle",1000,10,13);
		Oferta oferta2 = new Oferta("Queen",1500,15,20);
		Oferta oferta3 = new Oferta("AC DC",750,12,14);
		Oferta oferta4 = new Oferta("RHC",100,4,2);
		Oferta oferta5 = new Oferta("La Mosca", 124,33,36);
		Oferta oferta6 = new Oferta("Rolling Stone",0,2,5);
		Oferta oferta7 = new Oferta("Led Zeppelin",150,3,3);
		
		Solucion solucion = new Solucion();
		
		// OFERTAS VALIDAS
		assertTrue(solucion.aceptarOferta(oferta1));
		assertTrue(solucion.aceptarOferta(oferta2));
		assertTrue(solucion.aceptarOferta(oferta3));
		
		// OFERTAS NO VALIDAS
		assertFalse(solucion.aceptarOferta(oferta4));
		assertFalse(solucion.aceptarOferta(oferta5));
		assertFalse(solucion.aceptarOferta(oferta6));
		assertFalse(solucion.aceptarOferta(oferta7));
		
	}
	
	@Test
	public void TESTmejorOpcion() {
		Oferta oferta1 = new Oferta("The Beatle",1000,10,13);
		Oferta oferta2 = new Oferta("Queen",1500,15,20);
		Oferta oferta3 = new Oferta("AC DC",750,12,14);
		
		Solucion solucion = new Solucion();
		
		assertTrue(solucion.aceptarOferta(oferta1));
		assertTrue(solucion.aceptarOferta(oferta2));
		
		assertFalse(solucion.horasDisponibles(oferta3));
		assertFalse(solucion.mejorOpcion(oferta3));
		
	}
	
	@Test
	public void TESThorasDisponibles() {
		Oferta oferta1 = new Oferta("The Beatle",1000,10,13);
		Oferta oferta2 = new Oferta("Queen",1500,15,20);
		Oferta oferta3 = new Oferta("AC DC",750,12,14);
		
		Solucion solucion = new Solucion();
		
		assertTrue(solucion.aceptarOferta(oferta1));
		assertTrue(solucion.aceptarOferta(oferta2));
		
		assertFalse(solucion.horasDisponibles(oferta3));
	
	}

	@Test
	public void TESTnoSonNull() {
		Oferta oferta1 = new Oferta("The Beatle",1000,10,13);
		Oferta oferta2 = new Oferta("Queen",1500,15,20);
		Oferta oferta3 = new Oferta("AC DC",750,12,14);
		Oferta oferta4 = null;
		
		Solucion solucion = new Solucion();
		
		assertTrue(solucion.noSonNull(oferta1, oferta2));
		assertFalse(solucion.noSonNull(oferta3, oferta4));
		
	}
}
