package died.guia06;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class AlumnoTest {
	
	

	Alumno a1, a2, a3, a4;
	Curso c1, c2, c3;


	@BeforeEach
	void init1() {
		a1 = new Alumno("Juan",1);
	}
	@Test
	void testCreditosObtenidosSinCursosAprobados() {		
		int creditosObtenidos = a1.creditosObtenidos();
		assertEquals(0, creditosObtenidos);
	}
	
	//Al parecer hay un problema con la etiqueta @BeforeEach (no se ejecuta el código de init2() ) porque al trasladar las sentencias de init2() 
	//hacia dentro de @Test, pasa la prueba.
	//Incluso en la App ejecuté el siguiente código para testear el error, arrojando el resultado correcto sin lanzar excepciones
	//También volqué el código en otro archivo TestCase de JUnit y funciona si no hay otros tests debajo del mismo
	//La Excepción se debe a que al intentar recuperar un valor Integer (que en realidad es nulo porque no se setearon sus atributos) 
	//y enviale el mensaje que se le enviaría a Integer para obtener el valor primitivo, se produce una NullPointerException
	
	/* 
	 		try {
			Alumno a1;
			Curso c1, c2, c3;
			a1 = new Alumno("Juan", 1);
			c1 = new Curso();
			c2= new Curso();
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
			System.out.println(creditosObtenidos);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}	 
	 
	*/	
	
	@BeforeEach 
	void init2() {
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
	void init3() {
		a1 = new Alumno("Juan", 1);
		c1 = new Curso();
		c2 = new Curso();
		c3 = new Curso();
		a1.inscripcionAceptada(c1);
		a1.inscripcionAceptada(c2);
		a1.inscripcionAceptada(c3);
	}
	
	@Test
	void testAprobar() {
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
	void init4() {
		a1 = new Alumno("Juan", 1);
		c1 = new Curso();
		c2 = new Curso();
		c3 = new Curso();
	}
	
	@Test
	void testInscripcionAceptada() {
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
	
	@BeforeEach
	void init5() {
		a1 = new Alumno("Juan", 1);
		a2 = new Alumno("James", 1);	
	}
	
	@Test
	void testEquals() {
		assertTrue(a1.equals(a2));
	}
	
	@BeforeEach
	void init6() {
		a1 = new Alumno("Juan", 1);
		a2 = new Alumno("James", 1);
		a3 = new Alumno("Alan", 1);
		a4 = new Alumno("Alan", 1);
	}
	
	@Test
	void testCompareTo() {
		assertTrue(a3.compareTo(a1) < 0);
		assertTrue(a3.compareTo(a4) == 0);
		assertTrue(a1.compareTo(a2) > 0);
		
	}
	
	

}