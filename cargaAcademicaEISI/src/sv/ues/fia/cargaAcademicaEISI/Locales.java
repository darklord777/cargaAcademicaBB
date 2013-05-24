package sv.ues.fia.cargaAcademicaEISI;

public class Locales {
	private String idLocal;
	private String Capacidad;
	
	public Locales(){		
	}

	public Locales(String idLocal, String capacidad) {		
		this.idLocal = idLocal;
		this.Capacidad = capacidad;
	}

	public String getIdLocal() {
		return idLocal;
	}

	public void setIdLocal(String idLocal) {
		this.idLocal = idLocal;
	}

	public String getCapacidad() {
		return Capacidad;
	}

	public void setCapacidad(String capacidad) {
		Capacidad = capacidad;
	}

	
	
	
}
