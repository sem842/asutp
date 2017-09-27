package ido.tomsk.ru.asutp;

public class DStrategy implements IEmulationStrategy{

	private int _ticks;
	private int _interval;
	DStrategy(int interval) {
		this._ticks = 0;
		this._interval = interval;
	}
	public void doEmulate(Sensor s) {
		this._ticks ++;
		if (this._ticks == this._interval) {
			this._ticks = 0;
			if (s.getValue() == 0) {
				s.setValue(1);
			} else {
				s.setValue(0);
			}
		}
	}

}
