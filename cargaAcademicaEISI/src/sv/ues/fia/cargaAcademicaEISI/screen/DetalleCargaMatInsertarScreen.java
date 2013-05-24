package sv.ues.fia.cargaAcademicaEISI.screen;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;
import sv.ues.fia.cargaAcademicaEISI.ControlBD;
import sv.ues.fia.cargaAcademicaEISI.DetalleCargaMat;

public class DetalleCargaMatInsertarScreen extends MainScreen implements FieldChangeListener  {
	private EditField anio;
	private EditField numero;
	private EditField iddocente;
	private EditField iddetallecurso;
	private ButtonField bt1;
	private LabelField lb1;
	public ControlBD bdh;

	public  DetalleCargaMatInsertarScreen(){
	 setTitle("Insertar Detalle Curso"); 
	 bdh = new ControlBD();
	 iddocente = new EditField("ID de Docente:  ","",8,EditField.FILTER_DEFAULT);
	 anio = new EditField("A�o del Ciclo:  ","",4,EditField.FILTER_NUMERIC);
	 numero = new EditField("Numero de Ciclo:  ","",1,EditField.FILTER_NUMERIC);
	 iddetallecurso = new EditField("ID del Curso:  ","",6,EditField.FILTER_NUMERIC);
	 bt1 = new ButtonField("Insertar Registro",ButtonField.CONSUME_CLICK);
	 bt1.setChangeListener(this);
	 lb1 = new LabelField("");
	 add(iddocente);
	 add(anio);
	 add(numero);
	 add(iddetallecurso);
	 add(bt1);
	 add(lb1);
	}
	 public void fieldChanged(Field field, int context) {
			// TODO Auto-generated method stub
			boolean a;
			if (field.equals(bt1)) {
				DetalleCargaMat nt = new DetalleCargaMat();
				nt.setIddocente(iddocente.getText());
				nt.setAnio(anio.getText());
				nt.setNumero(numero.getText());
				nt.setIddetallecurso(iddetallecurso.getText());

				bdh.Abrir();
				a = bdh.Insertar(nt);
				bdh.Cerrar();
				if (a) {
					lb1.setText("Insercion de Registro realizada con exito.");
					anio.setText("");
					numero.setText("");
					iddocente.setText("");
					iddocente.setFocus();
				} else
					lb1.setText("No se pudo realizar la insercion.");
			

			}
		}

}