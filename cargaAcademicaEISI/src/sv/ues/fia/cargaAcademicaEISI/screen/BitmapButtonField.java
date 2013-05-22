package sv.ues.fia.cargaAcademicaEISI.screen;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Graphics;
import net.rim.device.api.ui.component.ButtonField;

public class BitmapButtonField extends ButtonField {
	// Customizacion de un Button con un Bitmap

	private Bitmap bitmap;
	private Bitmap bitmapHighlight;
	private boolean highlighted = false;

	public BitmapButtonField(Bitmap bitmap, Bitmap bitmapHighlight) {
		this(bitmap, bitmapHighlight, ButtonField.CONSUME_CLICK
				| ButtonField.FIELD_HCENTER | ButtonField.FIELD_VCENTER);
	}

	public BitmapButtonField(Bitmap bitmap, Bitmap bitmapHighlight, long style) {
		super(style);
		this.bitmap = bitmap;
		this.bitmapHighlight = bitmapHighlight;
	}

	protected void layout(int width, int height) {
		setExtent(getPreferredWidth(), getPreferredHeight());
	}

	public int getPreferredWidth() {
		return bitmap.getWidth();
	}

	public int getPreferredHeight() {
		return bitmap.getHeight();
	}

	protected void paint(Graphics graphics) {
		super.paint(graphics);
		int width = bitmap.getWidth();
		int height = bitmap.getHeight();
		Bitmap b = bitmap;
		if (highlighted)
			b = bitmapHighlight;

		graphics.drawBitmap(0, 0, width, height, b, 0, 0);
	}

}
