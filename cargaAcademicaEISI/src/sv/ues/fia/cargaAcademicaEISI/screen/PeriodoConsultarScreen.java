package sv.ues.fia.cargaAcademicaEISI.screen;

import sv.ues.fia.cargaAcademicaEISI.ControlBD;
import sv.ues.fia.cargaAcademicaEISI.Periodo;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;

public class PeriodoConsultarScreen extends MainScreen implements FieldChangeListener {

	private EditField idperiodo;
	private EditField fecha_ini;
	private EditField fecha_fin;
	private ButtonField bt1;
	public ControlBD bdh;
	private LabelField lb1;
	 
	public PeriodoConsultarScreen() {
		setTitle("Consultar Periodo");
		bdh = new ControlBD();
		idperiodo = new EditField("IdPeriodo:","",5,EditField.FILTER_DEFAULT);
		fecha_ini = new EditField("Fecha Inicio:","",20,EditField.FILTER_DEFAULT);
		fecha_fin = new EditField("Fecha Fin:","",20,EditField.FILTER_DEFAULT);
		bt1 = new ButtonField("Consultar",ButtonField.CONSUME_CLICK);
		bt1.setChangeListener(this);
		lb1 = new LabelField("");
		fecha_ini.setEditable(false);
		fecha_fin.setEditable(false);
		add(idperiodo);
		add(bt1);
		add(fecha_ini);
		add(fecha_fin);
		add(lb1);
		}
		public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		if(field.equals(bt1))
		{
		Periodo p = new Periodo();
		bdh.Abrir();
		p = bdh.ConsultarPeriodo(idperiodo.getText());
		bdh.Cerrar();
		if(p!=null)
		{
		fecha_ini.setText(p.getFechaIni());
		fecha_fin.setText(p.getFechaFin());
		lb1.setText("");
		}
		else
		{
		lb1.setText("No se encuentra el cargo.");
		}
		}
	}

}
