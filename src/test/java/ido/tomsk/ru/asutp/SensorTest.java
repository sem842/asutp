package ido.tomsk.ru.asutp;

import junit.framework.TestCase;

public class SensorTest extends TestCase {
	public void testSensor() {
		Sensor s = new Sensor();
		assertNotNull(s);
		s.setValue(50);		
		s.setMinValue(1);
		s.setMaxValue(100);
		s.setType(1);
		assertEquals(s.getValue(), 50);
		assertEquals(s.getMinValue(), 1);
		assertEquals(s.getMaxValue(), 100);
		assertEquals(s.getType(), 1);
		
		Sensor s2 = new Sensor(12, 5, 20, 2);
		assertEquals(s2.getValue(), 12);
		assertEquals(s2.getMinValue(), 5);
		assertEquals(s2.getMaxValue(), 20);
		assertEquals(s2.getType(), 2);
	}
}
