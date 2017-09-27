package ido.tomsk.ru.asutp;

import java.util.function.Function;

public class Alarm implements IObservable {
	private int _id; //чтобы алгоритм аларма мог пробегать по пулу и искать себя в этом пуле
	private int _status; //статус: красный, жёлтый, зелёный
	private boolean _isActive; //активен или не активен
	private boolean _isCvited; //квитирован или не квитирован
	private String _name;
	private OperationPool _oPool;
	private HistoryPool _hPool;
	
	private Function<Integer, Boolean> _logicF; //принимает int, возвращает bool (лямбда выражения(?))
	//(v) -> {return v >= 85;}
		
	public int getId() {
		return _id;
	}
	public void setId(int id) {
		this._id = id;
	}
	public int getStatus() {
		return _status;
	}
	public void setStatus(int status) {
		this._status = status;
	}
	public String getName() {
		return _name;
	}
	public void setName(String name) {
		this._name = name;
	}
	public OperationPool getOPool() {
		return _oPool;
	}
	public void setOPool(OperationPool oPool) {
		this._oPool = oPool;
	}
	public HistoryPool getHPool() {
		return _hPool;
	}
	public void setHPool(HistoryPool hPool) {
		this._hPool = hPool;
	}
	public Function<Integer, Boolean> getLogicF() {
		return _logicF;
	}
	public void setLogicF(Function<Integer, Boolean> logicF) {
		this._logicF = logicF;
	}
	public String toString() {
		return "test";
	}
	public void setActive() {
		//TODO
	}
	public void setCvited() {
		//TODO
	}
	private Alarm exist(int id) {//заглушка
		return null;
	}
	public void handleEvent(IObserver o) {
		if (o instanceof Sensor) {
			Sensor s = (Sensor) o;
			boolean active = this.isActive(s.getValue());			
		}
	}	
	private boolean isActive(int v) {
		return this._logicF.apply(v);
	}
	
}
