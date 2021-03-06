package sv.ues.fia.cargaAcademicaEISI.screen;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.container.GridFieldManager;
import net.rim.device.api.ui.container.MainScreen;

public class MenuGestion extends MainScreen implements FieldChangeListener {
	private BitmapButtonField btnfield1;
	private BitmapButtonField btnfield2;
	private BitmapButtonField btnfield3;
	private BitmapButtonField btnfield4;

	private Bitmap bmpagregar;
	private Bitmap bmpmodificar;
	private Bitmap bmpconsultar;
	private Bitmap bmpeliminar;
	private Bitmap bmp0;
	private String nombre;  

	public MenuGestion(String opcion) {
		setTitle(opcion);
		nombre = opcion;
		bmpagregar = Bitmap.getBitmapResource("btnagregar.jpg");
		bmpmodificar = Bitmap.getBitmapResource("btnmodificar.jpg");
		bmpconsultar = Bitmap.getBitmapResource("btnconsultar.jpg");
		bmpeliminar = Bitmap.getBitmapResource("btneliminar.jpg");
		bmp0 = Bitmap.getBitmapResource("buttonback.png");

		GridFieldManager grid = new GridFieldManager(2, 2,
				GridFieldManager.USE_ALL_HEIGHT
						| GridFieldManager.USE_ALL_HEIGHT
						| GridFieldManager.FIXED_SIZE);
		btnfield1 = new BitmapButtonField(bmpagregar, bmp0);
		btnfield1.setChangeListener(this);
		btnfield2 = new BitmapButtonField(bmpmodificar, bmp0);
		btnfield2.setChangeListener(this);
		btnfield3 = new BitmapButtonField(bmpconsultar, bmp0);
		btnfield3.setChangeListener(this);
		btnfield4 = new BitmapButtonField(bmpeliminar, bmp0);
		btnfield4.setChangeListener(this);

		grid.insert(btnfield1, 0, 0);
		if (nombre != "Gestion tabla Carga Academica" && nombre != "Gestion tabla Detalle Materias"  && nombre != "Carga Actividades Academicas")
			grid.insert(btnfield2, 0, 1);
		
		
		grid.insert(btnfield3, 1, 0);
		grid.insert(btnfield4, 1, 1);

		add(grid);
	}

	public void fieldChanged(Field field, int context) {
		if (field == btnfield1) {
			if (nombre == "Gestion tabla Ciclo")
				UiApplication.getUiApplication().pushScreen(
						new CicloInsertarScreen());
			if (nombre == "Gestion tabla Carga Academica")
				UiApplication.getUiApplication().pushScreen(
						new CargaAcademicaInsertarScreen());
			if (nombre == "Gestion tabla Detalle Materias")
				UiApplication.getUiApplication().pushScreen(
						new DetalleCargaMatInsertarScreen());
			if (nombre == "Carga Actividades Academicas")
				UiApplication.getUiApplication().pushScreen(
						new DetalleCargaActAcadInsertarScreen());
			/* Mario */
			if (nombre == "Gestion tabla Departamento")
				UiApplication.getUiApplication().pushScreen(
						new DepartamentoInsertarScreen());
			if (nombre == "Gestion tabla Materia")
				UiApplication.getUiApplication().pushScreen(
						new MateriaInsertarScreen());
			if (nombre == "Gestion tabla Area de Materia")
				UiApplication.getUiApplication().pushScreen(
						new AreaMateriaInsertarScreen());
			if (nombre == "Gestion tabla Detalle Gpo Asignado")
				UiApplication.getUiApplication().pushScreen(
						new DetGpoAsignadoInsertarScreen());
			/* Miguel */
			if (nombre == "Gestion tabla Locales")
				UiApplication.getUiApplication().pushScreen(
						new LocalesInsertarScreen());
			if (nombre == "Gestion tabla ModalidadCurso")
				UiApplication.getUiApplication().pushScreen(
						new ModalidadCursoInsertarScreen());
			
			/* Sergio*/
			if(nombre=="Cargos")
				UiApplication.getUiApplication().pushScreen(new CargoInsertarScreen());
				if(nombre=="Docente_Cargos")
				UiApplication.getUiApplication().pushScreen(new Docente_CargoInsertarScreen());
				if(nombre=="Periodo")
				UiApplication.getUiApplication().pushScreen(new PeriodoInsertarScreen());

		}

		if (field == btnfield2) {
			if (nombre == "Gestion tabla Ciclo")
				UiApplication.getUiApplication().pushScreen(
						new CicloActualizarScreen());
			if(nombre=="Cargos")
				UiApplication.getUiApplication().pushScreen(new CargoActualizarScreen());
				if(nombre=="Periodos")
				UiApplication.getUiApplication().pushScreen(new PeriodoActualizarScreen());

		}

		if (field == btnfield3) {
			if (nombre == "Gestion tabla Ciclo")
				UiApplication.getUiApplication().pushScreen(
						new CicloConsultarScreen());
			if (nombre == "Gestion tabla Carga Academica")
				UiApplication.getUiApplication().pushScreen(
						new CargaAcademicaConsultarScreen());
			if (nombre == "Gestion tabla Detalle Materias")
				UiApplication.getUiApplication().pushScreen(
						new DetalleCargaMatConsultarScreen());
			if (nombre == "Carga Actividades Academicas")
				UiApplication.getUiApplication().pushScreen(new DetalleCargaActAcadConsultarScreen());

			/* Mario */
			if (nombre == "Gestion tabla Departamento")
				UiApplication.getUiApplication().pushScreen(
						new DepartamentoConsultarScreen());
			if (nombre == "Gestion tabla Materia")
				UiApplication.getUiApplication().pushScreen(
						new MateriaConsultarScreen());
			if (nombre == "Gestion tabla Area de Materia")
				UiApplication.getUiApplication().pushScreen(
						new AreaMateriaConsultarScreen());
			if (nombre == "Gestion tabla Detalle Gpo Asignado")
				UiApplication.getUiApplication().pushScreen(
						new DetGpoAsignadoConsultarScreen());
			
			/* Miguel */
			if (nombre == "Gestion tabla Locales")
				UiApplication.getUiApplication().pushScreen(
						new LocalesConsultarScreen());
			if (nombre == "Gestion tabla ModalidadCurso")
				UiApplication.getUiApplication().pushScreen(
						new ModalidadCursoConsultarScreen());
			
			if(nombre=="Cargos")
				UiApplication.getUiApplication().pushScreen(new CargoConsultarScreen());
				if(nombre=="Docente_Cargos")
				UiApplication.getUiApplication().pushScreen(new Docente_CargoConsultarScreen());
				if(nombre=="Periodos")
				UiApplication.getUiApplication().pushScreen(new PeriodoConsultarScreen());

		}

		if (field == btnfield4) {
			if (nombre == "Gestion tabla Ciclo")
				UiApplication.getUiApplication().pushScreen(
						new CicloEliminarScreen());
			if (nombre == "Gestion tabla Carga Academica")
				UiApplication.getUiApplication().pushScreen(
						new CargaAcademicaEliminarScreen());
			if (nombre == "Gestion tabla Detalle Materias")
				UiApplication.getUiApplication().pushScreen(new DetalleCargaMatEliminarScreen());
			if (nombre == "Carga Actividades Academicas")
				UiApplication.getUiApplication().pushScreen(new DetalleCargaActAcadEliminarScreen());
			
			/* Miguel */
			if (nombre == "Gestion tabla Locales")
				UiApplication.getUiApplication().pushScreen(
						new LocalesEliminarScreen());
			if (nombre == "Gestion tabla ModalidadCurso")
				UiApplication.getUiApplication().pushScreen(
						new ModalidadCursoEliminarScreen());
			
			if(nombre=="Cargos")
				UiApplication.getUiApplication().pushScreen(new CargoEliminarScreen());
			if(nombre=="Docente_Cargos")
				UiApplication.getUiApplication().pushScreen(new Docente_CargoEliminarScreen());
			if(nombre=="Periodos")
				UiApplication.getUiApplication().pushScreen(new PeriodoEliminarScreen());

			

		}
	}

}