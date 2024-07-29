package javaswing;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Question25 {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			// Create the main frame
			JFrame frame = new JFrame("Login Form");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(300, 150);
			frame.setLayout(new GridLayout(3, 2, 10, 10));

			// Create components
			JLabel userLabel = new JLabel("Username:");
			JTextField userField = new JTextField();
			JLabel passLabel = new JLabel("Password:");
			JPasswordField passField = new JPasswordField();
			JButton loginButton = new JButton("Login");
			JButton cancelButton = new JButton("Cancel");

			// Add components to frame
			frame.add(userLabel);
			frame.add(userField);
			frame.add(passLabel);
			frame.add(passField);
			frame.add(loginButton);
			frame.add(cancelButton);

			// Add action listener for Login button
			loginButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String username = userField.getText();
					String password = new String(passField.getPassword());

					if (username.isEmpty() || password.isEmpty()) {
						JOptionPane.showMessageDialog(frame, "Username and Password cannot be empty.", "Input Error",
								JOptionPane.ERROR_MESSAGE);
					} else {
						// Perform login logic here
						JOptionPane.showMessageDialog(frame, "Login Successful!", "Success",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			});

			// Add action listener for Cancel button
			cancelButton.addActionListener(e -> frame.dispose());

			// Display the frame
			frame.setVisible(true);
		});
	}
}
