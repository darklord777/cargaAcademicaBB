package sv.ues.fia.cargaAcademicaEISI.screen;


import sv.ues.fia.cargaAcademicaEISI.ControlBD;
import sv.ues.fia.cargaAcademicaEISI.Periodo;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;

public class PeriodoInsertarScreen extends MainScreen implements FieldChangeListener {

	private EditField idperiodo;
	private EditField fecha_ini;
	private EditField fecha_fin;
	private ButtonField bt1;
	private LabelField lb1;
	public ControlBD bdh;
	
	public PeriodoInsertarScreen() {
		setTitle("Insertar Periodo");
		bdh = new ControlBD();
		idperiodo = new EditField("IdPeriodo:","",6,EditField.FILTER_DEFAULT);
		fecha_ini = new EditField("Fecha Inicio:","",20,EditField.FILTER_DEFAULT);
		fecha_fin = new EditField("Fecha Fin:","",20,EditField.FILTER_DEFAULT);
		bt1 = new ButtonField("Insertar",ButtonField.CONSUME_CLICK);
		bt1.setChangeListener(this);
		lb1 = new LabelField("");
		add(idperiodo);
		add(fecha_ini);
		add(fecha_fin);
		add(bt1);
		add(lb1);
		}
		public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		boolean a;
		if(field.equals(bt1))
		{
		Periodo p = new Periodo();
		p.setIdPeriodo(idperiodo.getText());
		p.setFechaIni(fecha_ini.getText());
		p.setFechaFin(fecha_fin.getText());
		bdh.Abrir();
		a=bdh.Insertar(p);
		bdh.Cerrar();
		if(a)
		{
		lb1.setText("Insercion realizada con exito.");
		idperiodo.setText("");
		fecha_ini.setText("");
		fecha_fin.setText("");
		idperiodo.setFocus();
		}
		else
		lb1.setText("No se pudo realizar la insercion.");
		}
		}
		
	}


