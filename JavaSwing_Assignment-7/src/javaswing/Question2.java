package javaswing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Question2 {
	public static void main(String[] args) {
		// Create the main application window
		final JFrame frame = new JFrame("Swing Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);

		// Create a panel to hold the components
		JPanel panel = new JPanel();

		// Create a label
		JLabel label = new JLabel("Enter your name:");

		// Create a text field
		final JTextField textField = new JTextField(20);

		// Create a button
		JButton button = new JButton("Submit");

		// Add an action listener to the button
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Display a message dialog with the text from the text field
				JOptionPane.showMessageDialog(frame, "Hello, " + textField.getText() + "!");
			}
		});

		// Add components to the panel
		panel.add(label);
		panel.add(textField);
		panel.add(button);

		// Add the panel to the frame
		frame.getContentPane().add(panel);

		// Make the window visible
		frame.setVisible(true);
	}
}
