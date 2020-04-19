package died.guia06;

import java.util.ArrayList;
import java.util.List;


public class Alumno implements Comparable<Alumno> {

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;
	
	public Alumno(String nombre, int nroLibreta) {
		this.nombre = nombre;
		this.nroLibreta = Integer.valueOf(nroLibreta);
		this.cursando = new ArrayList<Curso>(0);
		this.aprobados = new ArrayList<Curso>(0);
	}

	public int creditosObtenidos() {
		int creditosAcum = 0;
		for(int i = 0; i < this.aprobados.size(); i++) {
			creditosAcum+=this.aprobados.get(i).getCreditos();
		}
		return creditosAcum;
	}

	public void aprobar(Curso c) {
		this.cursando.remove(c);
		this.aprobados.add(c);
	}

	public void inscripcionAceptada(Curso c) {
		this.cursando.add(c);
	}

	public boolean equals(Alumno a){
		return (this.nroLibreta == a.nroLibreta);
	}
	
	public int compareTo(Alumno a) {
		return this.nombre.compareTo(a.nombre);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getNroLibreta() {
		return this.nroLibreta.intValue();
	}
	
	public List<Curso> getCursosCursando() {
		return this.cursando;
	}
	
	public List<Curso> getCursosAprobados() {
		return this.aprobados;
	}
	

}
