package ido.tomsk.ru.asutp;

import java.awt.Color;
import java.awt.Graphics;

public class ARender extends BasicRender {
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(this.getX(),
				   this.getY(),
				   this.getWidth() + 1,
				   this.getHeight() +2);
		g.setColor(Color.GRAY);
		
		g.fillRect(this.getX() + 1,
				   this.getY() + 1,
				   this.getWidth(),
				   this.getHeight() + 1 - this.getCurrentValue());
		
		g.setColor(this.getCurrentColor());
		
		g.fillRect(this.getX() + 1,
				   this.getY() + this.getHeight() + 2 - this.getCurrentValue(),
				   this.getWidth(),
				   this.getCurrentValue());
	}
}
