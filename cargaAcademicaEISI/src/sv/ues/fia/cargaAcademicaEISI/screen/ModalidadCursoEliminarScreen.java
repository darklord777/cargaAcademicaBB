package sv.ues.fia.cargaAcademicaEISI.screen;

import sv.ues.fia.cargaAcademicaEISI.ControlBD;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;

public class ModalidadCursoEliminarScreen extends MainScreen implements FieldChangeListener {

	private EditField idModC;
	private ButtonField bt1;
	private LabelField lb1;
	public ControlBD bdh;
	/**
	 * 
	 */
	public ModalidadCursoEliminarScreen() {
		super(MainScreen.VERTICAL_SCROLL | MainScreen.VERTICAL_SCROLLBAR);
		// TODO Auto-generated constructor stub
		setTitle("Eliminar Modalidad Curso"); 
		 bdh = new ControlBD();
		 idModC = new EditField("Codigo de Modalidad:  ","",6,EditField.FILTER_DEFAULT);
		 bt1 = new ButtonField("Eliminar Registro",ButtonField.CONSUME_CLICK);
		 bt1.setChangeListener(this);
		 lb1 = new LabelField("");
		 add(idModC);
		 add(bt1);
		 add(lb1);
	} 
	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		boolean m;
		if(field.equals(bt1))
		{
			bdh.Abrir();
			m=bdh.eliminarModCurso(idModC.getText());
			bdh.Cerrar();
		if(m)
			lb1.setText("Se elimino el local.");
		else
			lb1.setText("Error en eliminacion.");
		}
	}

}
