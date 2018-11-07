package practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;

public class PointExample extends JFrame {

	public PointExample() {
		super("START");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		JPanel workingArea = new JPanelDrawLineTool();
		JPanel menu = new JPanelMenu();

		container.add(workingArea, BorderLayout.CENTER);
		container.add(menu, BorderLayout.NORTH);

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
	public static boolean bold = false;

	public JPanelDrawLineTool() {
		NewMouseListener listener = new NewMouseListener();

		addMouseListener(listener);
		addMouseMotionListener(listener);
		addKeyListener(new NewKeyListener());

		setFocusable(true);
		requestFocus();
	}

	class NewMouseListener extends MouseAdapter {

		public void mouseReleased(MouseEvent e) {
			Point stopPoint = new Point(0, 0);
			pointList.add(stopPoint);
		}

		public void mouseDragged(MouseEvent e) {
			Point newPoint = e.getPoint();
			pointList.add(newPoint);
			repaint();
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

			case KeyEvent.VK_5:
				Point white = new Point(-5, 0);
				pointList.add(white);
				repaint();
				break;
			}

		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);

		for (int i = 0; i < pointList.size() - 1; i++) {
			if (pointList.elementAt(i).getX() > 0 && pointList.elementAt(i + 1).getX() > 0) {

				Point startPoint = pointList.elementAt(i);
				Point endPoint = pointList.elementAt(i + 1);
				g.drawLine((int) startPoint.getX(), (int) startPoint.getY(), (int) endPoint.getX(),
						(int) endPoint.getY());
			}

			else if (pointList.elementAt(i).getX() <= 0) {
				switch ((int) pointList.elementAt(i).getX()) {
				case -1:
					c = Color.BLACK;
					break;
				case -2:
					c = Color.RED;
					break;
				case -3:
					c = Color.GREEN;
					break;
				case -4:
					c = Color.BLUE;
					break;
				case -5:
					c = Color.WHITE;
					break;
				}
				g.setColor(c);
			}
		}

	}
}

class JPanelMenu extends JPanel {
	public JPanelMenu() {
		JButton button = new JButton("Bold");
		add(button);
		setBackground(Color.DARK_GRAY);
		button.addMouseListener(new NeewMouseListener());
	}

	class NeewMouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if (JPanelDrawLineTool.bold == false) {
				JPanelDrawLineTool.bold = true;
				setBackground(Color.BLACK);
			} else {
				JPanelDrawLineTool.bold = false;
				setBackground(Color.DARK_GRAY);

			}
		}

	}
}
