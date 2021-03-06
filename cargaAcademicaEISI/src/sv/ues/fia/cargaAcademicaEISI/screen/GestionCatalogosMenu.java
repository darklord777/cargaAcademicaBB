package sv.ues.fia.cargaAcademicaEISI.screen;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.GridFieldManager;
import net.rim.device.api.ui.container.MainScreen;

public class GestionCatalogosMenu extends MainScreen implements
		FieldChangeListener {
	private BitmapButtonField gstDeptoMenu;
	private BitmapButtonField gstLocalesMenu;
	private BitmapButtonField gstModalidadCursoMenu;
	private Bitmap bmptabla1;
	private Bitmap bmptabla2;
	private Bitmap bmptabla3;
	private String nombre;
	private Bitmap bmp0;  
	private LabelField lb1;
	private LabelField lb2;
	private LabelField lb3;
	public GestionCatalogosMenu(String opcion) {
		setTitle(opcion);
		bmptabla1 = Bitmap.getBitmapResource("tabla1.png");
		bmptabla2 = Bitmap.getBitmapResource("tabla2.png");
		bmptabla3 = Bitmap.getBitmapResource("tabla3.png");
		lb1 = new LabelField("Tabla Departamento");
		lb2 = new LabelField("Tabla Locales");
		lb3 = new LabelField("Tabla Modalidad Curso");

		GridFieldManager grid = new GridFieldManager(2, 5,
				GridFieldManager.USE_ALL_HEIGHT
						| GridFieldManager.USE_ALL_HEIGHT
						| GridFieldManager.FIXED_SIZE);
		

		gstDeptoMenu = new BitmapButtonField(bmptabla1, bmp0);
		gstDeptoMenu.setChangeListener(this);
		gstLocalesMenu = new BitmapButtonField(bmptabla2, bmp0);
		gstLocalesMenu.setChangeListener(this);
		gstModalidadCursoMenu = new BitmapButtonField(bmptabla3, bmp0);
		gstModalidadCursoMenu.setChangeListener(this);

		grid.insert(gstDeptoMenu, 0, 0);
		grid.insert(lb1, 0, 1);
		grid.insert(gstLocalesMenu, 1, 0);
		grid.insert(lb2, 1, 1);
		grid.insert(gstModalidadCursoMenu,2,0);
		grid.insert(lb3, 2, 1);

		add(grid);
	}

	public void fieldChanged(Field field, int context) {
		if (field == gstDeptoMenu) {
			if (nombre == "Admin. de Catalogos")
				UiApplication.getUiApplication().pushScreen(
						new MenuGestion("Gestion tabla Departamento"));
		}
		if (field == gstLocalesMenu) {
				if (nombre == "Admin. de Catalogos")
					UiApplication.getUiApplication().pushScreen(
							new MenuGestion("Gestion tabla Locales"));
		}
		if (field == gstModalidadCursoMenu) {
				if (nombre == "Admin. de Catalogos")
					UiApplication.getUiApplication().pushScreen(
							new MenuGestion("Gestion tabla ModalidadCurso"));
		}
	
	}
}
