package sv.ues.fia.cargaAcademicaEISI.screen;

import sv.ues.fia.cargaAcademicaEISI.ControlBD;
import sv.ues.fia.cargaAcademicaEISI.Locales;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;

public class LocalesConsultarScreen extends MainScreen implements FieldChangeListener{

	private EditField idLocal;
	private EditField capacidad;
	private ButtonField bt1;
	public ControlBD bdh;
	private LabelField lb1;
	
	/**
	 * 
	 */
	public LocalesConsultarScreen() {
		super(MainScreen.VERTICAL_SCROLL | MainScreen.VERTICAL_SCROLLBAR);
		// TODO Auto-generated constructor stub
		setTitle("Consultar Local");
		bdh = new ControlBD();
		idLocal = new EditField("Codigo Local:","",6,EditField.FILTER_DEFAULT);
		capacidad = new EditField("Capaciad:","",4,EditField.FILTER_DEFAULT);
		bt1 = new ButtonField("Consultar",ButtonField.CONSUME_CLICK);
		bt1.setChangeListener(this);
		lb1 = new LabelField("");
		idLocal.setEditable(false);
		capacidad.setEditable(false);
		add(idLocal);
		add(bt1);
		add(capacidad);
		add(lb1);
	}

	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		if(field.equals(bt1))
		{
		Locales al = new Locales();
		bdh.Abrir();
		al = bdh.ConsultarLocal(idLocal.getText());
		bdh.Cerrar();
		if(al!=null)
		{
		idLocal.setText(al.getIdLocal());
		capacidad.setText(al.getCapacidad());
		lb1.setText("");
		}
		else
		{
		lb1.setText("No se encuentra el local.");
		}
		}
	}

}
