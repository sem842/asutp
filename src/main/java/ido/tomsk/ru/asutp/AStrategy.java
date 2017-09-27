package ido.tomsk.ru.asutp;

public class AStrategy implements IEmulationStrategy {
	private int _ticks;
	private int _interval;
	private int _direction;
	
	AStrategy(int interval) {
		this._ticks = 0;
		this._interval = interval;
		this._direction = 1;
	}
	
	public void doEmulate(Sensor s) {		
		this._ticks ++;
		if (this._ticks == this._interval) {
			s.setValue(s.getValue() + this.calcDirection(s));
			this._ticks = 0;
		}
	}
	
	private int calcDirection(Sensor s) {
		if (this._direction == 1) {
			if (s.getValue() >= s.getMaxValue()) {
				this._direction = -1;
			}
		} else {
			if (s.getValue() <= s.getMinValue()) {
				this._direction = 1;
			}
		}
		return this._direction;
	}
	
}
