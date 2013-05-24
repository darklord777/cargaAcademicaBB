package sv.ues.fia.cargaAcademicaEISI.screen;

import sv.ues.fia.cargaAcademicaEISI.Locales;
import sv.ues.fia.cargaAcademicaEISI.ControlBD;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;

public class LocalesInsertarScreen extends MainScreen implements FieldChangeListener{

	private EditField idLocal;
	private EditField capacidad;
	private ButtonField bt1;
	private LabelField lb1;
	public ControlBD bdh;
	/**
	 * 
	 */
	public LocalesInsertarScreen() {
		super(MainScreen.VERTICAL_SCROLL | MainScreen.VERTICAL_SCROLLBAR);
		// TODO Auto-generated constructor stub		
		setTitle("Insertar Local"); 
		bdh = new ControlBD();
		idLocal = new EditField("Codigo del Local :","",6,EditField.FILTER_DEFAULT);
		capacidad = new EditField("Capacidad :","",4,EditField.FILTER_DEFAULT);
		bt1 = new ButtonField("Insertar Local",ButtonField.CONSUME_CLICK);
		bt1.setChangeListener(this);
		lb1 = new LabelField("");
		 add(idLocal);
		 add(capacidad);
		 add(bt1);
		 add(lb1);
	}

	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		boolean a;
		if (field.equals(bt1)) {
			Locales al = new Locales();
			if(idLocal.getText()=="" || capacidad.getText()==""){
				lb1.setText("Todos Los campos son obligatorios");	
			}
			else
			{
				al.setIdLocal(idLocal.getText());
				al.setCapacidad(capacidad.getText());
				bdh.Abrir();
				a = bdh.Insertar(al);
				bdh.Cerrar();
	
				if (a) {
					lb1.setText("Insercion realizada con exito.");
					idLocal.setText("");
					capacidad.setText("");					
					idLocal.setFocus();
				}
	
				else
					lb1.setText("No se pudo realizar la insercion.");				
			}			
		}
	}
}
