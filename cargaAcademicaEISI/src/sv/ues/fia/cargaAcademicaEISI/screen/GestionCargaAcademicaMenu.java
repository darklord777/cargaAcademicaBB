package sv.ues.fia.cargaAcademicaEISI.screen;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.GridFieldManager;
import net.rim.device.api.ui.container.MainScreen;

public class GestionCargaAcademicaMenu extends MainScreen implements FieldChangeListener {
	private BitmapButtonField btnfield1;
	private BitmapButtonField btnfield2;
	private BitmapButtonField btnfield3;
	private BitmapButtonField btnfield4;
	private Bitmap bmptabla1;
	private Bitmap bmptabla2;
	private Bitmap bmptabla3;
	private Bitmap bmptabla4;
	private Bitmap bmp0;
	private String nombre;
	// DECLARACION DE LABEL
		private LabelField lb1;
		private LabelField lb2;
		private LabelField lb3;
		private LabelField lb4;

	public GestionCargaAcademicaMenu(String opcion) {
		setTitle(opcion);
		nombre = opcion;
		bmptabla1 = Bitmap.getBitmapResource("tabla1.png");
		bmptabla2 = Bitmap.getBitmapResource("tabla2.png");
		bmptabla3 = Bitmap.getBitmapResource("tabla3.png");
		bmptabla4 = Bitmap.getBitmapResource("tabla4.png");
		bmp0 = Bitmap.getBitmapResource("buttonback.png");

		lb1 = new LabelField("Tabla Ciclo");
		lb2 = new LabelField("Tabla Carga Academica");
		lb3 = new LabelField("Tabla Detalle Materias");
		lb4 = new LabelField("TAbla Actividades Academicas");

		GridFieldManager grid = new GridFieldManager(2, 2,GridFieldManager.USE_ALL_HEIGHT| GridFieldManager.USE_ALL_HEIGHT| GridFieldManager.FIXED_SIZE);
		GridFieldManager grid2 = new GridFieldManager(2, 2,GridFieldManager.USE_ALL_HEIGHT| GridFieldManager.USE_ALL_HEIGHT| GridFieldManager.FIXED_SIZE);
		btnfield1 = new BitmapButtonField(bmptabla1, bmp0);
		btnfield1.setChangeListener(this);
		btnfield2 = new BitmapButtonField(bmptabla2, bmp0);
		btnfield2.setChangeListener(this);
		btnfield3 = new BitmapButtonField(bmptabla3, bmp0);
		btnfield3.setChangeListener(this);
		btnfield4 = new BitmapButtonField(bmptabla4, bmp0);
		btnfield4.setChangeListener(this);
		
		
		grid.insert(btnfield1, 0, 0);
		grid.insert(lb1, 0, 1); //tabla ciclo
		grid.insert(btnfield2, 1, 0);
		grid.insert(lb2, 1, 1); //tabla carga academica
		grid2.insert(btnfield3, 0, 0);
		grid2.insert(lb3, 0, 1);//tabla carga materias
		grid2.insert(btnfield4, 1, 0);
		grid2.insert(lb4, 1, 1);//tabla Carga Act Academicas
		add(grid);
		add(grid2);
	}

	public void fieldChanged(Field field, int context) {
		if (field == btnfield1) {
			if (nombre == "Gestion Carga Academica")
				UiApplication.getUiApplication().pushScreen(new MenuGestion("Gestion tabla Ciclo"));
		}

		if (field == btnfield2) {
			if (nombre == "Gestion Carga Academica")
				UiApplication.getUiApplication().pushScreen(
						new MenuGestion("Gestion tabla Carga Academica"));
		}
		
		if (field == btnfield3) {
			if (nombre == "Gestion Carga Academica")
				UiApplication.getUiApplication().pushScreen(
						new MenuGestion("Gestion tabla Detalle Materias"));
		}
		
		if (field == btnfield4) {
			if (nombre == "Gestion Carga Academica")
				UiApplication.getUiApplication().pushScreen(
						new MenuGestion("Carga Actividades Academicas"));
		}
	}

}
