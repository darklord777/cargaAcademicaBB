package sv.ues.fia.cargaAcademicaEISI.screen;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;
import sv.ues.fia.cargaAcademicaEISI.ControlBD;
import sv.ues.fia.cargaAcademicaEISI.Departamento;

public class DepartamentoInsertarScreen extends MainScreen implements
		FieldChangeListener {
	private EditField idepto;
	private EditField nomdepto;
	private ButtonField bt1;
	private LabelField lb1;
	public ControlBD bdh;

	public DepartamentoInsertarScreen() {
		setTitle("Insertar Ciclo");
		bdh = new ControlBD();
		idepto = new EditField("Codigo departamento :", "", 6,
				EditField.EDITABLE);
		nomdepto = new EditField("Nombre departamento :", "", 20,
				EditField.EDITABLE);
		bt1 = new ButtonField("Insertar departamento",
				ButtonField.CONSUME_CLICK);
		bt1.setChangeListener(this);
		lb1 = new LabelField("");
		add(idepto);
		add(nomdepto);
		add(bt1);
		add(lb1);
	}

	public void fieldChanged(Field field, int context) {
		boolean a;
		if (field.equals(bt1)) {
			Departamento departamento = new Departamento();
			if (idepto.getText().toString().trim().equals("")
					|| nomdepto.getText().toString().trim().equals("")) {
				lb1.setText("Todos Los campos son obligatorios");
			} else {
				departamento.setIddepartamento(idepto.getText().toString());
				departamento.setNom_depto(nomdepto.getText().toString());

				bdh.Abrir();
				a = bdh.Insertar(departamento);
				bdh.Cerrar();

				if (a) {
					lb1.setText("Insercion realizada con exito.");
					idepto.setText("");
					nomdepto.setText("");
					idepto.setFocus();
				}

				else
					lb1.setText("No se pudo realizar la insercion.");
			}

		}

	}

}
