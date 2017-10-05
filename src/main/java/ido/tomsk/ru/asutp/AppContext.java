package ido.tomsk.ru.asutp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//декларативное описание
//bean - экз.класса (бобы) 
//@ - аннотация. во время компиляции 
@Configuration
public class AppContext {
	@Bean
	public OperationPool oPool() {
		OperationPool p = new OperationPool();
		return p;
	}
	@Bean
	public HistoryPool hPool() {
		HistoryPool p = new HistoryPool();
		return p;
	}
	@Bean
	public DStrategy dStrategy1() {
		DStrategy s = new DStrategy(50);
		return s;
	}
	@Bean
	public DStrategy dStrategy2() {
		DStrategy s = new DStrategy(10);
		return s;
	}
	@Bean
	public AStrategy aStrategy1() {
		AStrategy s = new AStrategy(10);
		return s;
	}
	@Bean
	public AStrategy aStrategy2() {
		AStrategy s = new AStrategy(10);
		return s;
	}	
	@Bean 
	public DRender render1() {
		DRender r = new DRender();
		r.setX(50);
		r.setY(50);
		r.setWidth(30);
		r.setHeight(30);
		return r;
	}
	@Bean 
	public ARender render2() {
		ARender r = new ARender();
		r.setX(100);
		r.setY(50);
		r.setWidth(30);
		r.setHeight(100);
		return r;
	}
	@Bean
	public Sensor sensor1() {
		Sensor s = new Sensor();
		s.register(alarm1());
		s.register(alarm2());
		s.setEmulationStrategy(dStrategy1());
		s.register(render1());
		s.setValue(-1);
		return s;
	}
	@Bean
	public Sensor sensor2() {
		Sensor s = new Sensor();
		s.setMinValue(0);
		s.setMaxValue(100);
		s.setEmulationStrategy(aStrategy1());
		s.register(render2());
		s.register(alarm3());
		s.register(alarm4());
		s.register(alarm5());
		s.register(alarm6());
		s.register(alarm7());
		s.setValue(1);
		return s;
	}
	@Bean
	public Alarm alarm1() {
		Alarm a = new Alarm();
		a.setId(1);
		a.setOPool(oPool());
		a.setHPool(hPool());
		a.setStatus(1);
		a.setName("Датчик №1. Превышена загазованность!");
		a.setLogicF((v) -> {return v == 1; });
		a.register(render1());
		return a;
	}
	@Bean
	public Alarm alarm2() {
		Alarm a = new Alarm();
		a.setId(2);
		a.setOPool(oPool());
		a.setHPool(hPool());
		a.setStatus(3);
		a.setName("Датчик №1. Загазованность в норме!");
		a.setLogicF((v) -> {return v == 0; });
		a.register(render1());
		return a;
	}
	@Bean
	public Alarm alarm3() {
		Alarm a = new Alarm();
		a.setId(3);
		a.setOPool(oPool());
		a.setHPool(hPool());
		a.setStatus(1);
		a.setName("Датчик №2. Минимальное критическое значение!");
		a.setLogicF((v) -> {return v <= 15; });
		a.register(render2());
		return a;
	}
	public Alarm alarm4() {
		Alarm a = new Alarm();
		a.setId(4);
		a.setOPool(oPool());
		a.setHPool(hPool());
		a.setStatus(2);
		a.setName("Датчик №2. Минимальное предельное значение!");
		a.setLogicF((v) -> {return v > 15 && v <= 30; });
		a.register(render2());
		return a;
	}
	public Alarm alarm5() {
		Alarm a = new Alarm();
		a.setId(5);
		a.setOPool(oPool());
		a.setHPool(hPool());
		a.setStatus(3);
		a.setName("Датчик №2. Норма!");
		a.setLogicF((v) -> {return v > 30 && v <= 70; });
		a.register(render2());
		return a;
	}
	public Alarm alarm6() {
		Alarm a = new Alarm();
		a.setId(6);
		a.setOPool(oPool());
		a.setHPool(hPool());
		a.setStatus(2);
		a.setName("Датчик №2. Максимальное предельное значение!");
		a.setLogicF((v) -> {return v > 70 && v <= 85; });
		a.register(render2());
		return a;
	}
	public Alarm alarm7() {
		Alarm a = new Alarm();
		a.setId(7);
		a.setOPool(oPool());
		a.setHPool(hPool());
		a.setStatus(1);
		a.setName("Датчик №2. Максимальное критическое значение!");
		a.setLogicF((v) -> {return v > 85; });
		a.register(render2());
		return a;
	}
	@Bean
	public List<Sensor> sensors()
	{
		List<Sensor> sensors = new ArrayList<Sensor>();
		sensors.add(sensor1());
		sensors.add(sensor2());
		return sensors;
	}
	@Bean
	public List<BasicRender> renders()
	{
		List<BasicRender> renders = new ArrayList<BasicRender>();
		renders.add(render1());
		renders.add(render2());
		return renders;
	}
}
