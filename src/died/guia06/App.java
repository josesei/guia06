package died.guia06;

public class App {

	public static void main(String[] args) {
		Curso c1 = new Curso(1, "Algebra", 2018, 10, 8, 0);
		Curso c2 = new Curso(2, "Historia", 2018, 10, 10, 0);
		Curso c3 = new Curso(3, "Lengua", 2018, 10, 6, 0);
		Curso c4 = new Curso(4, "Arte", 2018, 10, 4, 0);
		Curso c5 = new Curso(5, "Historia II", 2019, 10, 3, 8);
		Curso c6 = new Curso(6, "Geografia", 2019, 10, 4, 12);
		Curso c7 = new Curso(7, "Matematica", 2020, 10, 12, 20);
		Curso c8 = new Curso(8, "Filosofia", 2020, 10, 20, 30	);
		
		Alumno a1 = new Alumno("Juan", 1);
		Alumno a2 = new Alumno("Enrique", 2);
		Alumno a3 = new Alumno("Roberto", 3);
		Alumno a4 = new Alumno("Felipe", 4);
		Alumno a5 = new Alumno("Ignacio", 5);
		Alumno a6 = new Alumno("José", 6);
		Alumno a7 = new Alumno("Fabio", 7);
		Alumno a8 = new Alumno("Leandro", 8);
		Alumno a9 = new Alumno("Leonardo", 9);
		
		c1.inscribirAlumno(a1);
		c1.inscribirAlumno(a2);
		c1.inscribirAlumno(a3);
		c1.inscribirAlumno(a4);
		c1.inscribirAlumno(a5);
		c1.inscribirAlumno(a6);
		c1.inscribirAlumno(a7);
		c1.inscribirAlumno(a8);
		c1.inscribirAlumno(a9);//falla por falta de cupo
		c2.inscribirAlumno(a1);
		c2.inscribirAlumno(a2);
		c2.inscribirAlumno(a3);
		c3.inscribirAlumno(a1);
		c3.inscribirAlumno(a2);
		c3.inscribirAlumno(a3);
		c4.inscribirAlumno(a1); //falla por ser el 4to curso del mismo ciclo lectivo
		
		a1.aprobar(c1);
		a1.aprobar(c2);
		a1.aprobar(c3);
		a2.aprobar(c1);
		a2.aprobar(c2);
		a3.aprobar(c3);
		a4.aprobar(c1);
		a5.aprobar(c1);
		
		System.out.println(a1.creditosObtenidos());
		System.out.println(a2.creditosObtenidos());
		System.out.println(a3.creditosObtenidos());
		System.out.println(a4.creditosObtenidos());
		System.out.println(a5.creditosObtenidos());
		System.out.println(a6.creditosObtenidos());
		System.out.println(a8.creditosObtenidos());
		System.out.println(a9.creditosObtenidos());
		
		c8.inscribir(a1);//falla por créditos insuficientes
		
		System.out.println("ORDEN ALFABÉTICO: ");
		c1.imprimirInscriptos(ComparadorAlumno.ALFABETICO);
		System.out.println("ORDEN NROLIBRETA: ");
		c1.imprimirInscriptos(ComparadorAlumno.NROLIBRETA);
		System.out.println("ORDEN CREDITOS: ");
		c1.imprimirInscriptos(ComparadorAlumno.CREDITOS);
		
		c4.inscribir(a1);
		c4.inscribir(a2);
		c4.inscribir(a3);
		c5.inscribir(a3);//falla por falta de créditos
		c6.inscribir(a1);
		c6.inscribir(a2);
		
		a3.aprobar(c4);
		c5.inscribirAlumno(a3);
		
		System.out.println(a1.creditosObtenidos());
		System.out.println(a2.creditosObtenidos());
		System.out.println(a3.creditosObtenidos());
		System.out.println(a4.creditosObtenidos());
		System.out.println(a5.creditosObtenidos());
		System.out.println(a6.creditosObtenidos());
		System.out.println(a8.creditosObtenidos());
		System.out.println(a9.creditosObtenidos()+"\n");
		
		a1.aprobar(c4);
		a1.aprobar(c6);
		a1.aprobar(c7);
		a2.aprobar(c4);
		a2.aprobar(c6);
		
		System.out.println(a1.creditosObtenidos());
		System.out.println(a2.creditosObtenidos());
		System.out.println(a3.creditosObtenidos());
		System.out.println(a4.creditosObtenidos());
		System.out.println(a5.creditosObtenidos());
		System.out.println(a6.creditosObtenidos());
		System.out.println(a8.creditosObtenidos());
		System.out.println(a9.creditosObtenidos());
		
		c8.inscribirAlumno(a1);
		c8.inscribirAlumno(a2);//créditos insuficientes
		c8.inscribirAlumno(a3);//créditos insuficientes
			
		
		
	}
}
