package login;


import java.awt.*;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;

/**
 * Custom JButton
 * 
 * @version 0.1.0
 * @author ruislan
 *         <a href="mailto:z17520@126.com" mce_href="mailto:z17520@126.com"></a>
 */
public class ATMButton extends JButton {
	private static final long serialVersionUID = 39082560987930759L;
	public static final Color BUTTON_COLOR1 = new Color(240, 255, 255);
	public static final Color BUTTON_COLOR2 = new Color(100,149,237);
	public static final Color BUTTON_FOREGROUND_COLOR = Color.BLACK;


	public ATMButton(String name) {
		setPreferredSize(new Dimension(180,45));
		setFont(new Font("΢���ź�", Font.BOLD, 22));
		setBorderPainted(false);
		setForeground(BUTTON_FOREGROUND_COLOR);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setText(name);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		int h = getHeight();
		int w = getWidth();

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint p1;
		GradientPaint p2;
		
		if (getModel().isPressed()) {
			p1 = new GradientPaint(0, 0, new Color(204, 0, 51), 0, h - 1, new Color(100, 100, 100));
			p2 = new GradientPaint(0, 1, new Color(204, 0, 51, 50), 0, h - 3, new Color(255, 255, 255, 100));
			setForeground(new Color(0,0,139));
		} else{
			p1 = new GradientPaint(0, 0, new Color(0, 0, 0), 0, h - 1, new Color(0, 0, 0));
			p2 = new GradientPaint(0, 1, new Color(0, 0, 0, 0), 0, h - 3, new Color(0, 0, 0, 50));
			setForeground(Color.BLACK);
		}
		GradientPaint gp = new GradientPaint(0.0F, 0.0F, BUTTON_COLOR1, 0.0F, h, BUTTON_COLOR2, true);
		g2d.setPaint(gp);
			RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(0, 0, w - 1, h - 1, 50, 50);
			Shape clip = g2d.getClip();
			g2d.clip(r2d);
			g2d.fillRect(0, 0, w, h);
			g2d.setClip(clip);
			g2d.setPaint(p1);
			g2d.drawRoundRect(0, 0, w - 1, h - 1, 50, 50);
			g2d.setPaint(p2);
			g2d.drawRoundRect(1, 1, w - 3, h - 3, 48, 48);

		g2d.dispose();
		super.paintComponent(g);
	}
}
