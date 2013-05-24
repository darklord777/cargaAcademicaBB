package sv.ues.fia.cargaAcademicaEISI.screen;

import sv.ues.fia.cargaAcademicaEISI.ControlBD;
import sv.ues.fia.cargaAcademicaEISI.Modalidad_Curso;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;

public class ModalidadCursoConsultarScreen extends MainScreen implements FieldChangeListener {

	private EditField idModC;
	private EditField nombreMC;
	private EditField DescH;
	private ButtonField bt1;
	public ControlBD bdh;
	private LabelField lb1;
	
	/**
	 * 
	 */
	public ModalidadCursoConsultarScreen() {
		super(MainScreen.VERTICAL_SCROLL | MainScreen.VERTICAL_SCROLLBAR);
		// TODO Auto-generated constructor stub
		setTitle("Consultar Modalidad Curso");
		bdh = new ControlBD();
		idModC = new EditField("Codigo Modalidad:","",6,EditField.FILTER_DEFAULT);
		nombreMC = new EditField("Nombre:","",20,EditField.FILTER_DEFAULT);
		DescH = new EditField("Descuento Horas:","",5,EditField.FILTER_DEFAULT);
		
		bt1 = new ButtonField("Consultar Modalidad",ButtonField.CONSUME_CLICK);
		bt1.setChangeListener(this);
		lb1 = new LabelField("");
		nombreMC.setEditable(false);
		DescH.setEditable(false);
		add(idModC);
		add(bt1);
		add(nombreMC);
		add(DescH);
		add(lb1);
	}

	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		if(field.equals(bt1))
		{
		Modalidad_Curso al = new Modalidad_Curso();
		bdh.Abrir();
		al = bdh.ConsultarModCurso(idModC.getText());
		bdh.Cerrar();
		if(al!=null)
		{
		nombreMC.setText(al.getNombreModal());
		DescH.setText(al.getDescHoras());
		lb1.setText("");
		}
		else
		{
		lb1.setText("No se encuentra la modalidad.");
		}
		}
	}

}
