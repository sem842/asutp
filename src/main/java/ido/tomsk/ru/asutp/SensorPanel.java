package ido.tomsk.ru.asutp;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class SensorPanel extends JPanel {
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.white);
		g.fillRect(100, 100, 40, 70);
	}
	
}
