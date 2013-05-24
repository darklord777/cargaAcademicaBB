package sv.ues.fia.cargaAcademicaEISI.screen;

import sv.ues.fia.cargaAcademicaEISI.ControlBD;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;

public class CargoEliminarScreen extends MainScreen implements FieldChangeListener {

	private EditField idcargo;
	private ButtonField bt1;
	public ControlBD bdh;
	private LabelField lb1;
	
	public CargoEliminarScreen() {
		setTitle("Eliminar Cargo");
		bdh = new ControlBD();
		idcargo = new EditField("IdCargo:","",5,EditField.FILTER_DEFAULT);
		bt1 = new ButtonField("Eliminar",ButtonField.CONSUME_CLICK);
		bt1.setChangeListener(this);
		lb1 = new LabelField("");
		add(idcargo);
		add(bt1);
		add(lb1);
		}
		public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		boolean m;
		if(field.equals(bt1))
		{
		bdh.Abrir();
		m=bdh.EliminarCargo(idcargo.getText());
		bdh.Cerrar();
		if(m)
		lb1.setText("Se elimino el cargo.");
		else
		lb1.setText("Error en eliminacion.");
		}
		}
		
	}


