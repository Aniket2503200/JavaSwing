package javaswing;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Question23 {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				// Set the look and feel to Nimbus, Metal, or Windows
				// UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
				// // Metal
				UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); // Nimbus
				// UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				// // Windows
			} catch (Exception e) {
				e.printStackTrace();
			}

			// Create the main frame
			JFrame frame = new JFrame("Look and Feel Example");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(400, 200);
			frame.setLayout(new BorderLayout());

			// Create a label
			JLabel label = new JLabel("This is a " + UIManager.getLookAndFeel().getName() + " look and feel",
					JLabel.CENTER);

			// Create a button
			JButton button = new JButton("Click Me");

			// Add action listener to the button
			button.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Button clicked!"));

			// Add components to the frame
			frame.add(label, BorderLayout.CENTER);
			frame.add(button, BorderLayout.SOUTH);

			// Display the frame
			frame.setVisible(true);
		});
	}
}
