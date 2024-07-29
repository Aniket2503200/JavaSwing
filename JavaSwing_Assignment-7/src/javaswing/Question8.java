package javaswing;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Question8 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("BorderLayout Example");
		frame.setLayout(new java.awt.BorderLayout());

		frame.add(new JButton("NORTH"), java.awt.BorderLayout.NORTH);
		frame.add(new JButton("SOUTH"), java.awt.BorderLayout.SOUTH);
		frame.add(new JButton("EAST"), java.awt.BorderLayout.EAST);
		frame.add(new JButton("WEST"), java.awt.BorderLayout.WEST);
		frame.add(new JButton("CENTER"), java.awt.BorderLayout.CENTER);

		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
