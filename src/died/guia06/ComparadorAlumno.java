package died.guia06;

import java.util.Comparator;

public enum ComparadorAlumno implements Comparator<Alumno> {
	
	ALFABETICO(Comparator.comparing(Alumno::getNombre)), 
	NROLIBRETA(Comparator.comparingInt(Alumno::getNroLibreta)), 
	CREDITOS(Comparator.comparingInt(Alumno::creditosObtenidos));
	
	private final Comparator<Alumno> comp;
	
	
	private ComparadorAlumno(final Comparator<Alumno> comp) {
		this.comp = comp;
	}

	@Override
	public int compare(Alumno a1, Alumno a2) {
		return this.comp.compare(a1, a2);
	}

}
