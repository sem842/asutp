package ido.tomsk.ru.asutp;

import java.awt.Color;
import java.awt.Graphics;

public class DRender extends BasicRender {
	@Override
	public void draw(Graphics g) {
		/*
		if (this.getCurrentValue() == 0) {
			g.setColor(Color.GRAY);
		} else {
			g.setColor(this.getCurrentColor());
		}
		*/
		g.setColor(this.getCurrentColor());
		g.fillOval(this.getX(),
				   this.getY(),
				   this.getWidth(),
				   this.getHeight());
	}
}
