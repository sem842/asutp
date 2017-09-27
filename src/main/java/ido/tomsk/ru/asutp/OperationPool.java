package ido.tomsk.ru.asutp;

import java.util.ArrayList;
import java.util.List;

public class OperationPool {
	private List<Alarm> _alarms;
	public OperationPool() {
		this._alarms = new ArrayList<Alarm>();
	}
	public void add(Alarm a) {
		this._alarms.add(a);
	}
	
	public void remove(Alarm a) {
		this._alarms.remove(a);
	}
}
