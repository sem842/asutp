package ido.tomsk.ru.asutp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
	private JFrame frame;	
    public static void main( String[] args )
    {
    	EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					App window = new App();
					window.frame.setVisible(true);					
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
    		
    	});
    	
    }
    private JFrame initFrame(JPanel panel, JPanel alarmPanel)
    {
    	JFrame f = new JFrame();
    	f.setBounds(100, 100, 500, 500);
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	panel.setBackground(Color.lightGray);
    	alarmPanel.setBackground(Color.WHITE);
    	f.getContentPane().add(panel, BorderLayout.CENTER);
    	f.getContentPane().add(alarmPanel, BorderLayout.NORTH);
    	return f;
    }
    public App() {
    	ApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
    	List<Sensor> sensors = (List<Sensor>) ctx.getBean("sensors");
    	List<BasicRender> renders = (List<BasicRender>) ctx.getBean("renders");
    	OperationPool oPool = (OperationPool) ctx.getBean("oPool");
    	JPanel panel = new SensorPanel(renders);
    	JPanel alarmPanel = new AlarmPanel(oPool);
    	this.frame = this.initFrame(panel, alarmPanel);
    	EmulationThread eT = new EmulationThread(sensors, panel);
    	eT.start();
    	
    	
    }
}
