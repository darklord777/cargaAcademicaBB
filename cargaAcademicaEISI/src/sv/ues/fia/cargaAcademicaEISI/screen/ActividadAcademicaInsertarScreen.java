package sv.ues.fia.cargaAcademicaEISI.screen;

import sv.ues.fia.cargaAcademicaEISI.ActividadAcademica;
import sv.ues.fia.cargaAcademicaEISI.ControlBD;
import sv.ues.fia.cargaAcademicaEISI.Locales;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;

public class ActividadAcademicaInsertarScreen extends MainScreen implements FieldChangeListener{

	private EditField idActAcad;
	private EditField idModA;
	private EditField nombre;
	private EditField cargo;
	private ButtonField bt1;
	private LabelField lb1;
	public ControlBD bdh;
	
	/**
	 * 
	 */
	public ActividadAcademicaInsertarScreen() {
		super(MainScreen.VERTICAL_SCROLL | MainScreen.VERTICAL_SCROLLBAR);
		// TODO Auto-generated constructor stub
		setTitle("Insertar Actividad Academica"); 
		bdh = new ControlBD();
		idActAcad = new EditField("Codigo Actividad:","",6,EditField.FILTER_DEFAULT);
		idModA = new EditField("Codigo de modalidad:","",6,EditField.FILTER_DEFAULT);
		nombre = new EditField("Nombre de Actividad :","",25,EditField.FILTER_DEFAULT);
		cargo = new EditField("Cargo :","",25,EditField.FILTER_DEFAULT);
		
		bt1 = new ButtonField("Insertar Actividad Academica",ButtonField.CONSUME_CLICK);
		bt1.setChangeListener(this);
		lb1 = new LabelField("");
		 add(idActAcad);
		 add(idModA);
		 add(nombre);
		 add(cargo);
		 add(bt1);
		 add(lb1);
	}

	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		boolean a;
		if (field.equals(bt1)) {
			ActividadAcademica al = new ActividadAcademica();
			if(idActAcad.getText()=="" || idModA.getText()==""){
				lb1.setText("Todos Los campos son obligatorios");	
			}
			else
			{
				al.setIdActividadAcad(idActAcad.getText());
				al.setIdModalActAcad(idModA.getText());
				al.setNombreActAcademica(nombre.getText());
				al.setCargo(cargo.getText());
				bdh.Abrir();
				a = bdh.Insertar(al);
				bdh.Cerrar();
	
				if (a) {
					lb1.setText("Insercion realizada con exito.");
					idActAcad.setText("");
					idModA.setText("");
					nombre.setText("");
					cargo.setText("");
					idActAcad.setFocus();
				}
	
				else
					lb1.setText("No se pudo realizar la insercion.");				
			}			
		}
		
	}

}
