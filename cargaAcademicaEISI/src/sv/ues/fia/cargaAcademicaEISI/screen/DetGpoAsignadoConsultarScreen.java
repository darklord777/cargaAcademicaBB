package sv.ues.fia.cargaAcademicaEISI.screen;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;
import sv.ues.fia.cargaAcademicaEISI.ControlBD;
import sv.ues.fia.cargaAcademicaEISI.DetalleGrupoAsignado;

public class DetGpoAsignadoConsultarScreen extends MainScreen implements
		FieldChangeListener {
	private EditField idetcurso;
	private EditField codmat;
	private EditField idmod;
	private EditField idloc;
	private ButtonField bt1;
	private LabelField lb1;
	public ControlBD bdh;

	public DetGpoAsignadoConsultarScreen() {
		setTitle("Consultar detalle grupo asignado");
		bdh = new ControlBD();
		idetcurso = new EditField("Codigo grupo asignado a consultar :", "", 6,
				EditField.EDITABLE);
		codmat = new EditField("Codigo materia :", "", 6, EditField.EDITABLE);
		idmod = new EditField("Codigo modalidad :", "", 6, EditField.EDITABLE);
		idloc = new EditField("Codigo local :", "", 6, EditField.EDITABLE);

		bt1 = new ButtonField("Consultar detalle grupo asignado",
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
		if (field.equals(bt1)) {
			DetalleGrupoAsignado asignado = new DetalleGrupoAsignado();
			if (!idetcurso.getText().toString().trim().equals("")) {
				bdh.Abrir();
				asignado = bdh.ConsultarDetGpoAsigt(idetcurso.getText().toString());
				bdh.Cerrar();
				if (asignado != null) {
					codmat.setText(asignado.getCodigomateria());
					idmod.setText(asignado.getIdmodalidad());
					idloc.setText(asignado.getIdlocal());
					lb1.setText("");
				} else {
					lb1.setText("No se encuentra la asignacion del grupo.");
				}
			} else {
				lb1.setText("Debe indicar el codigo de grupo asignado");
			}

		}
	}

}
