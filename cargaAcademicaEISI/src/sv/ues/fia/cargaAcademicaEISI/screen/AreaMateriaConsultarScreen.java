package sv.ues.fia.cargaAcademicaEISI.screen;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;
import sv.ues.fia.cargaAcademicaEISI.AreaMateria;
import sv.ues.fia.cargaAcademicaEISI.ControlBD;

public class AreaMateriaConsultarScreen extends MainScreen implements
		FieldChangeListener {
	private EditField idarea;
	private EditField idepto;
	private EditField codmat;
	private ButtonField bt1;
	private LabelField lb1;
	public ControlBD bdh;

	public AreaMateriaConsultarScreen() {
		setTitle("Consultar Area de Materia");
		bdh = new ControlBD();
		idarea = new EditField("Codigo araea materia a consultar :", "", 6,
				EditField.EDITABLE);
		idepto = new EditField("Codigo departamento :", "", 6,
				EditField.EDITABLE);
		codmat = new EditField("Codigo materia :", "", 6, EditField.EDITABLE);
		bt1 = new ButtonField("Consultar Area de Materia",
				ButtonField.CONSUME_CLICK);
		bt1.setChangeListener(this);
		lb1 = new LabelField("");
		add(idarea);
		add(idepto);
		add(codmat);
		add(bt1);
		add(lb1);
	}

	public void fieldChanged(Field field, int context) {
		if (field.equals(bt1)) {
			AreaMateria materia = new AreaMateria();
			if (!idarea.getText().toString().trim().equals("")) {
				bdh.Abrir();
				materia = bdh.ConsultarAreaMat(idarea.getText().toString());
				bdh.Cerrar();
				if (materia != null) {
					idepto.setText(materia.getIddepartamento());
					codmat.setText(materia.getCodigomateria());
					lb1.setText("");
				} else {
					lb1.setText("No se encuentra el area Materia.");
				}
			} else {
				lb1.setText("Debe indicar el codigo de area Materia");
			}

		}
	}

}
