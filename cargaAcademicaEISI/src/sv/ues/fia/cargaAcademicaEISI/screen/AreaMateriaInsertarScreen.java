package sv.ues.fia.cargaAcademicaEISI.screen;

import sv.ues.fia.cargaAcademicaEISI.AreaMateria;
import sv.ues.fia.cargaAcademicaEISI.ControlBD;
import sv.ues.fia.cargaAcademicaEISI.Materia;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;

public class AreaMateriaInsertarScreen extends MainScreen implements
		FieldChangeListener {
	private EditField idarea;
	private EditField idepto;
	private EditField codmat;
	private ButtonField bt1;
	private LabelField lb1;
	public ControlBD bdh;

	public AreaMateriaInsertarScreen() {
		setTitle("Insertar Area de Materia");
		bdh = new ControlBD();
		idarea = new EditField("Codigo araea materia :", "", 6,
				EditField.EDITABLE);
		idepto = new EditField("Codigo departamento :", "", 6,
				EditField.EDITABLE);
		codmat = new EditField("Codigo materia :", "", 6, EditField.EDITABLE);
		bt1 = new ButtonField("Insertar area Materia",
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
		boolean a;
		if (field.equals(bt1)) {
			AreaMateria materia = new AreaMateria();
			if (idarea.getText().toString().trim().equals("")
					|| idepto.getText().toString().trim().equals("")
					|| codmat.getText().toString().trim().equals("")) {
				lb1.setText("Todos Los campos son obligatorios");
			} else {
				materia.setIdareamateria(idarea.getText().toString());
				materia.setIddepartamento(idepto.getText().toString());
				materia.setCodigomateria(codmat.getText().toString());

				bdh.Abrir();
				a = bdh.Insertar(materia);
				bdh.Cerrar();

				if (a) {
					lb1.setText("Insercion realizada con exito.");
					idarea.setText("");
					idepto.setText("");
					codmat.setText("");
					idarea.setFocus();
				}

				else
					lb1.setText("No se pudo realizar la insercion.");
			}

		}
	}

}
