package javaswing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Question1 {
	public static void main(String[] args) {
		// Ensure that the GUI creation is done on the Event Dispatch Thread
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				// Create the main application window
				final JFrame frame = new JFrame("Simple Swing Application");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(300, 200);

				// Create a button
				JButton button = new JButton("Click Me");

				// Add an action listener to handle button clicks
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Display a message dialog when the button is clicked
						JOptionPane.showMessageDialog(frame, "Button Clicked!");
					}
				});

				// Add the button to the frame's content pane
				frame.getContentPane().add(button);

				// Make the window visible
				frame.setVisible(true);
			}
		});
	}
}
