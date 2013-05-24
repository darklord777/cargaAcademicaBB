package sv.ues.fia.cargaAcademicaEISI.screen;

import sv.ues.fia.cargaAcademicaEISI.ControlBD;
import sv.ues.fia.cargaAcademicaEISI.Modalidad_ActAcad;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;

public class ModalidadActAcadConsultarScreen extends MainScreen implements FieldChangeListener {

	private EditField idModAA;
	private EditField nombreMAA;
	private EditField DescH;
	private ButtonField bt1;
	public ControlBD bdh;
	private LabelField lb1;

	/**
	 * 
	 */
	public ModalidadActAcadConsultarScreen() {
		super(MainScreen.VERTICAL_SCROLL | MainScreen.VERTICAL_SCROLLBAR);
		// TODO Auto-generated constructor stub
		setTitle("Consultar Modalidad Actividad Academica");
		bdh = new ControlBD();
		idModAA = new EditField("Codigo Modalidad:","",6,EditField.FILTER_DEFAULT);
		nombreMAA = new EditField("Nombre:","",20,EditField.FILTER_DEFAULT);
		DescH = new EditField("Descuento Horas:","",5,EditField.FILTER_DEFAULT);
		
		bt1 = new ButtonField("Consultar Modalidad Act Acad",ButtonField.CONSUME_CLICK);
		bt1.setChangeListener(this);
		lb1 = new LabelField("");
		nombreMAA.setEditable(false);
		DescH.setEditable(false);
		add(idModAA);
		add(bt1);
		add(nombreMAA);
		add(DescH);
		add(lb1);
	}

	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		if(field.equals(bt1))
		{
		Modalidad_ActAcad al = new Modalidad_ActAcad();
		bdh.Abrir();
		al = bdh.ConsultarModActA(idModAA.getText());
		bdh.Cerrar();
		if(al!=null)
		{
		nombreMAA.setText(al.getNombreModalAA());
		DescH.setText(al.getDesHrsMAA());
		lb1.setText("");
		}
		else
		{
		lb1.setText("No se encuentra la modalidad.");
		}
		}
	}

}
