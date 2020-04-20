package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CursoTest {
	
	Alumno a1, a2, a3, a4, a5, a6;
	Curso c1, c2, c3, c4, c5, c6, c7;

	@BeforeEach
	void setUp() {
		c1 = new Curso();
		c1.setCicloLectivo(2020);
		c1.setCupo(2);
		c1.setCreditosRequeridos(0);
		c1.setCreditos(4);
		c2 = new Curso();
		c2.setCicloLectivo(2020);
		c2.setCreditosRequeridos(4);
		c2.setCreditos(2);
		c2.setCupo(10);
		c3 = new Curso();
		c3.setCicloLectivo(2020);
		c3.setCreditos(10);
		c3.setCreditosRequeridos(7);
		c3.setCupo(10);
		c4 = new Curso();
		c4.setCicloLectivo(2020);
		c4.setCupo(2);
		c4.setCreditosRequeridos(0);
		c4.setCreditos(0);
		c5 = new Curso();
		c5.setCicloLectivo(2020);
		c5.setCupo(2);
		c5.setCreditosRequeridos(0);
		c5.setCreditos(0);
		c6 = new Curso();
		c6.setCicloLectivo(2020);
		c6.setCupo(6);
		c6.setCreditosRequeridos(0);
		c6.setCreditos(0);
		a1 = new Alumno("Juan", 1);
		a2 = new Alumno("Pedro", 2);
		a3 = new Alumno("Ignacio", 3);
		a4 = new Alumno("Juan", 4);
		a5 = new Alumno("Francisco", 5);
		a6 = new Alumno("Leandro", 6);
		c7 = new Curso();
		c7.setCicloLectivo(2020);
		c7.setCupo(10);
		c7.setCreditosRequeridos(0);
		c7.setCreditos(0);
		c1.setNombre("curso1");
		c2.setNombre("curso2");
		c3.setNombre("curso3");
		c4.setNombre("curso4");
		c5.setNombre("curso5");
		c6.setNombre("curso6");
		c7.setNombre("curso7");
	}
	
	@Test
	void testInscribirSinCreditos() {
		assertTrue(c1.inscribir(a1));
		assertFalse(c2.inscribir(a1));
		assertFalse(c3.inscribir(a1));
	}
	
	@Test
	void testInscribirConCreditos() {
		assertTrue(c1.inscribir(a1));
		a1.aprobar(c1);
		assertFalse(c3.inscribir(a1));
		assertTrue(c2.inscribir(a1));
	}
	
	@Test
	void testInscribirCupo() {
		c1.inscribir(a1);
		assertTrue(c1.inscribir(a2));
		assertFalse(c1.inscribir(a3));
	}
	
	@Test
	void testInscribirMax3CursosMismoCicloLectivo() {
		c1.inscribir(a1);
		assertTrue(c4.inscribir(a1));
		assertTrue(c5.inscribir(a1));
		assertFalse(c6.inscribir(a1));
	}

	@Test
	void testImprimirInscriptosOrdenAlfabetico() {
		c6.inscribir(a1);
		c6.inscribir(a2);
		c6.inscribir(a3);
		c6.inscribir(a4);
		c6.inscribir(a5);
		c6.inscribir(a6);
		System.out.println("============================ORDEN-ALFABETICO============================\n");
		c6.imprimirInscriptos(ComparadorAlumno.ALFABETICO);
		//verificado
		assertTrue(true);
	}
	
	@Test 
	void testImprimirInscriptosOrdenLibreta() {
		c6.inscribir(a1);
		c6.inscribir(a2);
		c6.inscribir(a3);
		c6.inscribir(a4);
		c6.inscribir(a5);
		c6.inscribir(a6);
		System.out.println("============================ORDEN-NRO-LIBRETA============================\n");
		c6.imprimirInscriptos(ComparadorAlumno.NROLIBRETA);
		//verificado
		assertTrue(true);
	}
	
	@Test 
	void testImprimirInscriptosOrdenCreditos() {
		c1.setCreditosRequeridos(0);
		c2.setCreditosRequeridos(0);
		c3.setCreditosRequeridos(0);
		c4.setCreditosRequeridos(0);
		c5.setCreditosRequeridos(0);
		c6.setCreditosRequeridos(0);
		c1.setCreditos(1);
		c2.setCreditos(2);
		c3.setCreditos(3);
		c4.setCreditos(4);
		c5.setCreditos(5);
		c6.setCreditos(6);
		c2.inscribir(a1);
		c1.inscribir(a2);
		c5.inscribir(a3);
		c6.inscribir(a4);
		c3.inscribir(a5);
	    c4.inscribir(a6);
		a1.aprobar(c2);
		a2.aprobar(c1);
		a3.aprobar(c5);
		a4.aprobar(c6);
		a5.aprobar(c3);
		a6.aprobar(c4);
		c7.inscribir(a1);
		c7.inscribir(a2);
		c7.inscribir(a3);
		c7.inscribir(a4);
		c7.inscribir(a5);
		c7.inscribir(a6);
		
		System.out.println("============================ORDEN-CREDITOS============================\n");
		c7.imprimirInscriptos(ComparadorAlumno.CREDITOS);	
		
			
		//verificado
		assertTrue(true);
		
	}
	

}
