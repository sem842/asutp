package ido.tomsk.ru.asutp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//декларативное описание
//bean - экз.класса (бобы)
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
		DStrategy s = new DStrategy(5);
		return s;
	}
	@Bean
	public DStrategy dStrategy2() {
		DStrategy s = new DStrategy(10);
		return s;
	}
	@Bean
	public AStrategy aStrategy1() {
		AStrategy s = new AStrategy(5);
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
		return r;
	}
	@Bean
	public Sensor sensor1() {
		Sensor s = new Sensor();
		s.setEmulationStrategy(dStrategy1());
		s.register(render1());
		s.setValue(666);
		return s;
	}
	@Bean
	public List<Sensor> sensors()
	{
		List<Sensor> sensors = new ArrayList<Sensor>();
		sensors.add(sensor1());
		return sensors;
	}
	@Bean
	public List<BasicRender> renders()
	{
		List<BasicRender> renders = new ArrayList<BasicRender>();
		return renders;
	}
}
