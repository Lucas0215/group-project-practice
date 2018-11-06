import java.awt.*;

import javax.swing.*;

public class JFrameMain extends JFrame {
	public JFrameMain() {
		super("과제낸 재민이");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel northPanel = new JPanelNorth();
		JPanel centerPanel = new JPanelCenter();

		Container container = getContentPane();
		container.add(northPanel, BorderLayout.NORTH);
		container.add(centerPanel, BorderLayout.CENTER);

		setSize(300, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new JFrameMain();
	}
}

class JPanelNorth extends JPanel {
	public JPanelNorth() {
		setLayout(new FlowLayout());
		setBackground(Color.RED);

		add(new JButton("아"));
		add(new JButton("2500토큰"));
		add(new JButton("언제모으냐"));
	}
}

class JPanelCenter extends JPanel {
	public JPanelCenter() {
		setLayout(null);
		setBackground(Color.CYAN);

		JLabel text1 = new JLabel("재민아");
		JLabel text2 = new JLabel("캐리를");
		JLabel text3 = new JLabel("부타캐");

		text1.setLocation(50, 40);
		text2.setLocation(100, 200);
		text3.setLocation(220, 250);

		text1.setSize(50, 50);
		text2.setSize(50, 50);
		text3.setSize(50, 50);

		add(text1);
		add(text2);
		add(text3);
	}
}
