package ido.tomsk.ru.asutp;

import java.awt.Color;
import java.awt.Graphics;

public class BasicRender implements IObservable {
	
	private Color _currentColor;
	private int _currentValue;
	private int _x;
	private int _y;
	private int _width;
	private int _height;	
	public BasicRender() {
		this._currentColor = Color.GREEN;
		this._currentValue = 0;
	}	
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
	}
	@Override
	public void handleEvent(IObserver o) {		
		if (o instanceof Alarm) {
			Alarm a = (Alarm) o;
			if (a.isActive()) {
				switch (a.getStatus()) {
				case 1:
					this._currentColor = Color.RED;
					break;
				case 2:
					this._currentColor = Color.YELLOW;
					break;
				case 3:
					this._currentColor = Color.GREEN;
					break;
				default:
					this._currentColor = Color.GREEN;
					break;
				}
			}
		}
		if (o instanceof Sensor) {
			Sensor s = (Sensor) o;
			this._currentValue = s.getValue();
		}
	}	
	public void setX(int x) {
		this._x = x;
	}
	public int getX() {
		return this._x;
	}
	public void setY(int y) {
		this._y = y;
	}
	public int getY() {
		return this._y;
	}
	public void setWidth(int width) {
		this._width = width;
	}
	public int getWidth() {
		return this._width;
	}
	public void setHeight(int height) {
		this._height = height;
	}
	public int getHeight() {
		return this._height;
	}
	public Color getCurrentColor() {
		return this._currentColor;
	}
	public int getCurrentValue() {
		return this._currentValue;
	}
}
