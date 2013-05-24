package sv.ues.fia.cargaAcademicaEISI.screen;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;
import sv.ues.fia.cargaAcademicaEISI.ControlBD;
import sv.ues.fia.cargaAcademicaEISI.Materia;

public class MateriaInsertarScreen extends MainScreen implements
		FieldChangeListener {
	private EditField codmat;
	private EditField nommat;
	private ButtonField bt1;
	private LabelField lb1;
	public ControlBD bdh;

	public MateriaInsertarScreen() {
		setTitle("Insertar Materia");
		bdh = new ControlBD();
		codmat = new EditField("Codigo materia :", "", 6,
				EditField.EDITABLE);
		nommat = new EditField("Nombre materia :", "", 20,
				EditField.EDITABLE);
		bt1 = new ButtonField("Insertar Materia",
				ButtonField.CONSUME_CLICK);
		bt1.setChangeListener(this);
		lb1 = new LabelField("");
		add(codmat);
		add(nommat);
		add(bt1);
		add(lb1);
	}

	public void fieldChanged(Field field, int context) {
		boolean a;
		if (field.equals(bt1)) {
			Materia materia = new Materia();
			if (codmat.getText().toString().trim().equals("")
					|| nommat.getText().toString().trim().equals("")) {
				lb1.setText("Todos Los campos son obligatorios");
			} else {
				materia.setCodigomateria(codmat.getText().toString());
				materia.setNom_materia(nommat.getText().toString());

				bdh.Abrir();
				a = bdh.Insertar(materia);
				bdh.Cerrar();

				if (a) {
					lb1.setText("Insercion realizada con exito.");
					codmat.setText("");
					nommat.setText("");
					codmat.setFocus();
				}

				else
					lb1.setText("No se pudo realizar la insercion.");
			}

		}
	}

}
