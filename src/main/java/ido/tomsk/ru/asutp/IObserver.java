package ido.tomsk.ru.asutp;

public interface IObserver {
	void register(IObservable o);
	void unregister(IObservable o);
	void notifyObservables();
}
