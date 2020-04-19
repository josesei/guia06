package died.guia06;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlumnoTest {
	
	

	Alumno a1, a2, a3, a4;
	Curso c1, c2, c3;

	@Test
	void testCreditosObtenidosSinCursosAprobados() {	
		a1 = new Alumno("Juan",1);
		int creditosObtenidos = a1.creditosObtenidos();
		assertEquals(0, creditosObtenidos);
	}
	
	@Test
	void testCreditosObtenidosConCursosAprobados() {
		a1 = new Alumno("Juan", 1);
		c1 = new Curso();
		c2 = new Curso();
		c3 = new Curso();
		c1.setCreditos(2);
		c2.setCreditos(7);
		c3.setCreditos(11);
		a1.inscripcionAceptada(c1);
		a1.inscripcionAceptada(c2);
		a1.inscripcionAceptada(c3);
		a1.aprobar(c1);
		a1.aprobar(c2);
		a1.aprobar(c3);
		int creditosObtenidos = a1.creditosObtenidos();
		assertEquals(20, creditosObtenidos);
	}
	

	@Test
	void testAprobar() {
		a1 = new Alumno("Juan", 1);
		c1 = new Curso();
		c2 = new Curso();
		c3 = new Curso();
		a1.inscripcionAceptada(c1);
		a1.inscripcionAceptada(c2);
		a1.inscripcionAceptada(c3);
		assertFalse(a1.getCursosAprobados().contains(c1));
		assertFalse(a1.getCursosAprobados().contains(c2));
		assertFalse(a1.getCursosAprobados().contains(c3));
		a1.aprobar(c1);
		a1.aprobar(c2);
		a1.aprobar(c3);
		assertTrue(a1.getCursosAprobados().contains(c1));
		assertTrue(a1.getCursosAprobados().contains(c2));
		assertTrue(a1.getCursosAprobados().contains(c3));
	}
	
	
	@Test
	void testInscripcionAceptada() {
		a1 = new Alumno("Juan", 1);
		c1 = new Curso();
		c2 = new Curso();
		c3 = new Curso();
		assertFalse(a1.getCursosCursando().contains(c1));
		assertFalse(a1.getCursosCursando().contains(c2));
		assertFalse(a1.getCursosCursando().contains(c3));
		a1.inscripcionAceptada(c1);
		a1.inscripcionAceptada(c2);
		a1.inscripcionAceptada(c3);
		assertTrue(a1.getCursosCursando().contains(c1));
		assertTrue(a1.getCursosCursando().contains(c2));
		assertTrue(a1.getCursosCursando().contains(c3));
	}
	
	
	@Test
	void testEquals() {
		a1 = new Alumno("Juan", 1);
		a2 = new Alumno("James", 1);
		assertTrue(a1.equals(a2));
	}
	

	
	@Test
	void testCompareTo() {
		a1 = new Alumno("Juan", 1);
		a2 = new Alumno("James", 1);
		a3 = new Alumno("Alan", 1);
		a4 = new Alumno("Alan", 1);
		assertTrue(a3.compareTo(a1) < 0);
		assertTrue(a3.compareTo(a4) == 0);
		assertTrue(a1.compareTo(a2) > 0);
		
	}
	
	

}