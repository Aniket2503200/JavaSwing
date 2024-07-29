package javaswing;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Question19 {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			// Create the main frame
			JFrame frame = new JFrame("Custom Dialog Example");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(400, 300);
			frame.setLayout(new FlowLayout());

			// Add a button to open the custom dialog
			JButton openDialogButton = new JButton("Open Custom Dialog");
			openDialogButton.addActionListener(e -> openCustomDialog(frame));
			frame.add(openDialogButton);

			// Display the frame
			frame.setVisible(true);
		});
	}

	private static void openCustomDialog(JFrame parentFrame) {
		// Create the custom dialog
		JDialog dialog = new JDialog(parentFrame, "Custom Dialog", true);
		dialog.setLayout(new GridLayout(4, 2, 10, 10));
		dialog.setSize(300, 200);
		dialog.setLocationRelativeTo(parentFrame);

		// Add components to the dialog
		JLabel nameLabel = new JLabel("Name:");
		JTextField nameField = new JTextField();
		JLabel emailLabel = new JLabel("Email:");
		JTextField emailField = new JTextField();

		JButton submitButton = new JButton("Submit");
		JButton cancelButton = new JButton("Cancel");

		dialog.add(nameLabel);
		dialog.add(nameField);
		dialog.add(emailLabel);
		dialog.add(emailField);
		dialog.add(submitButton);
		dialog.add(cancelButton);

		// Add action listeners for buttons
		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String email = emailField.getText();
				JOptionPane.showMessageDialog(dialog, "Submitted!\nName: " + name + "\nEmail: " + email);
				dialog.dispose(); // Close the dialog
			}
		});

		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.dispose(); // Close the dialog
			}
		});

		// Display the dialog
		dialog.setVisible(true);
	}
}
