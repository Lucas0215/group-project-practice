package practice;

import java.awt.*;

import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;

public class PointExample extends JFrame {

	public PointExample() {
		super("START");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new JPanelDrawLineTool());

		setSize(320, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new PointExample();
	}
}

class JPanelDrawLineTool extends JPanel {
	Vector<Point> pointList = new Vector<Point>();
	Color c;

	public JPanelDrawLineTool() {
		pointList.add(new Point(-1, 0));
		NewMouseListener listener = new NewMouseListener();

		addMouseListener(listener);
		addMouseMotionListener(listener);
		addKeyListener(new NewKeyListener());

		setFocusable(true);
		requestFocus();
	}

	class NewMouseListener implements MouseListener, MouseMotionListener {

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
			Point nullPoint = new Point(0, 0);
			pointList.add(nullPoint);
		}

		public void mouseClicked(MouseEvent e) {
		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mouseDragged(MouseEvent e) {
			Point newPoint = e.getPoint();
			pointList.add(newPoint);
			repaint();
		}

		public void mouseMoved(MouseEvent e) {
		}

	}

	class NewKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch (keyCode) {
			case KeyEvent.VK_1:
				Point black = new Point(-1, 0);
				pointList.add(black);
				repaint();
				break;
			case KeyEvent.VK_2:
				Point red = new Point(-2, 0);
				pointList.add(red);
				repaint();
				break;
			case KeyEvent.VK_3:
				Point green = new Point(-3, 0);
				pointList.add(green);
				repaint();
				break;
			case KeyEvent.VK_4:
				Point blue = new Point(-4, 0);
				pointList.add(blue);
				repaint();
				break;
			case KeyEvent.VK_0:
				Point white = new Point(-5, 0);
				pointList.add(white);
				repaint();
				break;
			}

		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (int i = -1; i < pointList.size() - 1; i++) {
			if (pointList.elementAt(i + 1).getX() < 0) {
				switch ((int) pointList.elementAt(i + 1).getX()) {
				case -1:
					c = Color.BLACK;
					i = i + 2;
					break;
				case -2:
					c = Color.RED;
					i = i + 2;
					break;
				case -3:
					c = Color.GREEN;
					i = i + 2;
					break;
				case -4:
					c = Color.BLUE;
					i = i + 2;
					break;
				case -5:
					c = Color.WHITE;
					i = i + 2;
					break;
				}
				continue;
			}
			else if (pointList.elementAt(i + 1).getX() == 0 && pointList.elementAt(i + 1).getY() == 0) {
				i = i + 2;
				continue;
			}
			g.setColor(c);
			Point startPoint = pointList.elementAt(i);
			Point endPoint = pointList.elementAt(i + 1);
			g.drawLine((int) startPoint.getX(), (int) startPoint.getY(), (int) endPoint.getX(), (int) endPoint.getY());
		}
	}
}
