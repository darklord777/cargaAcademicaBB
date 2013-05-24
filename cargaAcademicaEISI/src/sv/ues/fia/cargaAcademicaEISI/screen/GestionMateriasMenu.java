package sv.ues.fia.cargaAcademicaEISI.screen;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.GridFieldManager;
import net.rim.device.api.ui.container.MainScreen;

public class GestionMateriasMenu extends MainScreen implements
		FieldChangeListener {
	private BitmapButtonField gstMateria;
	private Bitmap bmptabla1;
	private BitmapButtonField gstAreaMateria;
	private Bitmap bmptabla2;
	private BitmapButtonField gstDetGpoAsig;
	private Bitmap bmptabla3;
	private String nombre;
	private Bitmap bmp0;
	private LabelField lb1;
	private LabelField lb2;
	private LabelField lb3;

	public GestionMateriasMenu(String opcion) {
		setTitle(opcion);
		nombre = opcion;
		bmptabla1 = Bitmap.getBitmapResource("tabla1.png");
		bmptabla2 = Bitmap.getBitmapResource("tabla2.png");
		bmptabla3 = Bitmap.getBitmapResource("tabla3.png");
		bmp0 = Bitmap.getBitmapResource("buttonback.png");

		lb1 = new LabelField("Tabla Materia");
		lb1 = new LabelField("Tabla Area de Materia");
		lb1 = new LabelField("Tabla Detalle grupo asignado");

		GridFieldManager grid = new GridFieldManager(2, 3,
				GridFieldManager.USE_ALL_HEIGHT
						| GridFieldManager.USE_ALL_HEIGHT
						| GridFieldManager.FIXED_SIZE);

		gstMateria = new BitmapButtonField(bmptabla1, bmp0);
		gstMateria.setChangeListener(this);

		gstAreaMateria = new BitmapButtonField(bmptabla2, bmp0);
		gstAreaMateria.setChangeListener(this);

		gstDetGpoAsig = new BitmapButtonField(bmptabla3, bmp0);
		gstDetGpoAsig.setChangeListener(this);

		grid.insert(gstMateria, 0, 0);
		grid.insert(lb1, 0, 1);

		grid.insert(gstAreaMateria, 1, 0);
		grid.insert(lb2, 1, 1);

		grid.insert(gstDetGpoAsig, 2, 0);
		grid.insert(lb2, 2, 1);

		add(grid);
	}

	public void fieldChanged(Field field, int context) {
		if (field == gstMateria) {
			if (nombre == "Admin. de Materias")
				UiApplication.getUiApplication().pushScreen(
						new MenuGestion("Gestion tabla Materia"));
		}
		if (field == gstMateria) {
			if (nombre == "Admin. de Materias")
				UiApplication.getUiApplication().pushScreen(
						new MenuGestion("Gestion tabla Area de Materia"));
		}
		if (field == gstDetGpoAsig) {
			if (nombre == "Admin. de Materias")
				UiApplication.getUiApplication().pushScreen(
						new MenuGestion("Gestion tabla Detalle Gpo Asignado"));
		}
	}

}
