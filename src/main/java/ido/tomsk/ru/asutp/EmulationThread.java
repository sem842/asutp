package ido.tomsk.ru.asutp;

import java.util.List;

import javax.swing.JPanel;

public class EmulationThread extends Thread {
	private List<Sensor> _sensors;
	private JPanel _panel;
	public EmulationThread(List<Sensor> sensors, JPanel panel) {
		this._sensors = sensors;
		this._panel = panel;
	}
	@Override
	public void run() {
		while(true) {
			try {
				for(Sensor sensor: this._sensors) {
					sensor.emulate();
				}
				this._panel.repaint();
				sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
