package ido.tomsk.ru.asutp;

import junit.framework.TestCase;

public class DStrategyTest extends TestCase {
	public void testDStrategy() {
		Sensor s = new Sensor();
		DStrategy strategy = new DStrategy(3);
		assertEquals(s.getValue(), 0);
		strategy.doEmulate(s);
		assertEquals(s.getValue(), 0);
		strategy.doEmulate(s);
		assertEquals(s.getValue(), 0);
		strategy.doEmulate(s);
		assertEquals(s.getValue(), 1);
		strategy.doEmulate(s);
		assertEquals(s.getValue(), 1);
		strategy.doEmulate(s);
		assertEquals(s.getValue(), 1);
		strategy.doEmulate(s);
		assertEquals(s.getValue(), 0);
		strategy.doEmulate(s);		
		assertEquals(s.getValue(), 0);
	}
}
