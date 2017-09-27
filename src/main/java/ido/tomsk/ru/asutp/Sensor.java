package ido.tomsk.ru.asutp;

import java.util.ArrayList;
import java.util.List;

public class Sensor 
	implements ISensorEmulator, IObserver {
	private List<IObservable> _observables;
	private IEmulationStrategy _strategy = null;
	private int _value;
	private int _minValue;
	private int _maxValue;
	private int _type;
	public Sensor() {
		this._observables = new ArrayList<IObservable>();
	}
	public Sensor(int value,
				  int minValue,
				  int maxValue,
				  int type) {
		this._value = value;
		this._minValue = minValue;
		this._maxValue = maxValue;
		this._type = type;
		this._observables = new ArrayList<IObservable>();
	}
	
	public int getValue() {
		return _value;
	}
	public void setValue(int _value) {
		this._value = _value;
		notifyObservables();
	}
	public int getMinValue() {
		return _minValue;
	}
	public void setMinValue(int _minValue) {
		this._minValue = _minValue;
	}
	public int getMaxValue() {
		return _maxValue;
	}
	public void setMaxValue(int _maxValue) {
		this._maxValue = _maxValue;
	}
	public int getType() {
		return _type;
	}
	public void setType(int _type) {
		this._type = _type;
	}
	public void emulate() {
		this._strategy.doEmulate(this);
	}
	public void setEmulationStrategy(IEmulationStrategy s) {
		this._strategy = s;
	}
	public IEmulationStrategy getEmulationStrategy() {		
		return this._strategy;
	}
	public void register(IObservable o) {
		this._observables.add(o);
	}
	public void unregister(IObservable o) {
		this._observables.remove(o);
	}
	public void notifyObservables() {
		for (IObservable ob: this._observables) {
			ob.handleEvent(this);
		}
	}
}
