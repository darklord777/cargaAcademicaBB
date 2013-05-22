package sv.ues.fia.cargaAcademicaEISI.screen;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;
import sv.ues.fia.cargaAcademicaEISI.Ciclo;
import sv.ues.fia.cargaAcademicaEISI.ControlBD;

public class CicloActualizarScreen extends MainScreen implements FieldChangeListener {
	private EditField anio;
	private EditField numero;
	private EditField fechaini;
	private EditField fechafin;
	private ButtonField bt1;
	public ControlBD bdh;
	private LabelField lb1;
	private LabelField lb2;
	private LabelField lb0;
	private LabelField lb3;

	public CicloActualizarScreen() {
		setTitle("Actualizar Ciclo");
		bdh = new ControlBD();
		anio = new EditField("Año a Consultar:  ", "", 4, EditField.FILTER_NUMERIC);
		numero = new EditField("Ciclo a Consultar:  ", "", 30,EditField.FILTER_NUMERIC);
		fechaini = new EditField("Fecha Inicio de Ciclo:  ", "", 10,EditField.FILTER_DEFAULT);
		fechafin = new EditField("Fecha Fin de Ciclo:  ", "", 10, EditField.FILTER_DEFAULT);
				
		bt1 = new ButtonField("Modificar", ButtonField.CONSUME_CLICK);
		bt1.setChangeListener(this);
		lb1 = new LabelField("");
		lb2 = new LabelField("Datos a Actualizar:");
		lb0 = new LabelField("Datos de Ciclo a Actualizar:");
		lb3 = new LabelField(" ");
		add(lb0);
		add(anio);
		add(numero);
		add(lb3);
		add(lb2);
		add(fechaini);
		add(fechafin);
		add(bt1);
		add(lb1);
	}

	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		boolean m;
		if (field.equals(bt1)) {
			Ciclo al = new Ciclo();
			al.setAnio(anio.getText());
			al.setNumero(numero.getText());
			al.setFechaini(fechaini.getText());
			al.setFechafin(fechafin.getText());
			bdh.Abrir();
			m = bdh.Actualizar(al);
			bdh.Cerrar();
			if (m)
				lb1.setText("Se realizo la modificacion");
			else
				lb1.setText("Error en modificacion");
		}
	}
	
	

}
