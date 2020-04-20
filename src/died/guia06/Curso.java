package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import died.guia06.util.Registro;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */
public class Curso {

	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	
	private Registro log;
	
	public Curso() {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
	}
	
	public Curso(int id, String nombre, int cicloLectivo, int cupo, int creditos, int creditosRequeridos) {
		super();
		this.id = Integer.valueOf(id);
		this.nombre = nombre;
		this.cicloLectivo = Integer.valueOf(cicloLectivo);
		this.cupo = Integer.valueOf(cupo);
		this.log = new Registro();
		this.creditos = Integer.valueOf(creditos);
		this.creditosRequeridos = Integer.valueOf(creditosRequeridos);	
		this.inscriptos = new ArrayList<Alumno>();
	}
	
	int getId() {
		return this.id.intValue();
	}
	
	public void setId(int id) {
		this.id = Integer.valueOf(id);
	}
	
	public void setCreditosRequeridos(int creditosRequeridos) {
		this.creditosRequeridos = Integer.valueOf(creditosRequeridos);
	}
	
	public void setCreditos(int creditos) {
		this.creditos = Integer.valueOf(creditos);
	}
	
	public int getCreditos() {
		return this.creditos.intValue();
	} 
	
	public void setCicloLectivo(int cicloLectivo) {
		this.cicloLectivo = Integer.valueOf(cicloLectivo);
	}
	
	public int getCicloLectivo() {
		return this.cicloLectivo.intValue();
	}
	
	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}
		
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Este m√©todo, verifica si el alumno se puede inscribir y si es as√≠ lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que est√° inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno est√° inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simult√°neo a no m√°s de 3 cursos del mismo ciclo lectivo.
	 * 
	 */
	public Boolean inscribir(Alumno a) {
		
		String errores="";
		
		if(a.creditosObtenidos() < this.creditosRequeridos) {
			errores+="Creditos insuficientes. ";
		}
		if(this.cupo <= this.inscriptos.size()) {
			errores+="No hay cupo. ";
		}
		int contadorCursosMismoCiclo = 0;
			
		for(Curso c : a.getCursosCursando()) {
			if(c.cicloLectivo.intValue() == this.cicloLectivo.intValue()) {
				contadorCursosMismoCiclo++;
			}
		}
		if(contadorCursosMismoCiclo>=3) {				
			errores+="No puede estar inscripto a m·s de 3 cursos del mismo ciclo lectivo";
		}
		if(errores.compareTo("")!=0) {
			System.out.println("Curso: "+this.nombre + "(ID:"+this.id+") - inscribir - [FALLO] - Alumno: "+a.getNombre()+"(Libreta:"+a.getNroLibreta()+") "+"Razones: "+ errores +"\n");
			try{
				log.registrar(this, "inscribir ","- [FALLO] - alumno: " + a.toString() + ". Razones: "+ errores +"\n");
			}
			catch(IOException e1){
				System.out.println("Ha ocurrido una excepciÛn del tipo IOException: " + e1.getMessage());
				e1.printStackTrace();
			}
			return false;
		}
		else {
			this.inscriptos.add(a);
			a.inscripcionAceptada(this);
			System.out.println("Curso: "+this.nombre + "(ID:"+this.id+") - inscribir - […XITO] - Alumno: "+a.getNombre()+"(Libreta:"+a.getNroLibreta()+")\n");
			try{
				log.registrar(this, "inscribir ","- […XITO] - alumno: " + a.toString() +"\n");
			}
			catch(IOException e1){
				System.out.println("Ha ocurrido una excepciÛn del tipo IOException: " + e1.getMessage());
				e1.printStackTrace();
			}
			return true;
		}				
	}
	
	
	/**
	 * imprime los inscriptos en orden alfabetico
	 */
	public void imprimirInscriptos(ComparadorAlumno comp) {
		List<Alumno> listaAlumnos = this.inscriptos;
		listaAlumnos.sort(comp);
		
		String listado = "";
		String fragmentoListado = "";
		
		Alumno a;
		
		for(int i = 1; i <= listaAlumnos.size(); i++) {
			a=listaAlumnos.get(i-1);
			fragmentoListado = i + " - "+a.toString()+ "( " + a.getNombre() +" "+ a.getNroLibreta() +" "+a.creditosObtenidos() + ")" + " || ";
			listado+=fragmentoListado;
			System.out.println(fragmentoListado);
		}
		try {
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ listado);
		}
		catch(IOException e1){
			System.out.println("Ha ocurrido una excepciÛn del tipo IOException: " + e1.getMessage());
			e1.printStackTrace();
		}
	}


}
