package sv.ues.fia.cargaAcademicaEISI;

public class Modalidad_ActAcad {
	private String idModalActAcad;
	private String NombreModalAA;
	private int DesHrsMAA;
	
	public Modalidad_ActAcad(){
		
	}
	
	public Modalidad_ActAcad(String idModalActAcad, String nombreModalAA,int desHrsMAA) {
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

	public int getDesHrsMAA() {
		return DesHrsMAA;
	}

	public void setDesHrsMAA(int desHrsMAA) {
		DesHrsMAA = desHrsMAA;
	}
	

}
