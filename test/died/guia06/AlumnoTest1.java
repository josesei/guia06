package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlumnoTest1 {
	
	Alumno a1;
	Curso c1, c2, c3;
	
	@BeforeEach
	void setUp1() {
		a1 = new Alumno("Juan",1);
	}
	
	@Test
	void testCreditosObtenidosSinCursosAprobados() {		
		int creditosObtenidos = a1.creditosObtenidos();
		assertEquals(0, creditosObtenidos);
	}

	@BeforeEach
	void setUp2() {
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
	}

	@Test
	void testCreditosObtenidosConCursosAprobados() {
		a1.aprobar(c1);
		a1.aprobar(c2);
		a1.aprobar(c3);
		int creditosObtenidos = a1.creditosObtenidos();
		assertEquals(20, creditosObtenidos);
	}
	

	@BeforeEach
	void setUp3() {
		a1 = new Alumno("Juan", 1);
		c1 = new Curso();
		c2 = new Curso();
		c3 = new Curso();
		a1.inscripcionAceptada(c1);
		a1.inscripcionAceptada(c2);
		a1.inscripcionAceptada(c3);
	}

	@Test
	void testAprobarCurso()  {
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
	
	@BeforeEach
	void setUp4() {
		a1 = new Alumno("Juan", 1);
		c1 = new Curso();
		c2 = new Curso();
		c3 = new Curso();
	}

	@Test
	void testInscrpcionAceptada()  {
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
	
	
	
	

	
}
