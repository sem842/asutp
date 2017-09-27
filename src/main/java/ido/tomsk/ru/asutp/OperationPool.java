package ido.tomsk.ru.asutp;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class OperationPool {
	private List<Alarm> _alarms;
	public OperationPool() {
		this._alarms = new CopyOnWriteArrayList<Alarm>();
	}
	public List<Alarm> alarms() {
		return this._alarms;
	}
	public void add(Alarm a) {
		this._alarms.add(a);
	}
	public void remove(Alarm a) {
		this._alarms.remove(a);
	}
	public void turnOff(int id) {
		for (Alarm a: this._alarms) {
			if (a.getId() == id) {
				a.turnOff();
				if (a.isCvited()) {
					this._alarms.remove(a);
				}
			}
		}
	}
	public void cvitByListIndex (int index) {
		Alarm a = this._alarms.get(index);
		a.setCvited();
		if (!a.isActive()) {
			this._alarms.remove(index);
		}
	}
	public boolean exist(int id, boolean isActive) {
		boolean res = false;
		for (Alarm a: this._alarms) {
			if (a.getId() == id && a.isActive() == isActive) {
				res = true;
				break;
			}
		}
		return res;
	}
}