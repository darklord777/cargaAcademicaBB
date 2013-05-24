package sv.ues.fia.cargaAcademicaEISI;

public class Modalidad_ActAcad {
	private String idModalActAcad;
	private String NombreModalAA;
	private String DesHrsMAA;
	
	public Modalidad_ActAcad(){
		
	}
	
	public Modalidad_ActAcad(String idModalActAcad, String nombreModalAA,String desHrsMAA) {
		this.idModalActAcad = idModalActAcad;
		this.NombreModalAA = nombreModalAA;
		this.DesHrsMAA = desHrsMAA;
	}

	public String getIdModalActAcad() {
		return idModalActAcad;
	}

	public void setIdModalActAcad(String idModalActAcad) {
		this.idModalActAcad = idModalActAcad;
	}

	public String getNombreModalAA() {
		return NombreModalAA;
	}

	public void setNombreModalAA(String nombreModalAA) {
		NombreModalAA = nombreModalAA;
	}

	public String getDesHrsMAA() {
		return DesHrsMAA;
	}

	public void setDesHrsMAA(String desHrsMAA) {
		DesHrsMAA = desHrsMAA;
	}

	
	

}
