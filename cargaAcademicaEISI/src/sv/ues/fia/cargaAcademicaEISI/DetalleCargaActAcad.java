package sv.ues.fia.cargaAcademicaEISI;

public class DetalleCargaActAcad {
	private String iddocente;
	private String anio;
	private String numero;
	private String iddactacad;

	public DetalleCargaActAcad() {
		// TODO Auto-generated constructor stub
	}

	public DetalleCargaActAcad(String iddocente, String anio, String numero,
			String iddactacad) {
		this.iddocente = iddocente;
		this.anio = anio;
		this.numero = numero;
		this.iddactacad = iddactacad;
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

	public String getIddactacad() {
		return iddactacad;
	}

	public void setIddactacad(String iddactacad) {
		this.iddactacad = iddactacad;
	}

}
