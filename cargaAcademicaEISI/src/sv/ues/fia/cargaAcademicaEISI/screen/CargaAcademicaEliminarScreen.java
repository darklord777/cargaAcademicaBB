package sv.ues.fia.cargaAcademicaEISI.screen;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;
import sv.ues.fia.cargaAcademicaEISI.ControlBD;

public class CargaAcademicaEliminarScreen extends MainScreen  implements FieldChangeListener {

	private EditField anio;
	private EditField numero;
	private EditField iddocente;
	 private ButtonField bt1;
	 public ControlBD bdh;
	 private LabelField lb1;
	 
	public CargaAcademicaEliminarScreen (){
	 setTitle("Eliminar Carga Academica");
	 bdh = new ControlBD();
	 iddocente = new EditField("ID de Docente:  ","",8,EditField.FILTER_DEFAULT);
	 anio = new EditField("Año del Ciclo:  ","",4,EditField.FILTER_NUMERIC);
	 numero = new EditField("Numero de Ciclo:  ","",1,EditField.FILTER_NUMERIC);
 	 bt1 = new ButtonField("Eliminar Registro",ButtonField.CONSUME_CLICK); 
	 bt1.setChangeListener(this);
	 lb1 = new LabelField("");
	 add(iddocente);
	 add(anio);
	 add(numero);
	 add(bt1);
	 add(lb1);

	}

	public void fieldChanged(Field field, int context)  {
	 // TODO Auto-generated method stub
	 boolean m;
	 boolean N;
	 if(field.equals(bt1))
	 {
		 	bdh.Abrir();
			  m=bdh.EliminarCargaAcademica(iddocente.getText(),anio.getText(),numero.getText());
			  bdh.Cerrar();
			  if(m)
				  lb1.setText("Se elimino la Carga Academica.");
			  else
				  lb1.setText("Error en eliminacion.");

	 }

  }


}
