package sv.ues.fia.cargaAcademicaEISI.screen;

import sv.ues.fia.cargaAcademicaEISI.Ciclo;
import sv.ues.fia.cargaAcademicaEISI.ControlBD;
import sv.ues.fia.cargaAcademicaEISI.Departamento;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;

public class DepartamentoConsultarScreen extends MainScreen implements
		FieldChangeListener {
	private EditField idepto;
	private EditField nomdepto;
	private ButtonField bt1;
	private LabelField lb1;
	public ControlBD bdh;

	public DepartamentoConsultarScreen() {
		setTitle("Consultar Departamento");
		bdh = new ControlBD();
		idepto = new EditField("Codigo departamento a consultar :", "", 6,
				EditField.EDITABLE);
		nomdepto = new EditField("Nombre departamento :", "", 20,
				EditField.EDITABLE);
		bt1 = new ButtonField("Consultar departamento",
				ButtonField.CONSUME_CLICK);
		bt1.setChangeListener(this);
		lb1 = new LabelField("");
		add(idepto);
		add(nomdepto);
		add(bt1);
		add(lb1);
	}

	public void fieldChanged(Field field, int context) {
		if (field.equals(bt1)) {
			Departamento departamento = new Departamento();
			if (!idepto.getText().toString().trim().equals("")) {
				bdh.Abrir();
				departamento = bdh.ConsultarDepartamento(idepto.getText()
						.toString());
				bdh.Cerrar();
				if (departamento != null) {
					nomdepto.setText(departamento.getNom_depto());
					lb1.setText("");
				} else {
					lb1.setText("No se encuentra el Ciclo.");
				}
			} else {
				lb1.setText("Debe indicar el codigo de departamento");
			}

		}
	}

}
