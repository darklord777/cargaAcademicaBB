package sv.ues.fia.cargaAcademicaEISI;

public class DetalleCargaMat {
	private String iddocente;
	private String anio;
	private String numero;
	private String iddetallecurso;

	public DetalleCargaMat() {
		// TODO Auto-generated constructor stub
	}

	public DetalleCargaMat(String iddocente, String anio, String numero,
			String iddetallecurso) {
		this.iddocente = iddocente;
		this.anio = anio;
		this.numero = numero;
		this.iddetallecurso = iddetallecurso;
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

	public String getIddetallecurso() {
		return iddetallecurso;
	}

	public void setIddetallecurso(String iddetallecurso) {
		this.iddetallecurso = iddetallecurso;
	}

}
