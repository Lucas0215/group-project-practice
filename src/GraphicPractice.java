package practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GraphicPractice extends JFrame {
	public GraphicPractice() {
		super("타원그리기예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new MyPanel());

		setSize(300, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GraphicPractice();
	}

	class MyPanel extends JPanel {
		private Point start = null, end = null;

		public MyPanel() {
			YourMouseListener listener = new YourMouseListener();
			addMouseListener(listener);
			addMouseMotionListener(listener);
		}

		class YourMouseListener extends MouseAdapter {
			public void mousePressed(MouseEvent e) {
				start = e.getPoint();
			}

			public void mouseDragged(MouseEvent e) {
				end = e.getPoint();
				repaint();
				System.out.println((int)start.getX() +" "+ (int)start.getY());
			}
			public void mouseClicked(MouseEvent e) {
				start=e.getPoint();
				end=start;
				repaint();
			}
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (start == null)
				return;

			g.setColor(Color.BLACK);
			g.drawLine((int)start.getX(), (int)start.getY(), (int)end.getX(), (int)end.getY());
		}
	}
}