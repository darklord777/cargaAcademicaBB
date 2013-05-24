package sv.ues.fia.cargaAcademicaEISI;

import net.rim.device.api.database.Cursor;
import net.rim.device.api.database.Database;
import net.rim.device.api.database.DatabaseException;
import net.rim.device.api.database.DatabaseFactory;
import net.rim.device.api.database.Row;
import net.rim.device.api.database.Statement;
import net.rim.device.api.io.URI;

public class ControlBD {
	Database db;
	URI uri1;

	public void CrearBase() {
		Statement st;
		try {
			st = db.createStatement("CREATE TABLE ACTIVIDAD_ACADEMICA ( IDACTACAD VARCHAR(6) NOT NULL PRIMARY KEY,IDMODALIDAD VARCHAR(6), NOM_ACT_ACAD VARCHAR(30), CARGO VARCHAR(20), CONSTRAINT fk_activida_modalida FOREIGN KEY (IDMODALIDAD) REFERENCES MODALIDAD_ACT_ACAD (IDMODALIDAD) ON DELETE RESTRICT);");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TABLE AREA_MATERIA ( IDAREAMAT VARCHAR(6) NOT NULL PRIMARY KEY, IDDEPARTAMENTO VARCHAR(6), CODIGOMATERIA VARCHAR(6), CONSTRAINT fk_area_departam FOREIGN KEY (IDDEPARTAMENTO) REFERENCES DEPARTAMENTO (IDDEPARTAMENTO) ON DELETE RESTRICT, CONSTRAINT fk_area_materia FOREIGN KEY (CODIGOMATERIA) REFERENCES MATERIA (CODIGOMATERIA) ON DELETE RESTRICT);");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TABLE [CARGA_ACADEMICA] ( [IDDOCENTE] VARCHAR(8)  NOT NULL, [ANIO] VARCHAR(4)  NOT NULL, [NUMERO] VARCHAR(2) NOT NULL, PRIMARY KEY ([IDDOCENTE],[ANIO],[NUMERO]));");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TABLE CARGO ( IDCARGO VARCHAR(5) NOT NULL PRIMARY KEY, NOM_CARGO  VARCHAR(20));");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TABLE [CICLO] ( [ANIO] VARCHAR(4)  NOT NULL, [NUMERO] VARCHAR(2)  NOT NULL, [FECHAINI] DATE DEFAULT CURRENT_DATE NULL, [FECHAFIN] DATE  NULL, PRIMARY KEY ([ANIO],[NUMERO]));");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TABLE DEPARTAMENTO ( IDDEPARTAMENTO  VARCHAR(6)  NOT NULL PRIMARY KEY, NOM_DEPTO VARCHAR(20));");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TABLE [DETALLE_CARGA_ACT_ACAD] ( [IDDOCENTE] VARCHAR(8) NULL, [ANIO] VARCHAR(4) NULL, [NUMERO] VARCHAR(2) NULL, [IDACTACAD] VARCHAR(6) NULL);");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TABLE [DETALLE_CARGA_MAT] ( [IDDOCENTE] VARCHAR(8) NULL, [ANIO] VARCHAR(4) NULL, [NUMERO] VARCHAR(2) NULL, [IDDETALLECURSO] VARCHAR(6) NULL);");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TABLE DETALLE_GRUPO_ASIGNADO ( IDDETALLECURSO  VARCHAR(6)  NOT NULL PRIMARY KEY, CODIGOMATERIA VARCHAR(6), IDMODALIDAD VARCHAR(6), IDLOCAL VARCHAR(6), constraint fk_detalle_materia FOREIGN KEY (CODIGOMATERIA) REFERENCES MATERIA (CODIGOMATERIA) ON DELETE RESTRICT, constraint fk_detalle_modalidad FOREIGN KEY (IDMODALIDAD) REFERENCES MODALIDAD_CURSO (IDMODALIDAD) ON DELETE RESTRICT, constraint fk_detalle_local FOREIGN KEY (IDLOCAL) REFERENCES LOCALES (IDLOCAL) ON DELETE RESTRICT);");
			st.prepare();
			st.execute();
			st.reset();
			st.close();

			st = db.createStatement("CREATE TABLE [DOCENTE] ( [IDDOCENTE] VARCHAR(8) PRIMARY KEY NOT NULL, [IDCONTRATO] VARCHAR(5) NULL, [NOMBRE] VARCHAR(50) NULL, [APELLIDO] VARCHAR(50) NULL, [GRADO_ACAD] VARCHAR(25) NULL, [CORREO] VARCHAR(20) NULL, [TELEFONO] VARCHAR(15) NULL, [HORAS_ASIG] INTEGER NULL);");
			st.prepare();
			st.execute();
			st.reset();
			st.close();

			st = db.createStatement("CREATE TABLE DOCENTE_CARGO ( IDDOCCAR VARCHAR(6) NOT NULL PRIMARY KEY, IDDOCENTE VARCHAR(8), IDPERIODO VARCHAR(6), IDCARGO VARCHAR(5), CONSTRAINT fk_docente_periodo FOREIGN KEY (IDPERIODO) REFERENCES PERIODO (IDPERIODO) ON DELETE RESTRICT, CONSTRAINT fk_docente_cargo FOREIGN KEY (IDCARGO) REFERENCES CARGO (IDCARGO) ON DELETE RESTRICT, CONSTRAINT fk_docente_docente FOREIGN KEY (IDDOCENTE) REFERENCES DOCENTE (IDDOCENTE) ON DELETE RESTRICT);");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TABLE DOCENTE_DPTO ( IDDEPARTAMENTO VARCHAR(6) NOT NULL, IDDOCENTE VARCHAR(8) NOT NULL, PRIMARY KEY (IDDEPARTAMENTO, IDDOCENTE), CONSTRAINT fk_docent_departam FOREIGN KEY (IDDEPARTAMENTO) REFERENCES DEPARTAMENTO (IDDEPARTAMENTO) ON DELETE RESTRICT, CONSTRAINT fk_docente_pertenece FOREIGN KEY (IDDOCENTE) REFERENCES DOCENTE (IDDOCENTE) ON DELETE RESTRICT);");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TABLE [LOCALES] ( [IDLOCAL] VARCHAR(6)  PRIMARY KEY NOT NULL,[CAPACIDAD] INTEGER  NULL);");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TABLE [MATERIA] ( [CODIGOMATERIA] VARCHAR(6)  PRIMARY KEY NOT NULL,[NOM_MATERIA] VARCHAR(20)  NULL);");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TABLE MAT_AREA_PUEDE_IMPARTIR ( IDDOCENTE  VARCHAR(8)  NOT NULL, IDAREAMAT  VARCHAR(6)  NOT NULL, PRIMARY KEY (IDDOCENTE, IDAREAMAT), CONSTRAINT fk_mat_area FOREIGN KEY (IDAREAMAT) REFERENCES AREA_MATERIA (IDAREAMAT) ON DELETE RESTRICT, CONSTRAINT fk_mat_docente FOREIGN KEY (IDDOCENTE) REFERENCES DOCENTE (IDDOCENTE) ON DELETE RESTRICT);");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TABLE [MODALIDAD_ACT_ACAD] ( [IDMODALIDAD] VARCHAR(6) PRIMARY KEY NOT NULL, [NOM_MODALIDAD] VARCHAR(25) NULL, [DESCUENTO_HORAS] INTEGER  NULL);");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TABLE MODALIDAD_CURSO ( IDMODALIDAD VARCHAR(6) NOT NULL PRIMARY KEY, NOM_MODALIDAD VARCHAR(20), DESCUENTO_HORAS  INTEGER);");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TABLE PERIODO ( IDPERIODO VARCHAR(6) NOT NULL PRIMARY KEY, FECHA_INI DATE, FECHA_FIN DATE);");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TABLE TIPO_CONTRATO ( IDCONTRATO VARCHAR(5) NOT NULL PRIMARY KEY, TIPO VARCHAR(25), HORAS INTEGER);");
			st.prepare();
			st.execute();
			st.reset();
			st.close();

			/* prueba */st = db
					.createStatement("INSERT INTO DOCENTE VALUES('10','001','Alexis','Roque','ingeniero','nada@NADA.com','7777-7777',14);");
			st.prepare();
			st.execute();
			st.reset();
			st.close();

			// TRIGGERS DE INTEGRIDAD REFERENCIAL
			st = db.createStatement("CREATE TRIGGER fk_activida_modalida BEFORE INSERT ON ACTIVIDAD_ACADEMICA FOR EACH ROW BEGIN SELECT CASE WHEN ((SELECT IDMODALIDAD FROM MODALIDAD_ACT_ACAD WHERE IDMODALIDAD = NEW.IDMODALIDAD) IS NULL) THEN RAISE(ABORT, 'No existe esta Modalidad') END; END;");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TRIGGER fk_area_departam BEFORE INSERT ON AREA_MATERIA FOR EACH ROW BEGIN SELECT CASE WHEN ((SELECT IDDEPERTAMENTO FROM DEPARTAMENTO WHERE IDDEPARTAMENTO = NEW.IDDEPARTAMENTO) IS NULL) THEN RAISE(ABORT, 'No existe el Departamento') END; END;");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			// OTROS TRIGGERS

			st = db.createStatement("CREATE TRIGGER fk_area_materia BEFORE INSERT ON AREA_MATERIA FOR EACH ROW BEGIN SELECT CASE WHEN ((SELECT CODIGOMATERIA FROM MATERIA WHERE CODIGOMATERIA = NEW.CODIGOMATERIA) IS NULL) THEN RAISE(ABORT, 'No existe la Materia') END; END;");
			st.prepare();
			st.execute();
			st.reset();
			st.close();

			st = db.createStatement("CREATE TRIGGER [fk_carga_ciclo] BEFORE INSERT ON [CARGA_ACADEMICA] FOR EACH ROW BEGIN SELECT CASE WHEN ((SELECT ANIO FROM CICLO WHERE (ANIO = NEW.ANIO AND NUMERO = NEW.NUMERO)) IS NULL) THEN RAISE(ABORT, 'No existe el Ciclo') END; END;");
			st.prepare();
			st.execute();
			st.reset();
			st.close();

			st = db.createStatement("CREATE TRIGGER [fk_carga_docente] BEFORE INSERT ON [CARGA_ACADEMICA] FOR EACH ROW BEGIN SELECT CASE WHEN ((SELECT IDDOCENTE FROM DOCENTE WHERE IDDOCENTE = NEW.IDDOCENTE) IS NULL) THEN RAISE(ABORT, 'No existe el Docente') END; END;");
			st.prepare();
			st.execute();
			st.reset();
			st.close();

			st = db.createStatement("CREATE TRIGGER [fk_detalle_actividad] BEFORE INSERT ON [DETALLE_CARGA_ACT_ACAD] FOR EACH ROW BEGIN SELECT CASE WHEN ((SELECT IDACTACAD FROM ACTIVIDAD_ACADEMICA WHERE IDACTACAD = NEW.IDACTACAD) IS NULL) THEN RAISE(ABORT, 'No existe esta Actividad Academica') END; END;");
			st.prepare();
			st.execute();
			st.reset();
			st.close();

			st = db.createStatement("CREATE TRIGGER [fk_detalle_carga_acad] BEFORE INSERT ON [DETALLE_CARGA_ACT_ACAD] FOR EACH ROW BEGIN SELECT CASE WHEN ((SELECT IDDOCENTE FROM CARGA_ACADEMICA WHERE IDDOCENTE = NEW.IDDOCENTE AND ANIO = NEW.ANIO AND NUMERO = NEW.NUMERO) IS NULL) THEN RAISE(ABORT, 'No existe esta informacion de Carga Academica') END;END;");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TRIGGER [updateHorasActAcadMas] AFTER INSERT ON [DETALLE_CARGA_ACT_ACAD] FOR EACH ROW BEGIN UPDATE DOCENTE SET HORAS_ASIG = HORAS_ASIG + (SELECT DESCUENTO_HORAS FROM MODALIDAD_ACT_ACAD WHERE IDMODALIDAD = (SELECT IDMODALIDAD FROM ACTIVIDAD_ACADEMICA WHERE IDACTACAD = NEW.IDACTACAD)) WHERE DOCENTE.IDDOCENTE = NEW.IDDOCENTE; END;");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TRIGGER [updateHorasActAcadMenos] AFTER INSERT ON [DETALLE_CARGA_ACT_ACAD] FOR EACH ROW BEGIN UPDATE DOCENTE SET HORAS_ASIG = HORAS_ASIG - (SELECT DESCUENTO_HORAS FROM MODALIDAD_ACT_ACAD WHERE IDMODALIDAD = (SELECT IDMODALIDAD FROM ACTIVIDAD_ACADEMICA WHERE IDACTACAD = NEW.IDACTACAD)) WHERE DOCENTE.IDDOCENTE = NEW.IDDOCENTE;END;");
			st.prepare();
			st.execute();
			st.reset();
			st.close();

			st = db.createStatement("CREATE TRIGGER StopCargaActAcad BEFORE INSERT ON DETALLE_CARGA_ACT_ACAD FOR EACH ROW BEGIN SELECT CASE WHEN ((SELECT HORAS_ASIG FROM DOCENTE WHERE IDDOCENTE = NEW.IDDOCENTE)>=(SELECT HORAS FROM TIPO_CONTRATO WHERE IDCONTRATO = (SELECT IDCONTRATO FROM DOCENTE WHERE IDDOCENTE = NEW.IDDOCENTE))) THEN RAISE(ABORT, 'Ya NO se le puede asiganar mas carga') END;END;");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TRIGGER [fk_detalle_curso] BEFORE INSERT ON [DETALLE_CARGA_MAT] FOR EACH ROW BEGIN SELECT CASE WHEN ((SELECT IDDETALLECURSO FROM DETALLE_GRUPO_ASIGNADO WHERE IDDETALLECURSO = NEW.IDDETALLECURSO) IS NULL) THEN RAISE(ABORT, 'No existe esta informacion de este Curso') END;END;");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TRIGGER [fk_detalle_carga_mat] BEFORE INSERT ON [DETALLE_CARGA_MAT] FOR EACH ROW BEGIN SELECT CASE WHEN ((SELECT IDDOCENTE FROM CARGA_ACADEMICA WHERE IDDOCENTE = NEW.IDDOCENTE AND ANIO = NEW.ANIO AND NUMERO = NEW.NUMERO) IS NULL) THEN RAISE(ABORT, 'No existe esta informacion de Carga Academica') END; END;");
			st.prepare();
			st.execute();
			st.reset();
			st.close();

			st = db.createStatement("CREATE TRIGGER [updateHorasMatMas] AFTER INSERT ON [DETALLE_CARGA_MAT] FOR EACH ROW BEGIN UPDATE DOCENTE SET HORAS_ASIG = HORAS_ASIG + (SELECT DESCUENTO_HORAS FROM MODALIDAD_CURSO WHERE IDMODALIDAD = (SELECT IDMODALIDAD FROM DETALLE_GRUPO_ASIGNADO WHERE IDDETALLECURSO = NEW.IDDETALLECURSO)) WHERE DOCENTE.IDDOCENTE = NEW.IDDOCENTE; END;");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TRIGGER [updateHorasMatMenos] AFTER DELETE ON [DETALLE_CARGA_MAT] FOR EACH ROW BEGIN UPDATE DOCENTE SET HORAS_ASIG = HORAS_ASIG - (SELECT DESCUENTO_HORAS FROM MODALIDAD_CURSO WHERE IDMODALIDAD = (SELECT IDMODALIDAD FROM DETALLE_GRUPO_ASIGNADO WHERE IDDETALLECURSO = OLD.IDDETALLECURSO)) WHERE DOCENTE.IDDOCENTE = OLD.IDDOCENTE; END;");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TRIGGER [StopCargaMat] BEFORE INSERT ON [DETALLE_CARGA_MAT] FOR EACH ROW BEGIN SELECT CASE WHEN ((SELECT HORAS_ASIG FROM DOCENTE WHERE IDDOCENTE = NEW.IDDOCENTE)>=(SELECT HORAS FROM TIPO_CONTRATO WHERE IDCONTRATO = (SELECT IDCONTRATO FROM DOCENTE WHERE IDDOCENTE = NEW.IDDOCENTE))) THEN RAISE(ABORT, 'Ya NO se le puede asiganar mas carga') END;END;");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TRIGGER fk_detalle_materia BEFORE INSERT ON DETALLE_GRUPO_ASIGNADO FOR EACH ROW BEGIN SELECT CASE WHEN ((SELECT CODIGOMATERIA FROM MATERIA WHERE CODIGOMATERIA = NEW.CODIGOMATERIA) IS NULL) THEN RAISE(ABORT, 'No existe esta Materia') END;END;");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TRIGGER fk_detalle_modalidad BEFORE INSERT ON DETALLE_GRUPO_ASIGNADO FOR EACH ROW BEGIN SELECT CASE WHEN ((SELECT IDMODALIDAD FROM MODALIDAD_CURSO WHERE IDMODALIDAD = NEW.IDMODALIDAD) IS NULL) THEN RAISE(ABORT, 'No existe esta Modalidad') END; END;");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TRIGGER fk_detalle_local BEFORE INSERT ON DETALLE_GRUPO_ASIGNADO FOR EACH ROW BEGIN SELECT CASE WHEN ((SELECT IDLOCAL FROM LOCALES WHERE IDLOCAL = NEW.IDLOCAL) IS NULL) THEN RAISE(ABORT, 'No existe este Local') END; END;");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TRIGGER [fk_docente_contrato] BEFORE INSERT ON [DOCENTE] FOR EACH ROW BEGIN SELECT CASE WHEN ((SELECT IDCONTRATO FROM TIPO_CONTRATO WHERE IDCONTRATO = NEW.IDCONTRATO) IS NULL) THEN RAISE(ABORT, 'No existe este Tipo de Contrato') END;END;");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TRIGGER fk_docente_periodo BEFORE INSERT ON DOCENTE_CARGO FOR EACH ROW BEGIN SELECT CASE WHEN ((SELECT IDPERIODO FROM PERIODO WHERE IDPERIODO = NEW.IDPERIODO) IS NULL) THEN RAISE(ABORT, 'No existe este Periodo') END; END;");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TRIGGER fk_docente_cargo BEFORE INSERT ON DOCENTE_CARGO FOR EACH ROW BEGIN SELECT CASE WHEN ((SELECT IDCARGO FROM CARGO WHERE IDCARGO = NEW.IDCARGO) IS NULL) THEN RAISE(ABORT, 'No existe este Cargo') END; END;");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TRIGGER fk_docente_docente BEFORE INSERT ON DOCENTE_CARGO FOR EACH ROW BEGIN SELECT CASE WHEN ((SELECT IDDOCENTE FROM DOCENTE WHERE IDDOCENTE = NEW.IDDOCENTE) IS NULL) THEN RAISE(ABORT, 'No existe este Docente') END;END;");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TRIGGER fk_docente_pertenece BEFORE INSERT ON DOCENTE_DPTO FOR EACH ROW BEGIN SELECT CASE WHEN ((SELECT IDDOCENTE FROM DOCENTE WHERE IDDOCENTE = NEW.IDDOCENTE) IS NULL) THEN RAISE(ABORT, 'No existe este Docente') END;END;");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TRIGGER [fk_docente_departamento] BEFORE INSERT ON [DOCENTE_DPTO] FOR EACH ROW BEGIN SELECT CASE WHEN ((SELECT IDDEPARTAMENTO FROM DEPARTAMENTO WHERE IDDEPARTAMENTO = NEW.IDDEPARTAMENTO) IS NULL) THEN RAISE(ABORT, 'No existe este Departamento') END;END;");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TRIGGER fk_mat_area BEFORE INSERT ON MAT_AREA_PUEDE_IMPARTIR FOR EACH ROW BEGIN SELECT CASE WHEN ((SELECT IDAREAMAT FROM AREA_MATERIA WHERE IDAREAMAT = NEW.IDAREAMAT) IS NULL) THEN RAISE(ABORT, 'No existe esta Materia') END; END;");
			st.prepare();
			st.execute();
			st.reset();
			st.close();
			st = db.createStatement("CREATE TRIGGER fk_mat_docente BEFORE INSERT ON MAT_AREA_PUEDE_IMPARTIR FOR EACH ROW BEGIN SELECT CASE WHEN ((SELECT IDDOCENTE FROM DOCENTE WHERE IDDOCENTE = NEW.IDDOCENTE) IS NULL) THEN RAISE(ABORT, 'No existe este Docente') END; END;");
			st.prepare();
			st.execute();
			st.reset();
			st.close();

		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// fin crear BD

	public void Abrir() {
		try {
			uri1 = URI.create("file:///SDCard/Databases/BDCargaAcademica.s3db");
			if (DatabaseFactory.exists(uri1)) {
				db = DatabaseFactory.open(uri1);
			} else {
				db = DatabaseFactory.create(uri1);
				this.CrearBase();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
	}

	public void Cerrar() {
		try {
			db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// METODOS ALEXIS
	// ----------------------------------------------------------------------------------
	// INSERTAR EN TABLA CICLO
	public boolean Insertar(Ciclo a) {
		try {
			Statement st = db
					.createStatement("INSERT INTO CICLO(ANIO,NUMERO,FECHAINI,FECHAFIN) VALUES (?,?,?,?)");
			st.prepare();
			st.bind(1, a.getAnio());
			st.bind(2, a.getNumero());
			st.bind(3, a.getFechaini());
			st.bind(4, a.getFechafin());
			st.execute();
			st.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean EliminarCiclo(String anio, String numero) {
		try {
			Statement st = db
					.createStatement("DELETE FROM CICLO WHERE ANIO=? AND NUMERO=?");
			st.prepare();
			st.bind(1, anio);
			st.bind(2, numero);
			st.execute();
			st.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public Ciclo ConsultarCiclo(String anio, String numero) {
		Ciclo al = new Ciclo();
		try {
			Statement st = db
					.createStatement("SELECT FECHAINI,FECHAFIN FROM CICLO WHERE ANIO=? AND NUMERO=?");
			st.prepare();
			st.bind(1, anio);
			st.bind(2, numero);
			Cursor c = st.getCursor();
			Row r;
			if (c.next()) {
				r = c.getRow();
				al.setAnio(anio);
				al.setNumero(numero);
				al.setFechaini(r.getString(0));
				al.setFechafin(r.getString(1));
				st.close();
			} else {
				st.close();
				al = null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			al = null;
		}
		return al;
	}

	public boolean Actualizar(Ciclo al) {
		try {
			Statement st = db
					.createStatement("UPDATE CICLO SET FECHAINI=?,FECHAFIN=?");
			st.prepare();
			st.bind(1, al.getFechaini());
			st.bind(2, al.getFechafin());
			st.execute();
			st.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public boolean Insertar(CargaAcademica n) {
		try {
			Statement st = db
					.createStatement("INSERT INTO CARGA_ACADEMICA(IDDOCENTE,ANIO,NUMERO) VALUES (?,?,?)");
			st.prepare();
			st.bind(1, n.getIddocente());
			st.bind(2, n.getAnio());
			st.bind(3, n.getNumero());
			st.execute();
			st.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public CargaAcademica ConsultarCargaAcademica(String iddocente,
			String anio, String numero) {
		CargaAcademica nt = new CargaAcademica();
		try {
			Statement st = db
					.createStatement("SELECT * FROM CARGA_ACADEMICA WHERE IDDOCENTE=? AND ANIO=? AND NUMERO=?");
			st.prepare();
			st.bind(1, iddocente);
			st.bind(2, anio);
			st.bind(3, numero);
			Cursor c = st.getCursor();
			Row r;
			Statement st2 = db
					.createStatement("SELECT NOMBRE FROM DOCENTE WHERE IDDOCENTE=?");
			st2.prepare();
			st2.bind(1, iddocente);
			Cursor c2 = st2.getCursor();
			Row r2;
			if (c.next() && c2.next()) {
				r = c.getRow();
				r2 = c2.getRow();
				nt.setIddocente(r2.getString(0));
				nt.setAnio(anio);
				nt.setNumero(numero);
				st.close();
			} else {
				st.close();
				nt = null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return nt;
	}

	public boolean EliminarCargaAcademica(String iddocente, String anio,
			String numero) {
		try {
			Statement st = db
					.createStatement("DELETE FROM CARGA_ACADEMICA WHERE IDDOCENTE=? AND ANIO=? AND NUMERO=?");
			st.prepare();
			st.bind(1, iddocente);
			st.bind(2, anio);
			st.bind(3, numero);
			st.execute();
			st.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public boolean VerificarEliminarCargaAcademica(String iddocente,
			String anio, String numero) {
		try {
			Statement st = db
					.createStatement("SELECT * FROM DETALLE_CARGA_MAT WHERE IDDOCENTE=? AND ANIO=? AND NUMERO=?");
			st.prepare();
			st.bind(1, iddocente);
			st.bind(2, anio);
			st.bind(3, numero);
			st.execute();
			st.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public boolean Insertar(DetalleCargaMat n) {
		try {
			Statement st = db
					.createStatement("INSERT INTO DETALLE_CARGA_MAT(IDDOCENTE,ANIO,NUMERO,IDDETALLECURSO) VALUES (?,?,?,?)");
			st.prepare();
			st.bind(1, n.getIddocente());
			st.bind(2, n.getAnio());
			st.bind(3, n.getNumero());
			st.bind(4, n.getIddetallecurso());
			st.execute();
			st.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public boolean VerificarInsertarDetalleCArgaMat(String iddocente,
			String anio, String numero, String iddetallecurso) {
		try {
			Statement st = db
					.createStatement("SELECT * FROM DETALLE_CARGA_MAT WHERE IDDOCENTE=? AND ANIO=? AND NUMERO=? AND IDDETALLECURSO=?");
			st.prepare();
			st.bind(1, iddocente);
			st.bind(2, anio);
			st.bind(3, numero);
			st.bind(3, iddetallecurso);
			st.execute();
			st.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public DetalleCargaMat ConsultarCargaMat(String iddocente, String anio,
			String numero, String iddetallecurso) {
		DetalleCargaMat nt = new DetalleCargaMat();
		try {
			Statement st = db
					.createStatement("SELECT * FROM DETALLE_CARGA_MAT WHERE IDDOCENTE=? AND ANIO=? AND NUMERO=? AND IDDETALLECURSO=?");
			st.prepare();
			st.bind(1, iddocente);
			st.bind(2, anio);
			st.bind(3, numero);
			st.bind(4, iddetallecurso);
			Cursor c = st.getCursor();
			Row r;
			Statement st2 = db
					.createStatement("SELECT CODIGOMATERIA FROM DETALLE_GRUPO_ASIGNADO WHERE IDDETALLECURSO=?");
			st2.prepare();
			st2.bind(1, iddetallecurso);
			Cursor c2 = st2.getCursor();
			Row r2;
			if (c.next() && c2.next()) {
				r = c.getRow();
				r2 = c2.getRow();
				nt.setIddocente(r2.getString(0));// manda codigo materias para
													// mostrar en mensaje
				nt.setAnio(anio);
				nt.setNumero(numero);
				nt.setIddetallecurso(iddetallecurso);
				st.close();
			} else {
				st.close();
				nt = null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return nt;
	}

	public boolean Insertar(DetalleCargaActAcad n) {
		try {
			Statement st = db
					.createStatement("INSERT INTO DETALLE_CARGA_ACT_ACAD(IDDOCENTE,ANIO,NUMERO,IDACTACAD) VALUES (?,?,?,?)");
			st.prepare();
			st.bind(1, n.getIddocente());
			st.bind(2, n.getAnio());
			st.bind(3, n.getNumero());
			st.bind(4, n.getIddactacad());
			st.execute();
			st.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	// METODOS MARIO
	// ----------------------------------------------------------------------------------
	public boolean Insertar(Departamento departamento) {
		try {
			Statement st = db
					.createStatement("INSERT INTO DEPARTAMENTO(IDDEPARTAMENTO, NOM_DEPTO) VALUES (?,?)");
			st.prepare();
			st.bind(1, departamento.getIddepartamento());
			st.bind(2, departamento.getNom_depto());

			st.execute();
			st.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean Insertar(Materia materia) {
		try {
			Statement st = db
					.createStatement("INSERT INTO MATERIA(CODIGOMATERIA, NOM_MATERIA) VALUES (?,?)");
			st.prepare();
			st.bind(1, materia.getCodigomateria());
			st.bind(2, materia.getNom_materia());

			st.execute();
			st.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean Insertar(AreaMateria materia) {
		try {
			Statement st = db
					.createStatement("INSERT INTO AREA_MATERIA(IDAREAMAT, IDDEPARTAMENTO, CODIGOMATERIA) VALUES (?,?,?)");
			st.prepare();
			st.bind(1, materia.getIdareamateria());
			st.bind(2, materia.getIddepartamento());
			st.bind(3, materia.getCodigomateria());

			st.execute();
			st.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean Insertar(DetalleGrupoAsignado asignado) {
		try {
			Statement st = db
					.createStatement("INSERT INTO DETALLE_GRUPO_ASIGNADO(IDDETALLECURSO, CODIGOMATERIA,IDMODALIDAD,IDLOCAL) VALUES (?,?,?,?)");
			st.prepare();
			st.bind(1, asignado.getIddetallecurso());
			st.bind(2, asignado.getCodigomateria());
			st.bind(3, asignado.getIdmodalidad());
			st.bind(4, asignado.getIdlocal());

			st.execute();
			st.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean EliminarDepto(String idepto) {
		try {
			Statement st = db
					.createStatement("DELETE FROM DEPARTAMENTO WHERE IDDEPARTAMENTO=?");
			st.prepare();
			st.bind(1, idepto);
			st.execute();
			st.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public boolean EliminarMateria(String codmate) {
		try {
			Statement st = db
					.createStatement("DELETE FROM MATERIA WHERE CODIGOMATERIA=?");
			st.prepare();
			st.bind(1, codmate);
			st.execute();
			st.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public boolean EliminarAreaMat(String areamat) {
		try {
			Statement st = db
					.createStatement("DELETE FROM AREA_MATERIA WHERE IDAREAMAT=?");
			st.prepare();
			st.bind(1, areamat);
			st.execute();
			st.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public boolean EliminarDetGpoAsig(String gpoasig) {
		try {
			Statement st = db
					.createStatement("DELETE FROM DETALLE_GRUPO_ASIGNADO WHERE IDDETALLECURSO=?");
			st.prepare();
			st.bind(1, gpoasig);
			st.execute();
			st.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public Departamento ConsultarDepartamento(String idepto) {
		Departamento departamento = new Departamento();
		try {
			Statement st = db
					.createStatement("SELECT NOM_DEPTO FROM DEPARTAMENTO WHERE IDDEPARTAMENTO=?");
			st.prepare();
			st.bind(1, idepto);
			Cursor c = st.getCursor();
			Row r;
			if (c.next()) {
				r = c.getRow();
				departamento.setIddepartamento(idepto);
				departamento.setNom_depto(r.getString(0));
				st.close();
			} else {
				st.close();
				departamento = null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			departamento = null;
		}
		return departamento;
	}

	public Materia ConsultarMateria(String codmat) {
		Materia materia = new Materia();
		try {
			Statement st = db
					.createStatement("SELECT NOM_MATERIA FROM MATERIA WHERE CODIGOMATERIA=?");
			st.prepare();
			st.bind(1, codmat);
			Cursor c = st.getCursor();
			Row r;
			if (c.next()) {
				r = c.getRow();
				materia.setCodigomateria(codmat);
				materia.setNom_materia(r.getString(0));
				st.close();
			} else {
				st.close();
				materia = null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			materia = null;
		}
		return materia;
	}

	public AreaMateria ConsultarAreaMat(String idareamat) {
		AreaMateria materia = new AreaMateria();
		try {
			Statement st = db
					.createStatement("SELECT IDDEPARTAMENTO, CODIGOMATERIA FROM AREA_MATERIA WHERE IDAREAMAT=?");
			st.prepare();
			st.bind(1, idareamat);
			Cursor c = st.getCursor();
			Row r;
			if (c.next()) {
				r = c.getRow();
				materia.setIdareamateria(idareamat);
				materia.setIddepartamento(r.getString(0));
				materia.setCodigomateria(r.getString(1));
				st.close();
			} else {
				st.close();
				materia = null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			materia = null;
		}
		return materia;
	}

	public DetalleGrupoAsignado ConsultarDetGpoAsigt(String idetgpoasig) {
		DetalleGrupoAsignado asignado = new DetalleGrupoAsignado();
		try {
			Statement st = db
					.createStatement("SELECT CODIGOMATERIA, IDMODALIDAD, IDLOCAL FROM DETALLE_GRUPO_ASIGNADO WHERE IDDETALLECURSO=?");
			st.prepare();
			st.bind(1, idetgpoasig);
			Cursor c = st.getCursor();
			Row r;
			if (c.next()) {
				r = c.getRow();
				asignado.setIddetallecurso(idetgpoasig);
				asignado.setCodigomateria(r.getString(0));
				asignado.setIdmodalidad(r.getString(1));
				asignado.setIdlocal(r.getString(1));
				st.close();
			} else {
				st.close();
				asignado = null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			asignado = null;
		}
		return asignado;
	}

	public boolean Actualizar(Departamento departamento) {
		try {
			Statement st = db
					.createStatement("UPDATE DEPARTAMENTO SET NOM_DEPTO=? WHERE IDDEPARTAMENTO=?");
			st.prepare();
			st.bind(1, departamento.getNom_depto());
			st.bind(2, departamento.getIddepartamento());
			st.execute();
			st.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public boolean Actualizar(Materia materia) {
		try {
			Statement st = db
					.createStatement("UPDATE MATERIA SET NOM_MATERIA=? WHERE CODIGOMATERIA=?");
			st.prepare();
			st.bind(1, materia.getNom_materia());
			st.bind(2, materia.getCodigomateria());
			st.execute();
			st.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public boolean Actualizar(AreaMateria materia) {
		try {
			Statement st = db
					.createStatement("UPDATE AREA_MATERIA SET IDDEPARTAMENTO=?, CODIGOMATERIA=? WHERE IDAREAMAT=?");
			st.prepare();
			st.bind(1, materia.getIddepartamento());
			st.bind(2, materia.getCodigomateria());
			st.bind(3, materia.getIdareamateria());
			st.execute();
			st.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	public boolean Actualizar(DetalleGrupoAsignado det) {
		try {
			Statement st = db
					.createStatement("UPDATE DETALLE_GRUPO_ASIGNADO SET CODIGOMATERIA=?, IDMODALIDAD=?, IDLOCAL=? WHERE IDDETALLECURSO=?");
			st.prepare();
			st.bind(1, det.getCodigomateria());
			st.bind(2, det.getIdmodalidad());
			st.bind(3, det.getIdlocal());
			st.bind(4, det.getIddetallecurso());
			st.execute();
			st.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

	// METODOS EMERSON
	// ----------------------------------------------------------------------------------

	// METODOS
	// aGUSTIN----------------------------------------------------------------------------------

	// METODOS SERGIO
	// ----------------------------------------------------------------------------------

}// fin clase ControlBD

