package sv.ues.fia.cargaAcademicaEISI.screen;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;
import sv.ues.fia.cargaAcademicaEISI.ControlBD;
import sv.ues.fia.cargaAcademicaEISI.DetalleCargaMat;

public class DetalleCargaMatConsultarScreen extends MainScreen implements FieldChangeListener {
	private EditField anio;
	private EditField numero;
	private EditField iddocente;
	private EditField iddetallecurso;
	
	private ButtonField bt1;
	public ControlBD bdh;
	private LabelField lb1;

	public DetalleCargaMatConsultarScreen() {
		setTitle("Consultar Carga Academica");
		bdh = new ControlBD();
		 iddocente = new EditField("ID de Docente:  ","",8,EditField.FILTER_DEFAULT);
		 anio = new EditField("Año del Ciclo:  ","",4,EditField.FILTER_NUMERIC);
		 numero = new EditField("Numero de Ciclo:  ","",1,EditField.FILTER_NUMERIC);
		 iddetallecurso = new EditField("ID del Curso a impartir: ","",6,EditField.FILTER_NUMERIC);

		bt1 = new ButtonField("Consultar Registro", ButtonField.CONSUME_CLICK);
		bt1.setChangeListener(this);
		lb1 = new LabelField("");
		add(iddocente);
		add(anio);
		add(numero);
		add(iddetallecurso);
		add(bt1);
		add(lb1);
	}

	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		if (field.equals(bt1)) {
			DetalleCargaMat nt = new DetalleCargaMat();
			bdh.Abrir();
			nt = bdh.ConsultarCargaMat(iddocente.getText(), anio.getText(),numero.getText(),iddetallecurso.getText());
			bdh.Cerrar();
			if (nt != null) {
				lb1.setText("La Materia "+nt.getIddocente()+" del curso a impartir del Docente CON ID: "+iddocente.getText()+" Existe!");
			} else {
				lb1.setText("No se encuentra el registro Asociado a ID Docente: "+iddocente+" ");
			}
		}
	}

}