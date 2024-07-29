package javaswing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Question6 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Simple Form");
		JLabel label = new JLabel("Enter text and click the button:");
		final JTextField textField = new JTextField(20);
		JButton button = new JButton("Display Text");
		final JLabel displayLabel = new JLabel();

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayLabel.setText(textField.getText());
			}
		});

		frame.setLayout(new java.awt.FlowLayout());
		frame.add(label);
		frame.add(textField);
		frame.add(button);
		frame.add(displayLabel);
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
