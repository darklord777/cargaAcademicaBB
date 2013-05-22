package sv.ues.fia.cargaAcademicaEISI.screen;

import sv.ues.fia.cargaAcademicaEISI.Ciclo;
import sv.ues.fia.cargaAcademicaEISI.ControlBD;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;

public class CicloInsertarScreen extends MainScreen implements
		FieldChangeListener {

	private EditField anio;
	private EditField numero;
	private EditField fechaini;
	private EditField fechafin;
	private ButtonField bt1;
	private LabelField lb1;
	public ControlBD bdh;

	public CicloInsertarScreen (){
	 setTitle("Insertar Ciclo"); 
	 bdh = new ControlBD();
	 anio = new EditField("Año del Ciclo :","",4,EditField.FILTER_NUMERIC);
	 numero = new EditField("Numero de Ciclo :","",1,EditField.FILTER_NUMERIC);
	 fechaini = new EditField("Fecha inicio :","",10,EditField.FILTER_DEFAULT);
	 fechafin = new EditField("Fecha Fin :","",10,EditField.FILTER_DEFAULT);
	 bt1 = new ButtonField("Insertar Ciclo",ButtonField.CONSUME_CLICK);
	 bt1.setChangeListener(this);
	 lb1 = new LabelField("");
	 add(anio);
	 add(numero);
	 add(fechaini);
	 add(fechafin);
	 add(bt1);
	 add(lb1);
	}

	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		boolean a;
		if (field.equals(bt1)) {
			Ciclo al = new Ciclo();
			if(anio.getText()=="" || numero.getText()=="" || fechaini.getText()=="" || fechafin.getText()==""){
				lb1.setText("Todos Los campos son obligatorios");	
			}
			else
			{
				al.setAnio(anio.getText());
				al.setNumero(numero.getText());
				al.setFechaini(fechaini.getText());
				al.setFechafin(fechafin.getText());
				bdh.Abrir();
				a = bdh.Insertar(al);
				bdh.Cerrar();
	
				if (a) {
					lb1.setText("Insercion realizada con exito.");
					anio.setText("");
					numero.setText("");
					fechaini.setText("");
					fechafin.setText("");
					anio.setFocus();
				}
	
				else
					lb1.setText("No se pudo realizar la insercion.");
				
				
				
			}
			
			
			
		}
	}

}
