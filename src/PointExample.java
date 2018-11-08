import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;
import java.awt.geom.*;

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
	static int thickness = 1, size=1;

	Color selectedColor;
	Graphics g;
	Graphics2D g2;

	public JPanelDrawLineTool() {
		NewMouseListener listener = new NewMouseListener();

		addMouseListener(listener);
		addMouseMotionListener(listener);
		addKeyListener(new NewKeyListener());

		setFocusable(true);
		requestFocus();
	}

	class NewMouseListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			Point newPoint = e.getPoint();
			pointList.add(newPoint);
		}

		public void mouseReleased(MouseEvent e) {
			Point stopPoint = new Point(0, 0);
			pointList.add(stopPoint);
		}

		public void mouseDragged(MouseEvent e) {
			g=getGraphics();
			g2=(Graphics2D) g;
			
			Point newPoint = e.getPoint();
			pointList.add(newPoint);
			System.out.println(pointList.size());

			Point start = pointList.elementAt(pointList.size() - 2);
			Point end = pointList.elementAt(pointList.size() - 1);
			
			g.setColor(selectedColor);
			g2.setStroke(new BasicStroke(thickness, BasicStroke.CAP_ROUND, 0));
			g2.draw(new Line2D.Double(start.getX(), start.getY(), end.getX(), end.getY()));
		}
		public void mouseClicked(MouseEvent e) {
			g=getGraphics();
			
			g.fillOval(e.getX(), e.getY(), size, size);
		}
	}

	class NewKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			switch (keyCode) {

			case KeyEvent.VK_1:
				selectedColor=Color.BLACK;
				break;

			case KeyEvent.VK_2:
				selectedColor=Color.RED;
				break;

			case KeyEvent.VK_3:
				selectedColor=Color.GREEN;
				break;

			case KeyEvent.VK_4:
				selectedColor=Color.BLUE;
				break;

			case KeyEvent.VK_5:
				selectedColor=Color.WHITE;
				break;
			}

		}

	}
}

class JPanelMenu extends JPanel {
	public JPanelMenu() {
		JButton button = new JButton("Light");
		add(button);
		setBackground(Color.DARK_GRAY);
		button.addActionListener(new NeewMouseListener());
	}

	class NeewMouseListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton g = (JButton) e.getSource();
			if (g.getText().equals("Light")) {
				JPanelDrawLineTool.thickness = 3;
				JPanelDrawLineTool.size=3;
				g.setText("Medium");
			} else if (g.getText().equals("Medium")) {
				JPanelDrawLineTool.thickness = 5;
				JPanelDrawLineTool.size=5;
				g.setText("Bold");
			} else if (g.getText().equals("Bold")) {
				JPanelDrawLineTool.thickness = 10;
				JPanelDrawLineTool.size=10;
				g.setText("Extra");
			} else if (g.getText().equals("Extra")) {
				JPanelDrawLineTool.thickness = 1;
				JPanelDrawLineTool.size=1;
				g.setText("Light");
			}
		}
	}
}
