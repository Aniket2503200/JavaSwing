package javaswing;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Question12 {
	private static JPanel panel;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Color Change Example");
		panel = new JPanel(); // Make panel an instance variable

		JButton redButton = new JButton("Red");
		JButton greenButton = new JButton("Green");
		JButton blueButton = new JButton("Blue");

		redButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setBackground(Color.RED);
			}
		});

		greenButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setBackground(Color.GREEN);
			}
		});

		blueButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setBackground(Color.BLUE);
			}
		});

		panel.add(redButton);
		panel.add(greenButton);
		panel.add(blueButton);

		frame.add(panel);
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
