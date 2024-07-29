package javaswing;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Question10 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("BoxLayout Example");

		JPanel verticalPanel = new JPanel();
		verticalPanel.setLayout(new BoxLayout(verticalPanel, BoxLayout.Y_AXIS));

		for (int i = 1; i <= 3; i++) {
			verticalPanel.add(new JButton("Button " + i));
		}

		JPanel horizontalPanel = new JPanel();
		horizontalPanel.setLayout(new BoxLayout(horizontalPanel, BoxLayout.X_AXIS));

		for (int i = 4; i <= 6; i++) {
			horizontalPanel.add(new JButton("Button " + i));
		}

		frame.setLayout(new java.awt.BorderLayout());
		frame.add(verticalPanel, java.awt.BorderLayout.NORTH);
		frame.add(horizontalPanel, java.awt.BorderLayout.CENTER);

		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
