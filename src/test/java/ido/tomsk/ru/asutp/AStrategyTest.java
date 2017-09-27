package ido.tomsk.ru.asutp;

import junit.framework.TestCase;

public class AStrategyTest extends TestCase {
	public void testAStrategy() {
		Sensor s = new Sensor(0, 0, 100, 1);
		AStrategy strategy = new AStrategy(3);
		s.setEmulationStrategy(strategy);
		for (int i = 0; i < 1000; i++) {
			s.emulate();
			switch (i) {
			case 0:
				assertEquals(s.getValue(), s.getMinValue());
			break;
			case 150:
				assertEquals(s.getValue(), 50);
			break;
			case 300:
				assertEquals(s.getValue(), s.getMaxValue());
			break;
			case 450:
				assertEquals(s.getValue(), 50);
			break;
			case 600:
				assertEquals(s.getValue(), s.getMinValue());
			break;
			}
		}		
	}
}
