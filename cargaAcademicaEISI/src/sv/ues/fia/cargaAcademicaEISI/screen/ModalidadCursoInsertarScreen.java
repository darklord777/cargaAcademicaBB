package sv.ues.fia.cargaAcademicaEISI.screen;

import sv.ues.fia.cargaAcademicaEISI.ControlBD;
import sv.ues.fia.cargaAcademicaEISI.Modalidad_Curso;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;

public class ModalidadCursoInsertarScreen extends MainScreen implements FieldChangeListener{

	private EditField idModC;
	private EditField nombreMC;
	private EditField DesHrs;
	private ButtonField bt1;
	private LabelField lb1;
	public ControlBD bdh;
	
	/**
	 * 
	 */
	public ModalidadCursoInsertarScreen() {
		super(MainScreen.VERTICAL_SCROLL | MainScreen.VERTICAL_SCROLLBAR);
		// TODO Auto-generated constructor stub
		setTitle("Insertar Modalidad Curso"); 
		bdh = new ControlBD();
		idModC = new EditField("Codigo del Local :","",6,EditField.FILTER_DEFAULT);
		nombreMC = new EditField("Nombre de modalidad :","",20,EditField.FILTER_DEFAULT);
		DesHrs = new EditField("Descuento Horas :","",5,EditField.FILTER_DEFAULT);
		bt1 = new ButtonField("Insertar Local",ButtonField.CONSUME_CLICK);
		bt1.setChangeListener(this);
		lb1 = new LabelField("");
		 add(idModC);
		 add(nombreMC);
		 add(DesHrs);
		 add(bt1);
		 add(lb1);
	}

	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		boolean b;
		if (field.equals(bt1)) {
			Modalidad_Curso al = new Modalidad_Curso();
			if(idModC.getText()=="" || nombreMC.getText()=="" || DesHrs.getText()==""){
				lb1.setText("Todos Los campos son obligatorios");	
			}
			else
			{
				al.setIdModalCurso(idModC.getText());
				al.setNombreModal(nombreMC.getText());
				al.setDescHoras(DesHrs.getText());
				bdh.Abrir();
				b = bdh.Insertar(al);
				bdh.Cerrar();
	
				if (b) {
					lb1.setText("Insercion realizada con exito.");
					idModC.setText("");
					nombreMC.setText("");	
					DesHrs.setText("");
					idModC.setFocus();
				}
	
				else
					lb1.setText("No se pudo realizar la insercion.");				
			}			
		}
		
	}

}
