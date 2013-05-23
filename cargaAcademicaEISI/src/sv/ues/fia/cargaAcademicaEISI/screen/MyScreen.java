package sv.ues.fia.cargaAcademicaEISI.screen;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.GridFieldManager;
import net.rim.device.api.ui.container.MainScreen;

/**
 * CLASE PRINCIPAL DONDE APARECEN LAS 5 CATEGORIAS
 */
public final class MyScreen extends MainScreen implements FieldChangeListener {
	private BitmapButtonField btnfield1;
	private BitmapButtonField btnfield2;
	private BitmapButtonField btnfield3;
	private BitmapButtonField btnfield4;
	private BitmapButtonField btnfield5;

	private Bitmap bmpCatalogos;
	private Bitmap bmpDocentes;
	private Bitmap bmpMaterias;
	private Bitmap bmpActividadesAcademicas;
	private Bitmap bmpCragaAcademica;
	// DECLARACION DE LABEL
	private LabelField lb1;
	private LabelField lb2;
	private LabelField lb3;
	private LabelField lb4;
	private LabelField lb5;

	private Bitmap bmp0;

	public MyScreen() {
		// Set the displayed title of the screen
		setTitle("Menu principal Carga Academica EISI");
		bmpCatalogos = Bitmap.getBitmapResource("admin1_catalogos.png");
		bmpDocentes = Bitmap.getBitmapResource("admin2_docentes.png");
		bmpMaterias = Bitmap.getBitmapResource("admin3_materias.png");
		bmpActividadesAcademicas = Bitmap
				.getBitmapResource("admin4_actividades_acad.png");
		bmpCragaAcademica = Bitmap.getBitmapResource("admin5_cargaacad.png");

		bmp0 = Bitmap.getBitmapResource("buttonback.png");

		// INSTANCIANDO LABEL
		lb1 = new LabelField("Admin. de Catalogos");
		lb2 = new LabelField("Admin. de docentes");
		lb3 = new LabelField("Admin. de Materias");
		lb4 = new LabelField("Admin. Actividades Academicas");
		lb5 = new LabelField("Gestion Carga Academica");

		GridFieldManager grid = new GridFieldManager(2, 2,
				GridFieldManager.USE_ALL_HEIGHT
						| GridFieldManager.USE_ALL_HEIGHT
						| GridFieldManager.FIXED_SIZE);
		GridFieldManager grid2 = new GridFieldManager(2, 2,
				GridFieldManager.USE_ALL_HEIGHT
						| GridFieldManager.USE_ALL_HEIGHT
						| GridFieldManager.FIXED_SIZE);
		GridFieldManager grid3 = new GridFieldManager(2, 2,
				GridFieldManager.USE_ALL_HEIGHT
						| GridFieldManager.USE_ALL_HEIGHT
						| GridFieldManager.FIXED_SIZE);

		btnfield1 = new BitmapButtonField(bmpCatalogos, bmp0);
		btnfield1.setChangeListener(this);

		btnfield2 = new BitmapButtonField(bmpDocentes, bmp0);
		btnfield2.setChangeListener(this);

		btnfield3 = new BitmapButtonField(bmpMaterias, bmp0);
		btnfield3.setChangeListener(this);

		btnfield4 = new BitmapButtonField(bmpActividadesAcademicas, bmp0);
		btnfield4.setChangeListener(this);

		btnfield5 = new BitmapButtonField(bmpCragaAcademica, bmp0);
		btnfield5.setChangeListener(this);

		grid.insert(btnfield1, 0, 0);
		grid.insert(lb1, 0, 1);
		grid.insert(btnfield2, 1, 0);
		grid.insert(lb2, 1, 1);
		grid2.insert(btnfield3, 0, 0);
		grid2.insert(lb3, 0, 1);
		grid2.insert(btnfield4, 1, 0);
		grid2.insert(lb4, 1, 1);
		grid3.insert(btnfield5, 0, 0);
		grid3.insert(lb5, 0, 1);
		add(grid);
		add(grid2);
		add(grid3);
	}

	public void fieldChanged(Field field, int context) {
		// COMENTARIOS: en ves de MENUGESTION deben ponerle el nombre de el
		// sreen
		// que crearon para que les muestre el menu de tablas
		// pueden tomar como ejemplo el mio, " btnfield5 "

		if (field == btnfield1) {

			UiApplication.getUiApplication().pushScreen(
					new GestionCatalogosMenu("Admin. de Catalogos"));
		}
		/*
		 * if (field == btnfield2) {
		 * 
		 * UiApplication.getUiApplication().pushScreen( new
		 * MenuGestion("Admin. de docentes")); } if (field == btnfield3) {
		 * 
		 * UiApplication.getUiApplication().pushScreen( new
		 * MenuGestion("Admin. de Materias"));
		 * 
		 * } if (field == btnfield4) {
		 * 
		 * UiApplication.getUiApplication().pushScreen( new
		 * MenuGestion("Admin. Actividades Academicas"));
		 * 
		 * }
		 */
		if (field == btnfield5) {

			UiApplication.getUiApplication().pushScreen(
					new GestionCargaAcademicaMenu("Gestion Carga Academica"));

		}
	}

} // fin clase principal
