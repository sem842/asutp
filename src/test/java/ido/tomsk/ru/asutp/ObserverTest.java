package ido.tomsk.ru.asutp;

import junit.framework.TestCase;
class SensorSubscriber implements IObservable
{
	private int _value = 0;
	public int getTestValue() {
		return this._value;
	}
	public void handleEvent(IObserver o) {
		if (o instanceof Sensor) {
			Sensor s = (Sensor) o;
			this._value = s.getValue();
		}
	}
}
public class ObserverTest extends TestCase {
	public void testObserver() {
		Sensor s = new Sensor();
		SensorSubscriber subscriber = new SensorSubscriber();
		SensorSubscriber subscriber2 = new SensorSubscriber();
		SensorSubscriber subscriber3 = new SensorSubscriber();
		s.register(subscriber);
		s.register(subscriber2);
		s.register(subscriber3);
		assertEquals(subscriber.getTestValue(), 0);
		assertEquals(subscriber2.getTestValue(), 0);
		assertEquals(subscriber3.getTestValue(), 0);
		
		s.setValue(66);
		
		assertEquals(subscriber.getTestValue(), 66);
		assertEquals(subscriber2.getTestValue(), 66);
		assertEquals(subscriber3.getTestValue(), 66);
	}
}
