package sv.ues.fia.cargaAcademicaEISI.screen;

import sv.ues.fia.cargaAcademicaEISI.Cargo;
import sv.ues.fia.cargaAcademicaEISI.ControlBD;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;

public class CargoConsultarScreen extends MainScreen implements FieldChangeListener {

	private EditField idcargo;
	private EditField nom_cargo;
	private ButtonField bt1;
	public ControlBD bdh;
	private LabelField lb1;
	 
	public CargoConsultarScreen() {
		setTitle("Consultar Cargo");
		bdh = new ControlBD();
		idcargo = new EditField("IdCargo:","",5,EditField.FILTER_DEFAULT);
		nom_cargo = new EditField("Nombre Cargo:","",20,EditField.FILTER_DEFAULT);
		bt1 = new ButtonField("Consultar",ButtonField.CONSUME_CLICK);
		bt1.setChangeListener(this);
		lb1 = new LabelField("");
		nom_cargo.setEditable(false);
		add(idcargo);
		add(bt1);
		add(nom_cargo);
		add(lb1);
		}
		public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		if(field.equals(bt1))
		{
		Cargo c = new Cargo();
		bdh.Abrir();
		c = bdh.ConsultarCargo(idcargo.getText());
		bdh.Cerrar();
		if(c!=null)
		{
		nom_cargo.setText(c.getNombreCargo());
		lb1.setText("");
		}
		else
		{
		lb1.setText("No se encuentra el cargo.");
		}
		}
	}

}
