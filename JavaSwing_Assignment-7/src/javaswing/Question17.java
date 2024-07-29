package javaswing;

import javax.swing.JOptionPane;

public class Question17 {
	public static void main(String[] args) {
		// 1. Message Dialogs
		JOptionPane.showMessageDialog(null, "This is an informational message.", "Information",
				JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "This is a warning message.", "Warning", JOptionPane.WARNING_MESSAGE);
		JOptionPane.showMessageDialog(null, "This is an error message.", "Error", JOptionPane.ERROR_MESSAGE);

		// 2. Input Dialog
		String name = JOptionPane.showInputDialog(null, "Enter your name:", "Input", JOptionPane.QUESTION_MESSAGE);
		if (name != null && !name.trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Hello, " + name + "!", "Greeting", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "No name entered.", "Error", JOptionPane.ERROR_MESSAGE);
		}

		// 3. Confirmation Dialog
		int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
				JOptionPane.YES_NO_CANCEL_OPTION);
		switch (response) {
		case JOptionPane.YES_OPTION:
			JOptionPane.showMessageDialog(null, "You selected Yes.", "Response", JOptionPane.INFORMATION_MESSAGE);
			break;
		case JOptionPane.NO_OPTION:
			JOptionPane.showMessageDialog(null, "You selected No.", "Response", JOptionPane.INFORMATION_MESSAGE);
			break;
		case JOptionPane.CANCEL_OPTION:
			JOptionPane.showMessageDialog(null, "You selected Cancel.", "Response", JOptionPane.INFORMATION_MESSAGE);
			break;
		default:
			JOptionPane.showMessageDialog(null, "You closed the dialog.", "Response", JOptionPane.INFORMATION_MESSAGE);
			break;
		}
	}
}
