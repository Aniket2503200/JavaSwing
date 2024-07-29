package javaswing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Question11 {
	public static void main(String[] args) {
		// Create the frame
		JFrame frame = new JFrame("Event Handling Example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 200);

		// Create the button
		JButton button = new JButton("Click Me");

		// Create the text field
		final JTextField textField = new JTextField(20); // Make sure textField is final

		// Create the ActionListener
		MyActionListener listener = new MyActionListener(frame, textField);

		// Add ActionListener to the button
		button.addActionListener(listener);

		// Create a panel to hold the button and text field
		JPanel panel = new JPanel();
		panel.add(textField);
		panel.add(button);

		// Add the panel to the frame
		frame.add(panel);

		// Make the frame visible
		frame.setVisible(true);
	}
}

// Separate class for the ActionListener
class MyActionListener implements ActionListener {
	private final JFrame frame;
	private final JTextField textField;

	// Constructor
	public MyActionListener(JFrame frame, JTextField textField) {
		this.frame = frame;
		this.textField = textField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Display a message dialog when the button is clicked
		String text = textField.getText();
		JOptionPane.showMessageDialog(frame, "Button clicked! Text: " + text);
	}
}
