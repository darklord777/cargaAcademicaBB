package sv.ues.fia.cargaAcademicaEISI.screen;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;
import sv.ues.fia.cargaAcademicaEISI.Ciclo;
import sv.ues.fia.cargaAcademicaEISI.ControlBD;

public class CicloConsultarScreen extends MainScreen  implements FieldChangeListener{

		private EditField anio;
		private EditField numero;
		private EditField fechaini;
		private EditField fechafin;
		private ButtonField bt1;
		public ControlBD bdh;
		private LabelField lb1;

		public CicloConsultarScreen() {
			setTitle("Consultar Alumno");
			bdh = new ControlBD();
			anio = new EditField("Año a Consultar:  ", "", 4, EditField.FILTER_NUMERIC);
			numero = new EditField("Ciclo a Consultar:  ", "", 30,EditField.FILTER_NUMERIC);
			fechaini = new EditField("Fecha Inicio de Ciclo:  ", "", 10,EditField.FILTER_DEFAULT);
			fechafin = new EditField("Fecha Fin de Ciclo:  ", "", 10, EditField.FILTER_DEFAULT);

			bt1 = new ButtonField("Consultar Ciclo", ButtonField.CONSUME_CLICK);
			bt1.setChangeListener(this);
			lb1 = new LabelField("");
			fechaini.setEditable(false);
			fechafin.setEditable(false);
			add(anio);
			add(numero);
			add(bt1);
			add(fechaini);
			add(fechafin);
			add(lb1);
		}

		public void fieldChanged(Field field, int context) {
			// TODO Auto-generated method stub
			if (field.equals(bt1)) {
				Ciclo al = new Ciclo();
				bdh.Abrir();
				al = bdh.ConsultarCiclo(anio.getText(),numero.getText());
				bdh.Cerrar();
				if (al != null) {
					fechaini.setText(al.getFechaini());
					fechafin.setText(al.getFechafin());
					lb1.setText("");
				} else {
					lb1.setText("No se encuentra el Ciclo.");
				}
			}
		}


}