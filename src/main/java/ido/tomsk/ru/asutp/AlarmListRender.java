package ido.tomsk.ru.asutp;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class AlarmListRender extends DefaultListCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean _flag = false;
	@Override	
	public Component getListCellRendererComponent(JList list, 
			Object value, int index, boolean isSelected, boolean cellHasFocus) {
			 Alarm a = (Alarm) value;
			 Component cellRenderer = super.getListCellRendererComponent(list, a, index, isSelected, cellHasFocus);
			 Color alarmColor = this.calcColor(a);
			 alarmColor = this.calcBlink(a, alarmColor);
			 cellRenderer.setForeground(alarmColor);
			 cellRenderer.setBackground(Color.BLACK);
			 return cellRenderer;
	}
	
	public void toggleBlinkFlag() {
		this._flag = ! this._flag;
	}
	
	public Color calcColor(Alarm a) {
		Color _c = null;
		if (a.isActive()) {
			switch (a.getStatus()) {
			case 1:
				_c = Color.RED;
				break;
			case 2:
				_c = Color.YELLOW;
				break;
			case 3:
				_c = Color.GREEN;
				break;
			default:
				_c = Color.GREEN;
				break;
			}
		} else {
			switch (a.getStatus()) {
			case 1:
				_c = Color.decode("#330000");
				break;
			case 2:
				_c = Color.decode("#996633");
				break;
			case 3:
				_c = Color.decode("#003300");
				break;
			default:
				_c = Color.GREEN;
				break;
			}
		}
		return _c;
	}
	
	public Color calcBlink(Alarm a, Color alarmColor) {
		if (a.isActive() && this._flag) {
				return Color.BLACK;				 
		}
		return alarmColor;
	}
}