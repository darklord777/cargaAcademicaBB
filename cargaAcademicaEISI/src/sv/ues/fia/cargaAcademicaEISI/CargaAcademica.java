package sv.ues.fia.cargaAcademicaEISI;

public class CargaAcademica {
	private String iddocente;
	private String anio;
	private String numero;

	public CargaAcademica() {
		// TODO Auto-generated constructor stub
	}

	public CargaAcademica(String iddocente, String anio, String numero) {
		this.iddocente = iddocente;
		this.anio = anio;
		this.numero = numero;
	}

	public String getIddocente() {
		return iddocente;
	}

	public void setIddocente(String iddocente) {
		this.iddocente = iddocente;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
