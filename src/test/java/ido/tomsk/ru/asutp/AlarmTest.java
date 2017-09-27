package ido.tomsk.ru.asutp;

import junit.framework.TestCase;

public class AlarmTest extends TestCase {
	public void testAlarm() {
		Alarm a = new Alarm();
		assertNotNull(a);
		OperationPool p = new OperationPool();
		assertNotNull(p);
		Sensor s = new Sensor();
		s.setMinValue(0);
		s.setMaxValue(100);
		assertNotNull(s);
		s.register(a); //регистрация аларма
		a.setOPool(p); //теперь аларм знает о пуле
		a.setLogicF((v) -> {return v >= 85;}); //also is: function(v) { return v >= 85; }
		for ( int i = 0; i < 100; i++ ) {
			s.setValue(i);
		}
	}
}
