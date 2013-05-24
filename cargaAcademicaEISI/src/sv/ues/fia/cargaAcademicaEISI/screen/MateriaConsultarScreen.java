package sv.ues.fia.cargaAcademicaEISI.screen;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;
import sv.ues.fia.cargaAcademicaEISI.ControlBD;
import sv.ues.fia.cargaAcademicaEISI.Materia;

public class MateriaConsultarScreen extends MainScreen implements
		FieldChangeListener {
	private EditField codmat;
	private EditField nommat;
	private ButtonField bt1;
	private LabelField lb1;
	public ControlBD bdh;

	public MateriaConsultarScreen() {
		setTitle("Consultar Materia");
		bdh = new ControlBD();
		codmat = new EditField("Codigo materia a consultar :", "", 6,
				EditField.EDITABLE);
		nommat = new EditField("Nombre materia :", "", 20, EditField.EDITABLE);
		bt1 = new ButtonField("Consultar Materia", ButtonField.CONSUME_CLICK);
		bt1.setChangeListener(this);
		lb1 = new LabelField("");
		add(codmat);
		add(nommat);
		add(bt1);
		add(lb1);
	}

	public void fieldChanged(Field field, int context) {
		if (field.equals(bt1)) {
			Materia materia = new Materia();
			if (!codmat.getText().toString().trim().equals("")) {
				bdh.Abrir();
				materia = bdh.ConsultarMateria(codmat.getText().toString());
				bdh.Cerrar();
				if (materia != null) {
					nommat.setText(materia.getNom_materia());
					lb1.setText("");
				} else {
					lb1.setText("No se encuentra la Materia.");
				}
			} else {
				lb1.setText("Debe indicar el codigo de Materia");
			}

		}
	}

}
