package sv.ues.fia.cargaAcademicaEISI;

public class ActividadAcademica {
	private String idActividadAcad;
	private String idModalActAcad;
	private String NombreActAcademica;
	private String Cargo;
	
	public ActividadAcademica(){		
	}

	public ActividadAcademica(String idActividadAcad, String idModalActAcad,String nombreActAcademica, String cargo) {		
		this.idActividadAcad = idActividadAcad;
		this.idModalActAcad = idModalActAcad;
		this.NombreActAcademica = nombreActAcademica;
		this.Cargo = cargo;
	}

	public String getIdActividadAcad() {
		return idActividadAcad;
	}

	public void setIdActividadAcad(String idActividadAcad) {
		this.idActividadAcad = idActividadAcad;
	}

	public String getIdModalActAcad() {
		return idModalActAcad;
	}

	public void setIdModalActAcad(String idModalActAcad) {
		this.idModalActAcad = idModalActAcad;
	}

	public String getNombreActAcademica() {
		return NombreActAcademica;
	}

	public void setNombreActAcademica(String nombreActAcademica) {
		NombreActAcademica = nombreActAcademica;
	}

	public String getCargo() {
		return Cargo;
	}

	public void setCargo(String cargo) {
		Cargo = cargo;
	}
	
	
}
