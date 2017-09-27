package ido.tomsk.ru.asutp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

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
    private JFrame initFrame(JPanel panel)
    {
    	JFrame f = new JFrame();
    	f.setBounds(100, 100, 500, 500);
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	panel.setBackground(Color.lightGray);
    	f.getContentPane().add(panel, BorderLayout.CENTER);
    	return f;
    }
    public App() {
    	JPanel panel = new SensorPanel();
    	this.frame = this.initFrame(panel);
    	
    }
}
