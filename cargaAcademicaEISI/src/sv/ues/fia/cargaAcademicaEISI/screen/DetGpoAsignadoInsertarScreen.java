package sv.ues.fia.cargaAcademicaEISI.screen;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;
import sv.ues.fia.cargaAcademicaEISI.ControlBD;
import sv.ues.fia.cargaAcademicaEISI.DetalleGrupoAsignado;

public class DetGpoAsignadoInsertarScreen extends MainScreen implements
		FieldChangeListener {
	private EditField idetcurso;
	private EditField codmat;
	private EditField idmod;
	private EditField idloc;
	private ButtonField bt1;
	private LabelField lb1;
	public ControlBD bdh;

	public DetGpoAsignadoInsertarScreen() {
		setTitle("Insertar detalle grupo asignado");
		bdh = new ControlBD();
		idetcurso = new EditField("Codigo grupo asignado :", "", 6,
				EditField.EDITABLE);
		codmat = new EditField("Codigo materia :", "", 6, EditField.EDITABLE);
		idmod = new EditField("Codigo modalidad :", "", 6, EditField.EDITABLE);
		idloc = new EditField("Codigo local :", "", 6, EditField.EDITABLE);

		bt1 = new ButtonField("Insertar detalle grupo asignado",
				ButtonField.CONSUME_CLICK);
		bt1.setChangeListener(this);
		lb1 = new LabelField("");

		add(idetcurso);
		add(codmat);
		add(idmod);
		add(idloc);
		add(bt1);
		add(lb1);
	}

	public void fieldChanged(Field field, int context) {
		boolean a;
		if (field.equals(bt1)) {
			DetalleGrupoAsignado asignado = new DetalleGrupoAsignado();
			if (idetcurso.getText().toString().trim().equals("")
					|| codmat.getText().toString().trim().equals("")
					|| idmod.getText().toString().trim().equals("")
					|| idloc.getText().toString().trim().equals("")) {
				lb1.setText("Todos Los campos son obligatorios");
			} else {
				asignado.setIddetallecurso(idetcurso.getText().toString());
				asignado.setCodigomateria(codmat.getText().toString());
				asignado.setIdmodalidad(idmod.getText().toString());
				asignado.setIdlocal(idloc.getText().toString());

				bdh.Abrir();
				a = bdh.Insertar(asignado);
				bdh.Cerrar();

				if (a) {
					lb1.setText("Insercion realizada con exito.");
					idetcurso.setText("");
					codmat.setText("");
					idmod.setText("");
					idloc.setText("");
					idetcurso.setFocus();
				}

				else
					lb1.setText("No se pudo realizar la insercion.");
			}

		}
	}

}
