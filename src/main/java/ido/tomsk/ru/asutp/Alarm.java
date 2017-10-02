package ido.tomsk.ru.asutp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

public class Alarm implements IObservable, IObserver {
	private List<IObservable> _observables;
	private int _id; //чтобы алгоритм аларма мог пробегать по пулу и искать себя в этом пуле
	private int _status; //статус: красный, жёлтый, зелёный
	private Date _aDate; //active date
	private Date _oDate; //off date
	private Date _cDate; //cvited date
	private Date _kDate; //kill date
	public Alarm() {
		this._observables = new ArrayList<IObservable>();
	}
	private Alarm(Alarm c) { //private constructor
		this._oPool = c.getOPool();
		this._hPool = c.getHPool();
		this._id = c.getId();
		this._name = c.getName();
		this._status = c.getStatus();
		this._isActive = true;
		this._isCvited = false;
		this._aDate = new Date();
		this._oDate = null;
		this._cDate = null;
		this._kDate = null;
		this._observables = c.getObservables();
	}
		
	private boolean _isActive; //активен или не активен
	private boolean _isCvited; //квитирован или не квитирован
	private String _name;
	private OperationPool _oPool;
	private HistoryPool _hPool;
	
	private Function<Integer, Boolean> _logicF; //принимает int, возвращает bool (лямбда выражения(?))
	//(v) -> {return v >= 85;}
		
	public List<IObservable> getObservables() {
		return this._observables;
	}
	public int getId() {
		return _id;
	}
	public void setId(int _id) {
		this._id = _id;
	}
	public int getStatus() {
		return _status;
	}
	public void setStatus(int _status) {
		this._status = _status;
	}
	public String getName() {
		return _name;
	}
	public void setName(String _name) {
		this._name = _name;
	}	
	public OperationPool getOPool() {
		return _oPool;
	}
	public void setOPool(OperationPool _oPool) {
		this._oPool = _oPool;
	}
	public HistoryPool getHPool() {
		return _hPool;
	}
	public void setHPool(HistoryPool _hPool) {
		this._hPool = _hPool;
	}
	public Function<Integer, Boolean> getLogicF() {
		return _logicF;
	}
	public void setLogicF(Function<Integer, Boolean> _logicF) {
		this._logicF = _logicF;
	}
	private String calcDate(Date d) {
		String res = "";
		if (d != null) {
			SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
			res = df.format(d);
		}
		return res;
	}
	public String toString() {
		//return "test";
		return calcDate(this._aDate) + " " + 
			   calcDate(this._oDate) + " " + 
			   calcDate(this._cDate) + " " + 
			   calcDate(this._kDate) + " " + this._name;
	}
	public void turnOff() {
		//this.notifyObservables();
		this._isActive = false;
		this._oDate = new Date();
		if (this._isCvited) {
			this._kDate = new Date();
			this._hPool.add(this);
		}
	}
	public void setCvited() {
		//this.notifyObservables();
		this._isCvited = true;
		this._cDate = new Date();
		if (!this._isActive) {
			this._kDate = new Date();
			this._hPool.add(this);
		}
	}
	public void handleEvent(IObserver o) { //когда приходит от датчика инф-я
		if (o instanceof Sensor) {
			Sensor s = (Sensor) o;
			boolean active = this.isActive(s.getValue());
			if (active) {
				if (!this._oPool.exist(this._id, active)) {
					Alarm a = new Alarm(this); //вызывается приватный конс-р
					a.notifyObservables();
					this._oPool.add(a);
				}				
			} else {
				if (this._oPool.exist(this._id, true)) {
					this._oPool.turnOff(this._id);					
				}
			}
			//this.notifyObservables();
		}
	}
	public boolean isActive() {
		return this._isActive;
	}
	public boolean isCvited() {
		return this._isCvited;
	}
	private boolean isActive(int v) {
		return this._logicF.apply(v);
	}
	@Override
	public void register(IObservable o) {
		this._observables.add(o);
	}
	@Override
	public void unregister(IObservable o) {
		this._observables.remove(o);
	}
	@Override
	public void notifyObservables() {
		for (IObservable ob: this._observables) {
			ob.handleEvent(this);
		}
	}
	
}
