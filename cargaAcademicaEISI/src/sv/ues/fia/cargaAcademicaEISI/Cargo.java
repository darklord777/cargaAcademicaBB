package sv.ues.fia.cargaAcademicaEISI;

public class Cargo {
	private String idCargo;
	private String Nombre_Cargo;
	 
	public Cargo(){
		
	}
	public Cargo(String idCargo, String Nombre_Cargo) {
		this.idCargo = idCargo;
		this.Nombre_Cargo = Nombre_Cargo;
		}
		public String getIdCargo() {
		return idCargo;
		}
		public void setIdCargo(String idCargo) {
		this.idCargo = idCargo;
		}
		public String getNombreCargo() {
		return Nombre_Cargo;
		}
		public void setNombreCargo(String Nombre_Cargo) {
			this.Nombre_Cargo = Nombre_Cargo;
			}
}
