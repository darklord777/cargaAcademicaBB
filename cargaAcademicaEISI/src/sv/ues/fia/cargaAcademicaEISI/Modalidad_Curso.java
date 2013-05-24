package sv.ues.fia.cargaAcademicaEISI;

public class Modalidad_Curso {
	private String idModalCurso;
	private String NombreModal;
	private String DescHoras;
	
	public Modalidad_Curso() {		
	}
	
	public Modalidad_Curso(String idmodalCurso, String nombreModal, String descHoras) {		
		this.idModalCurso = idmodalCurso;
		this.NombreModal = nombreModal;
		this.DescHoras = descHoras;
	}

	public String getIdModalCurso() {
		return idModalCurso;
	}

	public void setIdModalCurso(String idModalCurso) {
		this.idModalCurso = idModalCurso;
	}

	public String getNombreModal() {
		return NombreModal;
	}

	public void setNombreModal(String nombreModal) {
		NombreModal = nombreModal;
	}

	public String getDescHoras() {
		return DescHoras;
	}

	public void setDescHoras(String descHoras) {
		DescHoras = descHoras;
	}	
	
}
