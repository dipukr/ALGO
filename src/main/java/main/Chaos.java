package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Chaos extends JPanel {
	private static final Random rand = new Random();
	private static final int W = 1920;
	private static final int H = 1080;

	public class Ball {
		private int x;
		private int y;
		private int r;
		private int dx;
		private int dy;
		private Color color;

		public Ball(int x, int y, int r, int dx, int dy) {
			this.x = x;
			this.y = y;
			this.r = r;
			this.dx = dx;
			this.dy = dy;
			this.color = new Color(rand.nextInt(255),
					rand.nextInt(255),
					rand.nextInt(255));
		}

		public void move() {
			if (x < 0 || x > W - r) dx = -dx;
			if (y < 0 || y > H - r) dy = -dy;
			x += dx;
			y += dy;
		}

		public void draw(Graphics2D gc) {
			gc.setColor(color);
			gc.fillOval(x, y, r, r);
		}
	}

	private Ball balls[] = new Ball[200];

	public Chaos() {
		for (int i = 0; i < balls.length; i++)
			balls[i] = new Ball(rand.nextInt(W / 2),
					rand.nextInt(H / 2),
					rand.nextInt(300),
					rand.nextInt(4) + 1,
					rand.nextInt(4) + 1);
		setVisible(true);
		setPreferredSize(new Dimension(W, H));
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		var gc = (Graphics2D) g;
		for (Ball ball : balls) {
			ball.draw(gc);
			ball.move();
		}
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
		}
		repaint();
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setResizable(true);
		frame.add(new Chaos(), BorderLayout.CENTER);
		frame.pack();
		Graphics2D gc = (Graphics2D) frame.getGraphics();
		gc.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
