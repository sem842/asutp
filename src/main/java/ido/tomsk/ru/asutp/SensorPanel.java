package ido.tomsk.ru.asutp;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

public class SensorPanel extends JPanel {
	private List<BasicRender> _renders;
	public SensorPanel(List<BasicRender> renders) {
		this._renders = renders;
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//g.setColor(Color.white);
		//g.fillRect(100, 100, 40, 70);
		for(BasicRender render: this._renders) {
			render.draw(g);
		}
	}
	
}
