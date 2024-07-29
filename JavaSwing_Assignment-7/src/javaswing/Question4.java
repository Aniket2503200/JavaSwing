package javaswing;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Question4 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("My First Swing Application");
		JLabel label = new JLabel("Hello, World!", JLabel.CENTER);
		frame.add(label);
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
