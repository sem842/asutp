package ido.tomsk.ru.asutp;

import junit.framework.TestCase;

public class AlarmTest extends TestCase {
	public void testAlarm() {
		Alarm a = new Alarm();
		assertNotNull(a);
		OperationPool p = new OperationPool();
		HistoryPool h = new HistoryPool("d://history_alarm.log");
		assertNotNull(p);
		assertNotNull(h);
		
		Sensor s = new Sensor();
		s.setMinValue(0);
		s.setMaxValue(100);
		assertNotNull(s);
		s.register(a); //регистрация аларма
		a.setId(1);
		a.setName("Превышена температура");
		a.setOPool(p); //теперь аларм знает о пуле
		a.setHPool(h); 
		a.setLogicF((v) -> {return v >= 85;}); //also is: function(v) { return v >= 85; }
		for ( int i = 0; i < 100; i++ ) {
			s.setValue(i);
		}
		System.out.println(p.alarms().get(0));
		assertEquals(alarmsAmount(p, 1, true, false), 1);
		assertEquals(p.alarms().size(), 1);
		s.setValue(1);
		System.out.println(p.alarms().get(0));
		assertEquals(alarmsAmount(p, 1, false, false), 1);
		s.setValue(90);
		System.out.println(p.alarms().get(0));
		System.out.println(p.alarms().get(0));
		assertEquals(p.alarms().size(), 2);
		p.cvitByListIndex(1);
		assertEquals(alarmsAmount(p, 1, true, true), 1);
		p.cvitByListIndex(0);
		s.setValue(50);
		assertEquals(p.alarms().size(), 0);
	}
	private int alarmsAmount(OperationPool p,
			 				 int id, 
			 				 boolean isActive, 
			 				 boolean isCvited) {
		int res = 0;
		for (Alarm a: p.alarms()) {
			if (a.getId() == id &&
				a.isActive() == isActive &&
				a.isCvited() == isCvited) {
				res++;
			}
		}
		return res;
	}
}
