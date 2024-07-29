package javaswing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Question5 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Button Click Example");
		final JLabel label = new JLabel("Initial Text", JLabel.CENTER);
		JButton button = new JButton("Click Me");

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText("Text Changed!");
			}
		});

		frame.setLayout(new java.awt.BorderLayout());
		frame.add(label, java.awt.BorderLayout.CENTER);
		frame.add(button, java.awt.BorderLayout.SOUTH);
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
