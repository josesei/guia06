package died.guia06;

public class CuposCubiertosException extends Exception {
	
	Alumno alumno;
	Curso curso;
	
	public CuposCubiertosException(Alumno a, Curso c){
		super();
		this.alumno = a;
		this.curso = c;
	}
	
	public String getMessage() {
		return "El alumno "+ this.alumno.getNombre()+"(Libreta:"+this.alumno.getNroLibreta()+") no pudo inscribirse por falta de cupo al curso "+
		this.curso.getNombre()+"(ID:"+this.curso.getId()+")\n";
	}
}
