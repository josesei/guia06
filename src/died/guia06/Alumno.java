package died.guia06;

import java.util.List;


public class Alumno implements Comparable<Alumno> {

	private String nombre;
	private Integer nroLibreta;
	private List<Curso> cursando;
	private List<Curso> aprobados;
	
	public Alumno(String nombre, Integer nroLibreta) {
		this.nombre = nombre;
		this.nroLibreta = nroLibreta;
	}

	public int creditosObtenidos() {
		int creditosAcum = 0;
		for(Curso c : this.aprobados) {
			creditosAcum+= c.getCreditos();
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
		return this.nroLibreta == a.nroLibreta;
	}
	
	public int compareTo(Alumno a) {
		return this.nombre.compareTo(a.nombre);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Integer getNroLibreta() {
		return this.nroLibreta;
	}
	

}
