package sv.ues.fia.cargaAcademicaEISI.screen;

import sv.ues.fia.cargaAcademicaEISI.Cargo;
import sv.ues.fia.cargaAcademicaEISI.ControlBD;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;

public class CargoActualizarScreen extends MainScreen implements FieldChangeListener {
	private EditField idcargo;
	private EditField nom_cargo;
	private ButtonField bt1;
	public ControlBD bdh;
	private LabelField lb1;
	
	public CargoActualizarScreen() {
		setTitle("Actualizar Cargo");
		bdh = new ControlBD();
		idcargo = new EditField("IdCargo:","",5,EditField.FILTER_DEFAULT);
		nom_cargo = new EditField("Nombre Alumno:","",20,EditField.FILTER_DEFAULT);
		bt1 = new ButtonField("Modificar",ButtonField.CONSUME_CLICK);
		bt1.setChangeListener(this);
		lb1 = new LabelField("");
		add(idcargo);
		add(nom_cargo);
		add(bt1);
		add(lb1);
		}
		public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		boolean m;
		if(field.equals(bt1))
		{
		Cargo c = new Cargo();
		c.setIdCargo(idcargo.getText());
		c.setNombreCargo(nom_cargo.getText());
		bdh.Abrir();
		m=bdh.Actualizar(c);
		bdh.Cerrar();
		if(m)
		lb1.setText("Se realizo la modificacion");
		else
		lb1.setText("Error en modificacion");
		}
		}
		}