package sv.ues.fia.cargaAcademicaEISI.screen;

import sv.ues.fia.cargaAcademicaEISI.ControlBD;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;

public class ActividadAcademicaEliminarScreen extends MainScreen implements FieldChangeListener{

	private EditField idActAcad;
	private ButtonField bt1;
	private LabelField lb1;
	public ControlBD bdh;
	/**
	 * 
	 */
	public ActividadAcademicaEliminarScreen() {
		super(MainScreen.VERTICAL_SCROLL | MainScreen.VERTICAL_SCROLLBAR);
		// TODO Auto-generated constructor stub
		setTitle("Eliminar Local"); 
		 bdh = new ControlBD();
		 idActAcad = new EditField("Codigo de Actividad:  ","",6,EditField.FILTER_DEFAULT);
		 bt1 = new ButtonField("Eliminar Registro",ButtonField.CONSUME_CLICK);
		 bt1.setChangeListener(this);
		 lb1 = new LabelField("");
		 add(idActAcad);
		 add(bt1);
		 add(lb1);

	}
	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		boolean m;
		if(field.equals(bt1))
		{
			bdh.Abrir();
			m=bdh.eliminarLocal(idActAcad.getText());
			bdh.Cerrar();
		if(m)
			lb1.setText("Se elimino la actividad.");
		else
			lb1.setText("Error en eliminacion.");
		}
	}

}
