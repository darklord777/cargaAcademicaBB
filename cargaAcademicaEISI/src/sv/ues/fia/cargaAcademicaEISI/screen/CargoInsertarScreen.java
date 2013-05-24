package sv.ues.fia.cargaAcademicaEISI.screen;

import sv.ues.fia.cargaAcademicaEISI.Cargo;
import sv.ues.fia.cargaAcademicaEISI.ControlBD;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;

public class CargoInsertarScreen extends MainScreen implements FieldChangeListener {

	private EditField idcargo;
	private EditField nom_cargo;
	private ButtonField bt1;
	private LabelField lb1;
	public ControlBD bdh; 
	
	public CargoInsertarScreen() {
		setTitle("Insertar Cargo");
		bdh = new ControlBD();
		idcargo = new EditField("IdCargo:","",5,EditField.EDITABLE);
		nom_cargo = new EditField("Nombre Cargo:","",20,EditField.EDITABLE);
		bt1 = new ButtonField("Insertar",ButtonField.CONSUME_CLICK);
		bt1.setChangeListener(this);
		lb1 = new LabelField("");
		add(idcargo);
		add(nom_cargo);
		add(bt1);
		add(lb1);
		}
		public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		boolean a;
		if(field.equals(bt1))
		{
		Cargo c = new Cargo();
		if (idcargo.getText().toString().trim().equals("")|| nom_cargo.getText().toString().trim().equals("")) {
			lb1.setText("Todos Los campos son obligatorios");
		} else {
		c.setIdCargo(idcargo.getText());
		c.setNombreCargo(nom_cargo.getText());
		
		bdh.Abrir();
		a=bdh.Insertar(c);
		bdh.Cerrar();
		
		if(a)
		{
		lb1.setText("Insercion realizada con exito.");
		idcargo.setText("");
		nom_cargo.setText("");
		idcargo.setFocus();
		}
		else
		lb1.setText("No se pudo realizar la insercion.");
		}
		}
		}
}
		
	


