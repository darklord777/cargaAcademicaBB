package sv.ues.fia.cargaAcademicaEISI.screen;

import sv.ues.fia.cargaAcademicaEISI.ActividadAcademica;
import sv.ues.fia.cargaAcademicaEISI.ControlBD;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;

public class ActividadAcademicaConsultarScreen extends MainScreen implements FieldChangeListener {
 
	private EditField idActAcad;
	private EditField idModC;
	private EditField nombreAA;
	private EditField cargo;
	private ButtonField bt1;
	public ControlBD bdh;
	private LabelField lb1;
	/**
	 * 
	 */
	public ActividadAcademicaConsultarScreen() {
		super(MainScreen.VERTICAL_SCROLL | MainScreen.VERTICAL_SCROLLBAR);
		// TODO Auto-generated constructor stub
		setTitle("Consultar Actividad Academica");
		bdh = new ControlBD();
		idActAcad = new EditField("Codigo Modalidad:","",6,EditField.FILTER_DEFAULT);
		idModC = new EditField("Codigo Modalidad:","",6,EditField.FILTER_DEFAULT);
		nombreAA = new EditField("Nombre:","",20,EditField.FILTER_DEFAULT);
		cargo = new EditField("Descuento Horas:","",5,EditField.FILTER_DEFAULT);
		
		bt1 = new ButtonField("Consultar Modalidad",ButtonField.CONSUME_CLICK);
		bt1.setChangeListener(this);
		lb1 = new LabelField("");
		idModC.setEditable(false);
		nombreAA.setEditable(false);
		cargo.setEditable(false);
		add(idModC);
		add(bt1);
		add(idModC);
		add(nombreAA);
		add(cargo);
		add(lb1);
	}
	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		if(field.equals(bt1))
		{
		ActividadAcademica al = new ActividadAcademica();
		bdh.Abrir();
		al = bdh.ConsultarActA(idActAcad.getText());
		bdh.Cerrar();
		if(al!=null)
		{
		idModC.setText(al.getIdModalActAcad());
		nombreAA.setText(al.getNombreActAcademica());
		cargo.setText(al.getCargo());
		lb1.setText("");
		}
		else
		{
		lb1.setText("No se encuentra la Actividad.");
		}
		}
	}

}
