package died.guia06;

public class NoTieneSuficientesCreditosException extends Exception {	
	
	Alumno alumno;
	Curso curso;
	
	public NoTieneSuficientesCreditosException(Alumno a, Curso c){
		super();
		this.alumno = a;
		this.curso = c;
	}
	
	public String getMessage() {
		return "El alumno "+ this.alumno.getNombre()+"(Libreta:"+this.alumno.getNroLibreta()+") no pudo inscribirse por falta créditos al curso "+
				this.curso.getNombre()+"(ID:"+this.curso.getId()+"). Se necesitan: "+curso.getCreditosRequeridos()+". Tiene: "+ this.alumno.creditosObtenidos()+ "\n";
	}
}
