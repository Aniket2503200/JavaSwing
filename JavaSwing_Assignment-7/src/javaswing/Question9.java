package javaswing;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Question9 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("GridLayout Example");
		frame.setLayout(new GridLayout(3, 3));

		for (int i = 1; i <= 9; i++) {
			frame.add(new JButton("Button " + i));
		}

		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
