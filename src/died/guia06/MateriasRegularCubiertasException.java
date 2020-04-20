package died.guia06;

public class MateriasRegularCubiertasException extends Exception {
	
	Alumno alumno;
	Curso curso;
	
	public MateriasRegularCubiertasException(Alumno a, Curso c){
		super();
		this.alumno = a;
		this.curso = c;
	}
	
	public String getMessage() {
		return "El alumno "+ this.alumno.getNombre()+"(Libreta:"+this.alumno.getNroLibreta()+") ya se encuentra inscripto a todas las materias de cursado regular en el ciclo lectivo " + this.curso.getCicloLectivo()+
				" por lo que no pudo inscribirse al curso "+this.curso.getNombre()+"(ID:"+this.curso.getId()+")\n";
	}
}
