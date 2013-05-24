package sv.ues.fia.cargaAcademicaEISI.screen;


import sv.ues.fia.cargaAcademicaEISI.ControlBD;
import sv.ues.fia.cargaAcademicaEISI.Periodo;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;

public class PeriodoActualizarScreen extends MainScreen implements FieldChangeListener{

	private EditField idperiodo;
	private EditField fecha_inicio;
	private EditField fecha_fin;
	private ButtonField bt1;
	public ControlBD bdh;
	private LabelField lb1; 
	
	public PeriodoActualizarScreen() {
		setTitle("Actualizar Periodo");
		bdh = new ControlBD();
		idperiodo = new EditField("IdPeriodo:","",6,EditField.FILTER_DEFAULT);
		fecha_inicio = new EditField("Fecha de Inicio:","",20,EditField.FILTER_DEFAULT);
		fecha_fin = new EditField("Fecha de Fin:","",20,EditField.FILTER_DEFAULT);
		bt1 = new ButtonField("Modificar",ButtonField.CONSUME_CLICK);
		bt1.setChangeListener(this);
		lb1 = new LabelField("");
		add(idperiodo);
		add(fecha_inicio);
		add(fecha_fin);
		add(bt1);
		add(lb1);
		}
		public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		boolean m;
		if(field.equals(bt1))
		{
		Periodo p = new Periodo();
		p.setIdPeriodo(idperiodo.getText());
		p.setFechaIni(fecha_inicio.getText());
		p.setFechaFin(fecha_fin.getText());
		bdh.Abrir();
		m=bdh.Actualizar(p);
		bdh.Cerrar();
		if(m)
		lb1.setText("Se realizo la modificacion");
		else
		lb1.setText("Error en modificacion");
		}
		}
		}