package sv.ues.fia.cargaAcademicaEISI.screen;

import sv.ues.fia.cargaAcademicaEISI.ControlBD;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;

public class PeriodoEliminarScreen extends MainScreen implements FieldChangeListener {

	private EditField idperiodo;
	private ButtonField bt1;
	public ControlBD bdh;
	private LabelField lb1;
	
	public PeriodoEliminarScreen() {
		setTitle("Eliminar Periodo");
		bdh = new ControlBD();
		idperiodo = new EditField("IdPeriodo:","",6,EditField.FILTER_DEFAULT);
		bt1 = new ButtonField("Eliminar",ButtonField.CONSUME_CLICK);
		bt1.setChangeListener(this);
		lb1 = new LabelField("");
		add(idperiodo);
		add(bt1);
		add(lb1);
		}
		public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		boolean m;
		if(field.equals(bt1))
		{
		bdh.Abrir();
		m=bdh.EliminarPeriodo(idperiodo.getText());
		bdh.Cerrar();
		if(m)
		lb1.setText("Se elimino el periodo.");
		else
		lb1.setText("Error en eliminacion.");
		}
		}
		
	}


