package ido.tomsk.ru.asutp;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ListModel;

public class OperationPool {
	private List<Alarm> _alarms;
	private DefaultListModel<Alarm> _list_model_alarms;
	public OperationPool() {
		this._alarms = new CopyOnWriteArrayList<Alarm>();
		this._list_model_alarms = new DefaultListModel<Alarm>();
	}
	public List<Alarm> alarms() {
		return this._alarms;
	}
	public DefaultListModel<Alarm> alarmsModelList(){
		return this._list_model_alarms;
	}
	public void refreshModelList() {
		for (Alarm a: this._alarms) { //если в правом(ListModel) нет такого - добавляем в ListModel
			if (this._list_model_alarms.indexOf(a) == -1) {
				this._list_model_alarms.add(0, a);
			}
		}
		int size = this._list_model_alarms.size();
		for (int i = 0; i < size; i++) {//если в левом нет такого(ListAlarm) - убираем из ListModel
			Alarm a = this._list_model_alarms.elementAt(i);
			if (this._alarms.indexOf(a) == -1) {
				this._list_model_alarms.remove(i);
			}
		}
	}
	public void add(Alarm a) {
		this._alarms.add(a);
	}
	public void remove(Alarm a) {
		this._alarms.remove(a);
	}
	public void turnOff(int id) {
		for (Alarm a: this._alarms) {
			if (a.getId() == id && a.isActive()) {
				a.turnOff();
				if (a.isCvited()) {
					this.removeFromModelList(a);
					this._alarms.remove(a);
				}
			}
		}
	}
	public void cvitByListIndex (int index) {
		Alarm a = this._alarms.get(index);
		a.setCvited();
		if (!a.isActive()) {
			this.removeFromModelList(a);
			this._alarms.remove(index);
			
		}
	}
	private void removeFromModelList(Alarm a) {
		this._list_model_alarms.removeElement(a);
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