package sv.ues.fia.cargaAcademicaEISI.screen;

import sv.ues.fia.cargaAcademicaEISI.ControlBD;
import sv.ues.fia.cargaAcademicaEISI.Modalidad_ActAcad;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;

public class ModalidadActAcadInsertarScreen extends MainScreen implements FieldChangeListener{


	private EditField idModA;
	private EditField nombreMA;
	private EditField DesHrs;
	private ButtonField bt1;
	private LabelField lb1;
	public ControlBD bdh;
	/**
	 * 
	 */
	public ModalidadActAcadInsertarScreen() {
		super(MainScreen.VERTICAL_SCROLL | MainScreen.VERTICAL_SCROLLBAR);
		// TODO Auto-generated constructor stub
		setTitle("Insertar Modalidad Curso"); 
		bdh = new ControlBD();
		idModA = new EditField("Codigo de modalidad :","",6,EditField.FILTER_DEFAULT);
		nombreMA = new EditField("Nombre de modalidad :","",20,EditField.FILTER_DEFAULT);
		DesHrs = new EditField("Descuento Horas :","",5,EditField.FILTER_DEFAULT);
		bt1 = new ButtonField("Insertar Modalidad",ButtonField.CONSUME_CLICK);
		bt1.setChangeListener(this);
		lb1 = new LabelField("");
		 add(idModA);
		 add(nombreMA);
		 add(DesHrs);
		 add(bt1);
		 add(lb1);
	}
	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		boolean b;
		if (field.equals(bt1)) {
			Modalidad_ActAcad al = new Modalidad_ActAcad();
			if(idModA.getText()=="" || nombreMA.getText()=="" || DesHrs.getText()==""){
				lb1.setText("Todos Los campos son obligatorios");	
			}
			else
			{
				al.setIdModalActAcad(idModA.getText());
				al.setNombreModalAA(nombreMA.getText());
				al.setDesHrsMAA(DesHrs.getText());
				bdh.Abrir();
				b = bdh.Insertar(al);
				bdh.Cerrar();
	
				if (b) {
					lb1.setText("Insercion realizada con exito.");
					idModA.setText("");
					nombreMA.setText("");	
					DesHrs.setText("");
					idModA.setFocus();
				}
	
				else
					lb1.setText("No se pudo realizar la insercion.");				
			}			
		}
	}

}
