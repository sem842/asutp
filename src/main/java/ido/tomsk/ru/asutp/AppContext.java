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
		DStrategy s = new DStrategy(15);
		return s;
	}
	@Bean
	public DStrategy dStrategy2() {
		DStrategy s = new DStrategy(10);
		return s;
	}
	@Bean
	public AStrategy aStrategy1() {
		AStrategy s = new AStrategy(1);
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
		s.setEmulationStrategy(dStrategy1());
		s.register(render1());
		s.setValue(0);
		return s;
	}
	@Bean
	public Sensor sensor2() {
		Sensor s = new Sensor();
		s.setMinValue(0);
		s.setMaxValue(100);
		s.setEmulationStrategy(aStrategy1());
		s.register(render2());
		s.setValue(0);
		return s;
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
