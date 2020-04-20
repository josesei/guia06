package died.guia06;

import java.io.IOException;

public class RegistroAuditoriaException extends IOException {
	
	
	
	public RegistroAuditoriaException() {
		super();
	}
	public String getMessage() {
		return "Ha ocurrido un error al intentar escribir en el registro de auditoría\n";
	}
}
